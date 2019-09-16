package org.thrsky.spring.boot.login.service.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.thrsky.spring.boot.login.properties.UserDataConfig;
import org.thrsky.spring.boot.login.spi.ExtensionLoader;
import org.thrsky.spring.boot.login.utils.LogUtils;

import java.util.Map;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 11:09 2019-09-07
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class UserAdapterFactory {

    @Setter
    public static UserDataConfig userDataConfig;

    @Setter
    public static Map<String, UserAdapter> userAdapterMap;


    public static UserAdapter get() {
        UserAdapter userAdapter = ExtensionLoader.load(UserAdapter.class);
        if (userAdapter == null) {
            userAdapter = userAdapterMap.get(userDataConfig.getType());
        }
        if (userAdapter == null) {
            LogUtils.error(log, "not find userAdapter");
        }
        return userAdapter;
    }
}
