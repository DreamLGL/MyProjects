package com.lgl.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ${user}
 * @Description: ${todo}
 * @date 2019-07-28 23:41
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {
    /**
     * 服务器关闭后,filter对象被销毁.如果服务器市是正常关闭,则会执行destroy方法,只执行一次,用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
     * 每一次请求被拦截资源时会执行,执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("dofilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器启动后会创建Filter对象,然后调用nit方法,只执行一次.用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init....");
    }

}
