package org.thrsky.spring.boot.login.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.thrsky.spring.boot.login.filter.SimpleUserLoginFilter;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;

/**
 * @author thrsky
 * @date 2019/8/2 11:00
 **/
@ConditionalOnWebApplication
public class LoginFilterConfiguration {

    @Bean
    public FilterRegistrationBean<SimpleUserLoginFilter> webFilterRegistrationBean(SimpleLoginProperties simpleLoginProperties) {

        FilterRegistrationBean<SimpleUserLoginFilter> registrationBean = new FilterRegistrationBean<>();
        SimpleUserLoginFilter filter = new SimpleUserLoginFilter();
        registrationBean.setFilter(filter);
        return registrationBean;
    }
}