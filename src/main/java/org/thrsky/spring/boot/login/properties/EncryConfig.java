package org.thrsky.spring.boot.login.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 10:28 2019-09-07
 */
@ConfigurationProperties("simple.login.encry")
@Data
public class EncryConfig {

    /**
     * 文本加密算法
     */
    private String type;
}
