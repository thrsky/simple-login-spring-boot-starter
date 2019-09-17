package org.thrsky.spring.boot.login.utils;

import org.thrsky.spring.boot.login.exception.BaseBizException;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:15 2019-09-17
 */
public class AssertUtils {

    private AssertUtils() {
        //
    }

    public static void notNull(String data, String errorMsg) {
        if (data == null) {
            throw new BaseBizException(errorMsg);
        }
    }

    public static void notBlank(String data, String errorMsg) {
        if (StringUtils.isBlank(data)) {
            throw new BaseBizException(errorMsg);
        }
    }
}
