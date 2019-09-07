package org.thrsky.spring.boot.login.service.user.impl;

import org.thrsky.spring.boot.login.exception.BaseBizException;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.properties.UserDataConfig;
import org.thrsky.spring.boot.login.service.user.UserAdapter;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 22:37 2019-08-04
 */
public class MysqlUserAdapterImpl implements UserAdapter {

    private UserDataConfig.MysqlConfig mysqlConfig;

    public MysqlUserAdapterImpl(UserDataConfig.MysqlConfig config) {
        this.mysqlConfig = config;
        init();
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
