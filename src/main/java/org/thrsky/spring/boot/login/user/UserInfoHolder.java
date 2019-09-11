package org.thrsky.spring.boot.login.user;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thrsky.spring.boot.login.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:12 2019-09-11
 */
public class UserInfoHolder {

    private static final String SESSION_KEY = "USER_SESSION_KEY";

    private UserInfoHolder() {
        //禁用构造函数
    }

    public static Long getUserId() {
        if (getUser() != null) {
            return getUser().getUserId();
        }
        return null;
    }

    public static UserModel getUser() {
        HttpSession session = getSession();
        if (session == null) {
            return null;
        }
        Object object = session.getAttribute(SESSION_KEY);
        if (object == null) {
            return null;
        }
        return (UserModel) object;
    }

    private static HttpSession getSession() {
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            return request.getSession();
        }
        return null;
    }
}
