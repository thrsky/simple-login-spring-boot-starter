package org.thrsky.spring.boot.login.service;

import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.service.user.UserAdapter;
import org.thrsky.spring.boot.login.service.user.UserAdapterFactory;

import java.util.Objects;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:12 2019-08-01
 */
public class UserService {

    private static UserService instance = new UserService();

    private static UserAdapter userAdapter = UserAdapterFactory.get();

    public static UserService getInstance() {
        return instance;
    }

    private UserService() {
        //
    }

    /**
     * 用户注册
     *
     * @param userModel userModel
     * @return
     */
    public UserModel register(UserModel userModel) {
        Objects.requireNonNull(userAdapter);
        return userAdapter.register(userModel);
    }

    /**
     * 用户登录
     *
     * @param userModel userModel
     * @return
     */
    public Boolean login(UserModel userModel) {
        Objects.requireNonNull(userAdapter);
        return userAdapter.login(userModel);
    }
}
