package org.thrsky.spring.boot.login.manager.userdata.encryption;

/**
 * @author thrsky
 * @date 2019/8/2 10:13
 **/
public class UserDataEncryption {

    public static String doEncryption(String data) {
        return UserDataEncryptorFactory.get().doEncryptor(data);
    }
}