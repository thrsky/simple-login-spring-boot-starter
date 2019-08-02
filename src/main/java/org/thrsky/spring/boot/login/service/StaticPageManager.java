package org.thrsky.spring.boot.login.service;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:19 2019-08-01
 */
public interface StaticPageManager {

    void setLoginPagePath(final String loginPagePath);

    void setRegisterPagePath(final String registerPagePath);

    void setIndexPagePath(final String indexPagePath);
}
