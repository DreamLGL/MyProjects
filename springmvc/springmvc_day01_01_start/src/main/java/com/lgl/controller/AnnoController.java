package com.lgl.controller;

import com.lgl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author lgl
 * @Description: 常用的注解
 * @date 2019/9/23 11:11 下午
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username) {
        System.out.println("testRequestParam执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     *
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("testRequestBody执行了");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解
     *
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id) {
        System.out.println("testPathVariable执行了");
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader注解
     * 获取请求头的值
     *
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("testRequestHeader执行了");
        System.out.println(header);
        return "success";
    }

    /**
     * CookieValue注解
     * 获取cookie的值
     *
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("testCookieValue执行了");
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * ModelAttribute注解
     *
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user) {
        System.out.println("testModelAttribute执行了");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法先执行(无返回值)
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map) {
        System.out.println("showUser执行了");
        //通过用户名查数据库
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }


    /**
     * 该方法先执行(有返回值)

     @ModelAttribute public User showUser(String uname){
     System.out.println("showUser执行了");
     //通过用户名查数据库
     User user = new User();
     user.setUname(uname);
     user.setAge(20);
     user.setDate(new Date());
     return user;
     }*/

    /**
     * SessionAttributes注解
     *
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes执行了");
        //底层会存储到request域对象当中
        model.addAttribute("msg", "美美");
        return "success";
    }


    /**
     * SessionAttributes注解
     *
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap model) {
        System.out.println("getSessionAttributes执行了");
        //底层会存储到request域对象当中
        String msg = (String) model.get("msg");
        System.out.println("msg = " + msg);
        return "success";
    }

    /**
     * SessionAttributes注解
     *
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes执行了");
        status.setComplete();
        return "success";
    }
}
