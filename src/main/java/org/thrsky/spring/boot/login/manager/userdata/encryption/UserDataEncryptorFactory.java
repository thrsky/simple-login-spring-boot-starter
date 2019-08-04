package org.thrsky.spring.boot.login.manager.userdata.encryption;

import org.apache.commons.lang3.StringUtils;
import org.thrsky.spring.boot.login.encryptor.IEncryptor;
import org.thrsky.spring.boot.login.encryptor.Md5Encryptor;
import org.thrsky.spring.boot.login.properties.PropertiesHolder;

/**
 * @author thrsky
 * @date 2019/8/2 10:15
 **/
public class UserDataEncryptorFactory extends PropertiesHolder {

    private static String encryptorType = "md5";

    private static Md5Encryptor md5Encryptor = new Md5Encryptor();

    static {
        //todo
        if (StringUtils.isBlank(encryptorType)) {
            encryptorType = "md5";
        }
    }

    public static IEncryptor get() {
        switch (encryptorType) {
            case "md5":
                return md5Encryptor;
            default:
                return md5Encryptor;
        }
    }
}