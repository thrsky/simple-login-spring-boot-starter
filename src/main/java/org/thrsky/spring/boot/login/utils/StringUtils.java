package org.thrsky.spring.boot.login.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 10:25 2019-08-11
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private StringUtils() {
        //
    }

    public static Set<String> split2Set(String str, String split) {
        return new HashSet<>(split2List(str, split));
    }

    public static List<String> split2List(String str, String split) {
        return Arrays.asList(split2Array(str, split));
    }

    public static String[] split2Array(String str, String split) {
        if (isBlank(str)) {
            return new String[0];
        }
        if (isBlank(split)) {
            return new String[]{str};
        }
        return str.split(split);
    }
}
