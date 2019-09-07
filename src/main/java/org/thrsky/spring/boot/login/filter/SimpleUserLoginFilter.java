package org.thrsky.spring.boot.login.filter;

import lombok.Setter;
import org.thrsky.spring.boot.login.properties.SimpleLoginProperties;
import org.thrsky.spring.boot.login.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * @author thrsky
 * @date 2019/8/2 10:28
 **/
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class SimpleUserLoginFilter implements Filter {

    @Setter
    private SimpleLoginProperties properties;

    private Set<String> notFilterUrlSet;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        notFilterUrlSet = StringUtils.split2Set(properties.getNotFilterUrls(), ",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String urlPath = request.getRequestURI();
        if (notFilterUrlSet.contains(urlPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //跳到登录页
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String context = request.getContextPath();
            if (StringUtils.equalsAny(context, "", "/")) {
                response.sendRedirect("/login.html");
            } else {
                response.sendRedirect("login.html");
            }
        }
    }

    @Override
    public void destroy() {
        notFilterUrlSet = null;
        properties = null;
    }
}