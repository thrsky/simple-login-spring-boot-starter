package org.thrsky.spring.boot.login.utils;

import com.google.common.base.Throwables;
import org.slf4j.Logger;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 17:32 2019-08-04
 */
public class LogUtils {

    private static final String LOG_SEPARATOR = ",";

    private LogUtils() {
        //禁用构造函数
    }

    public static void info(Logger logger, String... msg) {
        logger.info(buildLogString(null, msg));
    }

    public static void info(Logger logger, Throwable throwable, String... msg) {
        logger.info(buildLogString(throwable, msg));
    }

    public static void error(Logger logger, Throwable throwable, String... msg) {
        logger.error(buildLogString(throwable, msg));
    }

    public static void error(Logger logger, String... msg) {
        logger.error(buildLogString(null, msg));
    }

    public static void debug(Logger logger, Throwable throwable, String... msg) {
        logger.debug(buildLogString(throwable, msg));
    }

    public static void debug(Logger logger, String... msg) {
        logger.debug(buildLogString(null, msg));
    }

    private static String buildLogString(Throwable throwable, String... msg) {
        StringBuilder sb = new StringBuilder();
        if (throwable != null) {
            sb.append(Throwables.getStackTraceAsString(throwable)).append(LOG_SEPARATOR);
        }
        for (String s : msg) {
            sb.append(s).append(LOG_SEPARATOR);
        }
        return sb.toString();
    }
}
