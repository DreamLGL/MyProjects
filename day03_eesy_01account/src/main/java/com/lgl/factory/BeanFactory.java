package com.lgl.factory;

import com.lgl.service.AccountService;
import com.lgl.util.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lgl
 * @Description: 用于创建Service的代理对象的工厂
 * @date 2019/8/29 12:00 上午
 */
public class BeanFactory {
    private AccountService accountService;
    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * 获取Service的代理对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("test".equals(method.getName())){
                            return method.invoke(accountService,args);
                        }
                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService,args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚事务
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });
    }
}
