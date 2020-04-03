package com.lgl.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ${user}
 * @Description: ${todo}
 * @date 2019-07-29 22:41
 */

//浏览器直接请求index,jsp资源时,该过滤器会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index.jsp时过滤器才会被执行
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.FORWARD)

//览器直接请求index,jsp资源或者转发访问index.jsp时 执行过滤器
//@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})

//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo5......");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
