package org.thrsky.spring.boot.login.web;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 11:12 2019-08-10
 */
public class StatViewServlet extends BaseResourceServlet {

    private static final long serialVersionUID = 342818540231063346L;

    public StatViewServlet() {
        super("support/http/resources");
    }

    @Override
    public void init() {
        super.init();

    }

    @Override
    protected String process(String url) {
        return url;
    }
}
