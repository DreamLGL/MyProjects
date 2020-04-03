package com.lgl.controller;

import com.lgl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lgl
 * @Description:
 * @date 2019/10/7 11:15 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回String
     *
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString()方法执行了.........");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("lgl");
        user.setPassword("123456");
        user.setAge(25);
        //model对象
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 是void
     * 请求转发是一次请求,不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid()方法执行了.........");
        //编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接会进行响应
        response.getWriter().println("你好");

        return;
    }

    /**
     * 返回ModelAndView
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //创建一个ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView()方法执行了.........");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("cy");
        user.setPassword("123456");
        user.setAge(25);
        //把user对象存储到mv对象中,也会把user对象存入到request对象
        mv.addObject("user", user);
        //跳转到那个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     *
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        System.out.println("testForwardOrRedirect()方法执行了.........");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax()方法执行了.........");
        //客户端发送ajax请求,传的是json字符串,后端把json字符串封装到user对象中
        System.out.println(user);
        //作响应,模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        //做响应
        return user;
    }
}
