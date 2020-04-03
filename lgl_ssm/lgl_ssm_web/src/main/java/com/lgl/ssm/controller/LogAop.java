package com.lgl.ssm.controller;

import com.lgl.ssm.domain.SysLog;
import com.lgl.ssm.service.ISysLogService;
import com.lgl.ssm.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author lgl
 * @Description: 日志的AOP
 * @date 2019/12/19 10:56 下午
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;//开始时间
    private Class clazz;//访问的类
    private Method method;//访问的时间

    /**
     * 前置通知
     * 主要用户获取开始时间,执行的类是哪一个,执行的是哪一个方法
     *
     * @param point
     */
    @Before("execution(* com.lgl.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint point) throws NoSuchMethodException {
        //当前时间就是开始访问的时间
        visitTime = new Date();
        //具体要访问的类
        clazz = point.getTarget().getClass();
        //获取访问的方法名称
        String methodName = point.getSignature().getName();
        //获取访问的方法的参数
        Object[] args = point.getArgs();
        //获取具体执行方法的method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classes);
        }

    }

    /**
     * 后置通知
     *
     * @param point
     */
    @After("execution(* com.lgl.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint point) throws Exception {
        //获取执行的时长
        long time = System.currentTimeMillis() - visitTime.getTime();
        //获取URL
        String url = "";
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                String[] classValue = clazzAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValues = methodAnnotation.value();
                    url = classValue[0] + methodValues[0];
                }
            }
        }
        //获取访问的IP地址
        String ip = request.getRemoteAddr();

        //获取当前操作的用户
        SecurityContext context = SecurityContextHolder.getContext();//从上下文中获取当前登录的用户
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        //将日志相关信息封装到SysLog中
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(time);
        sysLog.setVisitTime(visitTime);
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setMethod(clazz.getName()+"."+method.getName());
        sysLog.setIp(ip);

        //调用service完成数据库操作
        sysLogService.save(sysLog);
    }
}
