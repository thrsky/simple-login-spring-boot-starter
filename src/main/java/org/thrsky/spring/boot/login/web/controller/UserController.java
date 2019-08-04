package org.thrsky.spring.boot.login.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thrsky.spring.boot.login.model.RestApiResult;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.service.UserService;

/**
 * @author thrsky
 * @date 2019/8/2 15:28
 **/
@RestController
@RequestMapping("/user/simple")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public RestApiResult login(UserModel userModel) {
        userService.login(userModel);
        return RestApiResult.success(true);
    }

    public RestApiResult register(UserModel userModel) {
        userService.register(userModel);
        return RestApiResult.success(true);
    }
}