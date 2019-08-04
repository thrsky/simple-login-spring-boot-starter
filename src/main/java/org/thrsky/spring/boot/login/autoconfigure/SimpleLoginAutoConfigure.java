package org.thrsky.spring.boot.login.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thrsky.spring.boot.login.manager.userdata.encryption.UserDataEncryptorFactory;
import org.thrsky.spring.boot.login.properties.PropertiesHolder;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;
import org.thrsky.spring.boot.login.web.controller.UserController;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:11 2019-08-01
 */
@Configuration
@ConditionalOnClass({SimpleLoginProperties.class})
@EnableConfigurationProperties(SimpleLoginProperties.class)
@Import({LoginFilterConfiguration.class, LoginControllerConfiguration.class})
public class SimpleLoginAutoConfigure {

    @Autowired
    private SimpleLoginProperties simpleLoginProperties;

    @Bean
    @ConditionalOnMissingBean(PropertiesHolder.class)
    public PropertiesHolder propertiesHolder() {
        PropertiesHolder propertiesHolder = new PropertiesHolder();
        propertiesHolder.setSimpleLoginProperties(simpleLoginProperties);
        return propertiesHolder;
    }

    @Bean
    @ConditionalOnMissingBean(UserController.class)
    public UserController userController() {
        UserController userController = new UserController();
        return userController;
    }

    @Bean
    public UserDataEncryptorFactory userDataEncryptorFactory() {
        UserDataEncryptorFactory userDataEncryptorFactory = new UserDataEncryptorFactory();
        UserDataEncryptorFactory.setPropertiesHolder(propertiesHolder());
        return userDataEncryptorFactory;
    }
}
