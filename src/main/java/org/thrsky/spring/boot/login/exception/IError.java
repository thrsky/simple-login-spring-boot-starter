package org.thrsky.spring.boot.login.exception;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 18:37 2019-08-04
 */
public interface IError {

    /**
     * 获取错误码
     *
     * @return code
     */
    String getErrorCode();

    /**
     * 获取错误信息
     *
     * @return message
     */
    String getErrorMessage();
}
