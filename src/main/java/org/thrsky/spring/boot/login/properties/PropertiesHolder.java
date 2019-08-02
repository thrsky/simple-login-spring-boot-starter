package org.thrsky.spring.boot.login.properties;

/**
 * @author thrsky
 * @date 2019/8/2 10:23
 **/
public class PropertiesHolder {

    private static SimpleLoginProperties simpleLoginProperties;

    public static void setSimpleLoginProperties(SimpleLoginProperties simpleLoginProperties) {
        PropertiesHolder.simpleLoginProperties = simpleLoginProperties;
    }

    public static SimpleLoginProperties getSimpleLoginProperties() {
        return simpleLoginProperties;
    }
}