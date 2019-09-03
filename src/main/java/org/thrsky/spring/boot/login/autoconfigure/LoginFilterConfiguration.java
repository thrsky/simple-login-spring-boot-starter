package org.thrsky.spring.boot.login.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thrsky.spring.boot.login.filter.SimpleUserLoginFilter;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;
import org.thrsky.spring.boot.login.utils.LogUtils;

/**
 * @author thrsky
 * @date 2019/8/2 11:00
 **/
@Configuration
@ConditionalOnWebApplication
@Slf4j
public class LoginFilterConfiguration {

    private static final String LOG_PREFIX = "loginFilterConfiguration log";

    @Bean
    public FilterRegistrationBean<SimpleUserLoginFilter> webFilterRegistrationBean(SimpleLoginProperties simpleLoginProperties) {
        FilterRegistrationBean<SimpleUserLoginFilter> registrationBean = new FilterRegistrationBean<>();
        SimpleUserLoginFilter filter = new SimpleUserLoginFilter();
        filter.setProperties(simpleLoginProperties);
        registrationBean.setFilter(filter);
        LogUtils.info(log, LOG_PREFIX, "register bean", "simpleUserLoginFilter");
        return registrationBean;
    }
}