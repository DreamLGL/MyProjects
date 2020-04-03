package com.lgl.consumer.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author lgl
 * @Description: User的实体类
 * @date 2019/12/24 11:23 下午
 */
@Data
public class User {
    //id
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //生日
    private Date birthday;
    //创建时间
    private Date created;
    //更新时间
    private Date updated;
    //说明备注
    private String note;
}
