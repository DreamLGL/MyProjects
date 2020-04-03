package com.lgl.io.objectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author lgl
 * @Description: 反序列化流
 * java.io.ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants
 * ObjectInputStream: 对象的反序列化流
 * 作用: 把文件中保存的对象,以流的方式读取出来使用
 *
 * 构造方法:
 *      ObjectInputStream​(InputStream in) 创建一个从指定的InputStream读取的ObjectInputStream。
 *
 *  特有的成员方法:
 *      Object readObject() 从ObjectInputStream中读取一个对象。
 * @date 2020/3/30 3:21 下午
 */
public class ObjectInputStreamDemo1 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"));) {
            Object object = ois.readObject();
            System.out.println(object);
            Person p = (Person) object;
            System.out.println(p.getName() + p.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
