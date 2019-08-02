package org.thrsky.spring.boot.login.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:09 2019-08-01
 */
@ConfigurationProperties("simple.login")
public class SimpleLoginProperties {

    private String type;
}
