package org.thrsky.spring.boot.login.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thrsky.spring.boot.login.manager.userdata.encryption.UserDataEncryptorFactory;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;

import javax.annotation.PostConstruct;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:11 2019-08-01
 */
@Configuration
@ConditionalOnClass({SimpleLoginProperties.class})
@EnableConfigurationProperties(SimpleLoginProperties.class)
@Import({LoginFilterConfiguration.class})
public class SimpleLoginAutoConfigure {

    @Autowired
    private SimpleLoginProperties simpleLoginProperties;

    @PostConstruct
    public void setUp() {
        UserDataEncryptorFactory.setProperties(simpleLoginProperties);
    }
}
