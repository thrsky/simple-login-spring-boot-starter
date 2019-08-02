package org.thrsky.spring.boot.login.filter;

import org.thrsky.spring.boot.login.properties.PropertiesHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author thrsky
 * @date 2019/8/2 10:28
 **/
@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class SimpleUserLoginFilter implements Filter {

    private Set<String> notFilterUrlSet;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        notFilterUrlSet = new HashSet<>(Arrays.asList(PropertiesHolder.getSimpleLoginProperties().getNotFilterUrls().split(",")));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String urlPath = request.getRequestURI();
        if (notFilterUrlSet.contains(urlPath)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect(request.getRequestURI() + "/index");
        }
    }

    @Override
    public void destroy() {

    }
}