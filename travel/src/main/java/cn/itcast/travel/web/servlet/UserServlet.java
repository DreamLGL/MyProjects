package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author ${user}
 * @Description: ${todo}
 * @date 2019-08-20 23:01
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    //申明一个UserService业务对象
    private UserService service = new UserServiceImpl();

    /**
     * 注册功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //校验验证码
        String check = request.getParameter("check");
        //从Session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        ResultInfo info = new ResultInfo();
        //比较验证码(不区分大小写)
        if (!checkcode_server.equalsIgnoreCase(check)) {
            //验证码错误
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            String json = writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成注册
//        UserService service = new UserServiceImpl();
        Boolean flag = service.regist(user);

        //4.响应结果
        if (flag) {
            //注册成功
            info.setFlag(true);
        } else {
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }
        //将info对象序列化为json
        String json = writeValueAsString(info);
        //将json数据写回客户端
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 登录功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码
        String code = request.getParameter("check");
        //从Session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        ResultInfo info = new ResultInfo();
        if (!code.equalsIgnoreCase(checkcode_server)) {
            //验证码错误
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //1.获取用户名和密码
        Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service查询
//        UserService service = new UserServiceImpl();
        User u = service.login(user);

        //4.判断用户对象是否为null
        if (u == null) {
            //用户名或密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        //5.判断用户是否激活
        if (u != null && !"Y".equals(u.getStatus())) {
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("你尚未激活,请激活");
        }
        //6.判断登陆成功
        if (u != null && "Y".equals(u.getStatus())) {
            info.setFlag(true);
            info.setErrorMsg("登录成功");
            request.getSession().setAttribute("user", u);
        }
        //响应数据
        writeValue(info,response);
    }

    /**
     * 查找单个对象功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        //将user写回客户端
        writeValue(user,response);
    }

    /**
     * 退出功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转页面
        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    /**
     * 激活功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if (code != null) {
            //2.调用service完成激活
//            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);
            //3.判断标记
            String msg = null;
            if (flag) {
                //激活成功
                msg = "激活成功,请<a href='login.html'>登录</a>";
            } else {
                //激活失败
                msg = "激活失败,请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
}
