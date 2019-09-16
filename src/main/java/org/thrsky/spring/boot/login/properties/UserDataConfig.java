package org.thrsky.spring.boot.login.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 11:19 2019-09-07
 */
@ConfigurationProperties("simple.login.user.data")
@Data
public class UserDataConfig {

    private String type;

    private String location;

    public static class MysqlConfig {
        private String url;
        private String username;
        private String password;
    }

    public static class LocalFileConfig {
        private String filepath;
    }
}
