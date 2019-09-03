package org.thrsky.spring.boot.login.web;

import lombok.extern.slf4j.Slf4j;
import org.thrsky.spring.boot.login.model.UserModel;
import org.thrsky.spring.boot.login.service.UserService;
import org.thrsky.spring.boot.login.utils.ResourceUtils;
import org.thrsky.spring.boot.login.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 10:54 2019-08-10
 */
@Slf4j
public abstract class BaseResourceServlet extends HttpServlet {

    private static final long serialVersionUID = -6865513159995213347L;

    public static final String SESSION_USER_KEY = "login-user";
    public static final String PARAM_NAME_USERNAME = "loginUsername";
    public static final String PARAM_NAME_PASSWORD = "loginPassword";

    private static final String HTML = ".html";
    private static final String JPG = ".jpg";
    private static final String JS = ".js";
    private static final String CSS = ".css";

    public static final String HTML_CONTENT_TYPE = "text/html; charset=utf-8";
    public static final String JS_CONTENT_TYPE = "text/css;charset=utf-8";
    public static final String CSS_CONTENT_TYPE = "text/javascript;charset=utf-8";

    private static final String INDEX_HTML = "index.html";
    private static final String LOGIN_HTML = "login.html";

    protected String username = null;
    protected String password = null;

    protected final String resourcePath;

    private UserService userService;

    public BaseResourceServlet(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public void init() {
        initEnv();
    }

    public String getFilePath(String fileName) {
        return resourcePath + fileName;
    }

    protected void returnResourceFile(String fileName, String uri, HttpServletResponse response) throws IOException {

        String filePath = getFilePath(fileName);

        if (filePath.endsWith(HTML)) {
            response.setContentType(HTML_CONTENT_TYPE);
        }
        if (fileName.endsWith(JPG)) {
            byte[] bytes = ResourceUtils.readByteArrayFromResource(filePath);
            if (bytes != null) {
                response.getOutputStream().write(bytes);
            }
            return;
        }
        String text = ResourceUtils.readFromResource(filePath);
        if (text == null) {
            response.sendRedirect(uri + "/index.html");
            return;
        }
        if (fileName.endsWith(CSS)) {
            response.setContentType(CSS_CONTENT_TYPE);
        } else if (fileName.endsWith(JS)) {
            response.setContentType(JS_CONTENT_TYPE);
        }
        response.getWriter().write(text);
    }

    private void initEnv() {
        //todo
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();

        response.setCharacterEncoding("utf-8");

        if (contextPath == null) {
            contextPath = "";
        }
        String uri = contextPath + servletPath;
        String path = requestURI.substring(contextPath.length() + servletPath.length());

        if ("/submitLogin".equals(path)) {
            String usernameParam = request.getParameter(PARAM_NAME_USERNAME);
            String passwordParam = request.getParameter(PARAM_NAME_PASSWORD);
            if (userService.login(UserModel.build(usernameParam, passwordParam))) {
                request.getSession().setAttribute(SESSION_USER_KEY, usernameParam);
                response.getWriter().println("success");
            } else {
                response.getWriter().println("error");
            }
            return;
        }
        if (isRequireAuth()
                && !containsUser(request)
                && !checkLoginParam(request)
                && !("/login.html".equals(path) || path.startsWith("/css") || path.startsWith("/js") || path.startsWith("/img"))) {
            if (contextPath.equals("") || contextPath.equals("/")) {
                response.sendRedirect("/login.html");
            } else {
                if ("".equals(path)) {
                    response.sendRedirect("/login.html");
                } else {
                    response.sendRedirect("login.html");
                }
            }
            return;
        }
        if (StringUtils.equals("", path)) {
            if (contextPath.equals("") || contextPath.equals("/")) {
                response.sendRedirect("/" + INDEX_HTML);
            } else {
                response.sendRedirect(INDEX_HTML);
            }
            return;
        }
        if ("/".equals(path)) {
            response.sendRedirect(INDEX_HTML);
            return;
        }
        if (path.contains(".json")) {
            String fullUrl = path;
            if (request.getQueryString() != null && request.getQueryString().length() > 0) {
                fullUrl += "?" + request.getQueryString();
            }
            response.getWriter().print(process(fullUrl));
            return;
        }
        returnResourceFile(path, uri, response);
    }


    private boolean isRequireAuth() {
        return this.username != null;
    }

    private boolean containsUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(SESSION_USER_KEY) != null;
    }

    private boolean checkLoginParam(HttpServletRequest request) {
        String usernameParam = request.getParameter(PARAM_NAME_USERNAME);
        String passwordParam = request.getParameter(PARAM_NAME_PASSWORD);
        if (null == username || null == password) {
            return false;
        }
        return username.equals(usernameParam) && password.equals(passwordParam);
    }

    protected abstract String process(String url);
}
