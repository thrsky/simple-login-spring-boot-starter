package org.thrsky.spring.boot.login.manager.userdata.file;

import org.thrsky.spring.boot.login.manager.UserDataManager;
import org.thrsky.spring.boot.login.model.UserModel;

/**
 * @author thrsky
 * @date 2019/8/2 10:08
 **/
public class FileUserDataManagerImpl implements UserDataManager<UserModel> {

    @Override
    public UserModel getUserByName(String userName) {
        return null;
    }

    @Override
    public void saveUser(UserModel user) {

    }
}