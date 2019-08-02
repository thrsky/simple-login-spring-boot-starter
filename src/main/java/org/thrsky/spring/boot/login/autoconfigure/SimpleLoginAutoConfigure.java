package org.thrsky.spring.boot.login.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;

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

}
