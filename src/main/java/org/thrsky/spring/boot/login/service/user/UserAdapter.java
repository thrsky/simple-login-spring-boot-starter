package org.thrsky.spring.boot.login.service.user;

import org.thrsky.spring.boot.login.exception.BaseBizException;
import org.thrsky.spring.boot.login.model.RestApiResult;
import org.thrsky.spring.boot.login.model.Result;
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
    RestApiResult login(UserModel userModel) throws BaseBizException;

    /**
     * 注册
     *
     * @param userModel userModel
     * @return userModel
     */
    RestApiResult register(UserModel userModel) throws BaseBizException;


}
