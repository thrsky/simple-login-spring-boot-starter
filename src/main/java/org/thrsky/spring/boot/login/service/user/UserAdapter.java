package org.thrsky.spring.boot.login.service.user;

import org.thrsky.spring.boot.login.exception.BaseBizException;
import org.thrsky.spring.boot.login.model.UserModel;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 11:32 2019-08-03
 */
public interface UserAdapter {

    /**
     * 登录
     *
     * @param userModel userModel
     * @return true:登录成功 false:登录失败
     */
    boolean login(UserModel userModel) throws BaseBizException;

    /**
     * 注册
     *
     * @param userModel userModel
     * @return userModel
     */
    UserModel register(UserModel userModel) throws BaseBizException;
}
