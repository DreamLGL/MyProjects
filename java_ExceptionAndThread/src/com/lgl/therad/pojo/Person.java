package com.lgl.therad.pojo;

/**
 * @author lgl
 * @Description: Person实体类
 * @date 2020/3/14 3:32 下午
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public void run() {
        //定义循环,执行20次
        for (int i = 0; i < 20; i++) {
            System.out.println(this.name + "----->" + i);
        }
    }
}
