package com.lgl.io.objectstream;

import java.io.Serializable;

/**
 * @author lgl
 * @Description: 测试实体类
 *  序列化和反序列化的时候,会抛出 NotSerializableException 没有序列化异常
 *  通过实现java.io.Serializable接口以启用其序列化功能.未实现此接口的类将无法使其任何状态序列化或反序列化.
 *
 *  Serializable接口也叫标记型接口
 *      要进行序列化和反序列化的类必须实现Serializable接口,就会给类添加一个标记
 *      当我们进行序列化和反序列化的时候,就会检测类上是否有这个标记
 *          有: 就可以序列化和反序列化
 *          没有: 就会抛出 NotSerializableException 异常
 *
 *  static关键字: 静态关键字
 *      静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
 *      被static修饰的成员变量不能被序列化的,序列化的都是对象
 *  transient关键字: 瞬态关键字
 *      被transient修饰的成员变量,不能被序列化
 * @date 2020/3/30 3:07 下午
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -1702167413916607362L;
    private String name;
    private transient int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
