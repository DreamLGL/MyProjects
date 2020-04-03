package com.lgl.controller;

import com.lgl.domain.Account;
import com.lgl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lgl
 * @Description: 请求参数绑定测试
 * @date 2019/9/22 9:06 下午
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     *
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("执行了");
        System.out.println("你的用户名: " + username);
        System.out.println("你的密码: " + password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean当中
     *
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     *
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }


    /**
     * 原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }
}
