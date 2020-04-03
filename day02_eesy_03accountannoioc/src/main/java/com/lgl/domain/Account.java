package com.lgl.domain;

/**
 * @author lgl
 * @Description: Account 实体类
 * @date 2019/8/25 7:40 上午
 */
public class Account {
    private Integer id;
    private String name;
    private Float money;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
