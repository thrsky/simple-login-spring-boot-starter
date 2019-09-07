package org.thrsky.spring.boot.login.service.user.impl;

import org.thrsky.spring.boot.login.exception.BaseBizException;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.properties.UserDataConfig;
import org.thrsky.spring.boot.login.service.user.UserAdapter;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 22:38 2019-08-04
 */
public class LocalFileUserAdapterImpl implements UserAdapter {

    private UserDataConfig.LocalFileConfig config;

    public LocalFileUserAdapterImpl(UserDataConfig.LocalFileConfig config) {
        this.config = config;
        this.init();
    }

    private void init() {

    }

    @Override
    public boolean login(UserModel userModel) throws BaseBizException {
        return false;
    }

    @Override
    public UserModel register(UserModel userModel) throws BaseBizException {
        return null;
    }
}
