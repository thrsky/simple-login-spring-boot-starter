package org.thrsky.spring.boot.login.service;

import org.thrsky.spring.boot.login.model.UserModel;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:12 2019-08-01
 */
public interface UserService {

    boolean register(UserModel userModel);

    boolean login(UserModel userModel);
}
