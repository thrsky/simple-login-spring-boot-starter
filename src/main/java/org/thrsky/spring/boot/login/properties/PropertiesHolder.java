package org.thrsky.spring.boot.login.properties;

/**
 * @author thrsky
 * @date 2019/8/2 10:23
 **/

public class PropertiesHolder {

    private SimpleLoginProperties simpleLoginProperties;

    public void setSimpleLoginProperties(SimpleLoginProperties simpleLoginProperties) {
        this.simpleLoginProperties = simpleLoginProperties;
    }

    public SimpleLoginProperties getSimpleLoginProperties() {
        return this.simpleLoginProperties;
    }
}