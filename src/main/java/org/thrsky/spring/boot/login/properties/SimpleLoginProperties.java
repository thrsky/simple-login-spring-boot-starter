package org.thrsky.spring.boot.login.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:09 2019-08-01
 */
@ConfigurationProperties("simple.login")
@Data
public class SimpleLoginProperties {

    private String type;

    private String passwdEncryptorType;

    private String notFilterUrls;

    private WebStatFilter webStatFilter;

    @Data
    public static class StatViewServlet {
        private boolean enabled;
        private String  urlPattern;
        private String  adminUsername;
        private String  adminPassword;
    }

    @Data
    public static class WebStatFilter {
        private boolean enabled;
        private String  urlPattern;
        private String  exclusions;
        private String  sessionStatMaxCount;
        private String  sessionStatEnable;
        private String  principalSessionName;
        private String  principalCookieName;
        private String  profileEnable;

    }
}
