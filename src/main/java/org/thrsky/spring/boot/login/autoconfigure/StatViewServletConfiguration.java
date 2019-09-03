package org.thrsky.spring.boot.login.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;
import org.thrsky.spring.boot.login.web.StatViewServlet;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 11:34 2019-08-10
 */
@ConditionalOnWebApplication
@ConditionalOnProperty(name = "spring.simple.login.enabled", havingValue = "true")
public class StatViewServletConfiguration {

    @Bean
    public ServletRegistrationBean<StatViewServlet> servletRegistrationBean(SimpleLoginProperties simpleLoginProperties) {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>();
        StatViewServlet servlet = new StatViewServlet();
        registrationBean.setServlet(servlet);
        return registrationBean;
    }
}
