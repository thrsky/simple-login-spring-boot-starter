package org.thrsky.spring.boot.login.manager;

import org.thrsky.spring.boot.login.model.UserModel;

/**
 * @author thrsky
 * @date 2019/8/2 10:06
 **/
public interface UserDataManager<T extends UserModel> {

    T getUserByName(String userName);

    void saveUser(T user);
}