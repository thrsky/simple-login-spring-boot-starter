package org.thrsky.spring.boot.login.manager.userdata.encryption;

import lombok.Setter;
import org.thrsky.spring.boot.login.encryptor.IEncryptor;
import org.thrsky.spring.boot.login.encryptor.Md5Encryptor;
import org.thrsky.spring.boot.login.properties.EncryConfig;
import org.thrsky.spring.boot.login.utils.StringUtils;

/**
 * @author thrsky
 * @date 2019/8/2 10:15
 **/
public class UserDataEncryptorFactory {

    private static final String MD5 = "md5";

    private static final String DEFAULT_TYPE = MD5;

    private static final Md5Encryptor md5Encryptor = new Md5Encryptor();

    @Setter
    private static EncryConfig encryConfig;

    public static IEncryptor get() {
        String type = encryConfig.getType();
        if (StringUtils.isBlank(type)) {
            type = DEFAULT_TYPE;
        }
        type = type.toLowerCase();
        return get(type);
    }

    public static IEncryptor get(String type) {
        switch (type) {
            case MD5:
                return md5Encryptor;
            default:
                return md5Encryptor;
        }
    }

    public static String getType() {
        return encryConfig.getType();
    }
}