package org.thrsky.spring.boot.login.service.user;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.thrsky.spring.boot.login.model.RestApiResult;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.utils.LogUtils;

import java.util.Objects;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:12 2019-08-01
 */
@Slf4j
public class UserService {

    private static final UserService instance = new UserService();

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
    public RestApiResult register(UserModel userModel) {
        Objects.requireNonNull(userAdapter);
        LogUtils.info(log, "userService.register", JSON.toJSONString(userModel));
        return userAdapter.register(userModel);
    }

    /**
     * 用户登录
     *
     * @param userModel userModel
     * @return
     */
    public RestApiResult login(UserModel userModel) {
        Objects.requireNonNull(userAdapter);
        LogUtils.info(log, "userService.login", JSON.toJSONString(userModel));
        return userAdapter.login(userModel);
    }
}
