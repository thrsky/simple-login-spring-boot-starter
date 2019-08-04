package org.thrsky.spring.boot.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.service.UserService;
import org.thrsky.spring.boot.login.service.user.UserAdapter;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 10:42 2019-08-03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAdapter userAdapter;

    @Override
    public boolean register(UserModel userModel) {
        return false;
    }

    @Override
    public boolean login(UserModel userModel) {
        return false;
    }
}
