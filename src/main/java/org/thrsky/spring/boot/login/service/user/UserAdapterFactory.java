package org.thrsky.spring.boot.login.service.user;

import org.thrsky.spring.boot.login.service.user.impl.LocalFileUserAdapterImpl;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 11:09 2019-09-07
 */
public class UserAdapterFactory {

    private static LocalFileUserAdapterImpl localFileUserAdapter = new LocalFileUserAdapterImpl();

    public static UserAdapter get() {

        return localFileUserAdapter;
    }
}
