package org.thrsky.spring.boot.login.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.thrsky.spring.boot.login.exception.BaseBizException;
import org.thrsky.spring.boot.login.manager.userdata.encryption.UserDataEncryption;
import org.thrsky.spring.boot.login.model.RestApiResult;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.properties.UserDataConfig;
import org.thrsky.spring.boot.login.service.user.UserAdapter;
import org.thrsky.spring.boot.login.utils.FileUtils;
import org.thrsky.spring.boot.login.utils.LogUtils;
import org.thrsky.spring.boot.login.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 22:38 2019-08-04
 */
@Slf4j
public class LocalFileUserAdapterImpl implements UserAdapter {

    private static final String DEFAULT_FILE_PATH = "";

    private UserDataConfig.LocalFileConfig config;

    private File userFile;

    private Map<String, UserModel> users = new ConcurrentHashMap<>();

    public LocalFileUserAdapterImpl(UserDataConfig.LocalFileConfig config) throws IOException {
        this.config = config;
        this.init();
    }

    private void init() throws IOException {
        if (StringUtils.isNotBlank(config.getFilepath())) {
            userFile = new File(config.getFilepath());
        }
        if (userFile == null) {
            userFile = new File(DEFAULT_FILE_PATH);
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
        }
        if (userFile == null) {
            LogUtils.error(log, "userdata file is null");
            System.exit(0);
        }
        parseUserDataFromFile();
    }

    @Override
    public RestApiResult login(UserModel userModel) throws BaseBizException {
        UserModel user = users.get(userModel.getUserName());
        if (user == null) {
            return RestApiResult.fail("用户不存在");
        }
        String password = UserDataEncryption.doEncryption(userModel.getUserPasswd(), user.getEncryType());
        return StringUtils.equals(user.getUserPasswd(), password) ?
                RestApiResult.success(user) : RestApiResult.fail("用户名密码错误");
    }

    @Override
    public synchronized RestApiResult register(UserModel userModel) throws BaseBizException {
        userModel.check();
        if (users.containsKey(userModel.getUserName())) {
            throw new BaseBizException("用户名已经被占用");
        }
        try {
            userModel.setUserPasswd(UserDataEncryption.doEncryption(userModel.getUserPasswd()));
            userModel.setEncryType(UserDataEncryption.getEncryType());
            users.put(userModel.getUserName(), userModel);
            update();
            return RestApiResult.success(userModel);
        } catch (Exception e) {
            LogUtils.error(log, e, "用户注册失败");
            return RestApiResult.fail("注册失败");
        }
    }

    /**
     * 从本地文件读取用户信息
     */
    private void parseUserDataFromFile() {
        JSONObject data = JSON.parseObject(FileUtils.readFromFile(userFile));
        data.forEach((key, value) -> users.put(key, JSON.parseObject(JSON.toJSONString(value), UserModel.class)));
    }

    /**
     * 更新持久化资源
     */
    private void update() {
        //update local file
        FileUtils.clearAndWrite(userFile, JSON.toJSONString(users));
    }
}
