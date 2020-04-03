package com.lgl.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lgl
 * @Description: 密码工具类
 * @date 2019/12/16 12:09 上午
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private static String endcodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
