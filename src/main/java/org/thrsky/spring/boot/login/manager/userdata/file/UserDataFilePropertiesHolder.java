package org.thrsky.spring.boot.login.manager.userdata.file;

/**
 * @author thrsky
 * @date 2019/8/2 10:11
 **/
public class UserDataFilePropertiesHolder {

    private static String filePath;

    public static void setFilePath(final String filePath) {
        UserDataFilePropertiesHolder.filePath = filePath;
    }
}