package com.lgl.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ${user}
 * @Description: ${todo}
 * @date 2019-07-29 23:13
 */
@WebFilter("/*")
public class FilterDemo7 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo7执行了");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo7回来了了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
