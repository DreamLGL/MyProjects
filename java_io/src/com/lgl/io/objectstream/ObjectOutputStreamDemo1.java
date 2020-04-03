package com.lgl.io.objectstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author lgl
 * @Description: 序列化输出流
 * java.io.ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants
 * ObjectOutputStream: 对象的序列化流
 * 作用: 把对象以流的方式写入到文件中保存
 *
 * 构造方法:
 *      ObjectOutputStream​(OutputStream out) 创建一个写入指定OutputStream的ObjectOutputStream。
 *
 * 特有的成员方法:
 *      void writeObject​(Object obj) 将指定的对象写入ObjectOutputStream。
 *
 * @date 2020/3/30 2:51 下午
 */
public class ObjectOutputStreamDemo1 {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));) {
            oos.writeObject(new Person("张三", 28));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
