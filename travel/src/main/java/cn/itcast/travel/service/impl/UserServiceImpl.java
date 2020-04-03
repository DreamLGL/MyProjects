package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @author lgl
 * @Description: userservice的实现类
 * @date 2019-08-01 22:39
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public Boolean regist(User user) {
        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if (u != null) {
            //用户名存在,注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码,唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置状态
        user.setStatus("N");
        userDao.save(user);

        //激活邮件发送,邮件正文内容?
        String context = "<a href='http://localhost:8080/lgl/user/active?code=" + user.getCode() + "'>点击激活[哈哈哈哈]</a>";
        MailUtils.sendMail(user.getEmail(), context, "激活邮件");
        return true;
    }

    /**
     * 激活用户
     *
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        boolean flag = false;
        if (user != null) {
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            flag = true;
        }
        return flag;
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
