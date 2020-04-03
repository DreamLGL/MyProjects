package com.leyou.user.service.impl;

import com.leyou.common.utils.NumberUtils;
import com.leyou.user.mapper.UserMapper;
import com.leyou.user.pojo.User;
import com.leyou.user.service.IUserService;
import com.leyou.user.utils.CodecUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lgl
 * @Description: UserService接口实现类
 * @date 2020/3/3 4:17 下午
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "user:verify:";

    @Override
    public Boolean checkUser(String data, Integer type) {
        User user = new User();
        if (type == 1) {
            user.setUsername(data);
        } else if (type == 2) {
            user.setPhone(data);
        } else {
            return null;
        }
        return userMapper.selectCount(user) == 0;

    }

    @Override
    public void sendVerifyCode(String phone) {
        if (StringUtils.isNoneBlank(phone)) {
            //1.生产验证码
            String code = NumberUtils.generateCode(6);
            System.out.println(code);
            //2.发送消息到rabbitMQ
            HashMap<String, String> map = new HashMap<>();
            map.put("code", code);
            map.put("phone", phone);
            amqpTemplate.convertAndSend("LEYOU.SMS.EXCHANGE", "verifycode.sms", map);
            //3.把验证码保存到redis中
            redisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 1, TimeUnit.MINUTES);
        }
    }

    @Override
    public void register(User user, String code) {
        // 查询redis中的验证码
        String s = redisTemplate.opsForValue().get(KEY_PREFIX + user.getPhone());
        // 1.校验验证码
        if (StringUtils.equals(s, code)) {
            // 2.生成盐
            String salt = CodecUtils.generateSalt();
            user.setSalt(salt);
            // 3.加盐加密
            user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt));
            // 4.新增用户
            user.setId(null);
            user.setCreated(new Date());
            userMapper.insert(user);
            // 5.删除验证码
            redisTemplate.delete(KEY_PREFIX + user.getPhone());
        }

    }

    @Override
    public User queryUser(String username, String password) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            User user = new User();
            user.setUsername(username);
            User user1 = userMapper.selectOne(user);
            if (user1 == null) {
                return null;
            }
            password = CodecUtils.md5Hex(password, user1.getSalt());
            if (StringUtils.equals(password, user1.getPassword())) {
                return user1;
            }
        }
        return null;
    }
}
