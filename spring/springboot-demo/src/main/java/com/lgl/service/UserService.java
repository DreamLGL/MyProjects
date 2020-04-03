package com.lgl.service;

import com.lgl.mapper.UserMapper;
import com.lgl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/23 11:50 下午
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public void insertUser(User user){
        userMapper.insert(user);
    }
}
