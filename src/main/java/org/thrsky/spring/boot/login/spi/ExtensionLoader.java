package org.thrsky.spring.boot.login.spi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.thrsky.spring.boot.login.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 23:13 2019-09-10
 */
@Slf4j
public class ExtensionLoader {

    private static final String LOG_PRE = "ExtensionLoader.Error";

    private static final String SYSTEM_SERVICE_PATH = "org.thrsky.spring.boot.login";

    private static final Map<Class<?>, Object> servicesMap = new ConcurrentHashMap<>();

    /**
     * 加载用户自定义的Service
     */
    public static <T> T load(Class<T> tClass) {
        if (tClass == null) {
            LogUtils.error(log, LOG_PRE, "load class type is null");
            return null;
        }
        T service = (T) servicesMap.get(tClass);
        if (service == null) {
            synchronized (servicesMap) {
                ServiceLoader<T> loader = ServiceLoader.load(tClass);
                List<T> classes = new ArrayList<>();
                for (T t : loader) {
                    classes.add(t);
                }
                service = findUserDefineService(classes);
                if (service == null) {
                    LogUtils.error(log, LOG_PRE, "not found ");
                }
                servicesMap.put(tClass, service);
            }
        }
        return service;
    }

    /**
     * 寻找包路径不是org.thrsky.spring.boot.login的类
     *
     * @param classList classList
     * @param <T>       T
     * @return 用户自定义的类
     */
    private static <T> T findUserDefineService(List<T> classList) {
        if (CollectionUtils.isEmpty(classList)) {
            return null;
        }
        for (T cls : classList) {
            if (!cls.getClass().getName().contains(SYSTEM_SERVICE_PATH)) {
                return cls;
            }
        }
        return null;
    }
}
