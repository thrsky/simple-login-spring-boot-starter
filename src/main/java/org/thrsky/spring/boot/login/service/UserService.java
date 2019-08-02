package org.thrsky.spring.boot.login.service;

import org.thrsky.spring.boot.login.model.UserModel;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:12 2019-08-01
 */
public interface UserService {

    /**
     * 用户注册
     * @param userModel userModel
     * @return
     */
    boolean register(UserModel userModel);

    /**
     * 用户登录
     * @param userModel userModel
     * @return
     */
    boolean login(UserModel userModel);
}
