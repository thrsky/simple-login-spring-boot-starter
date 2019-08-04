package org.thrsky.spring.boot.login.exception;

import lombok.Setter;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 18:37 2019-08-04
 */
public enum BizErrors implements IError {

    //user login error
    USER_NOT_CONTAINS("1001", "user not contains"),
    USER_PASSWD_ERROR("1002", "user passwrd error"),

    ;

    @Setter
    private String code;

    @Setter
    private String message;

    BizErrors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.message;
    }
}
