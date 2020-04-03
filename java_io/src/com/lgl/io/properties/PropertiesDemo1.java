package com.lgl.io.properties;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

/**
 * @author lgl
 * @Description: 属性集
 *  java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
 *  Properties 类表示了一个持久的属性集.Properties可保存在流中加载.
 *  Properties集合是唯一一个和IO流向结合的集合
 *      可以使用store方法,把集合中的临时数据持久化写入到硬盘
 *      可以使用load方法,把硬盘中保存的文件(键值对)读取到集合中使用
 *  属性列表中每个键及其对应值都是一个字符串.
 *      Properties集合是一个恶双列集合,key和value默认都是字符串
 * @date 2020/3/29 4:42 下午
 */
public class PropertiesDemo1 {
    public static void main(String[] args) {
        show03();
    }

    /**
     * 可以使用Properties集合中的方法load,把硬盘中保存的文件(键值对),读取到集合中使用
     *  void load(InputStream inStream) 从输入字节流读取属性列表（键和元素对）。
     *  void load(Reader reader) 以简单的线性格式从输入字符流读取属性列表（关键字和元素对）。
     * 参数:
     *  InputStream inStream: 字节输入流,不能读取含有中文的键值对
     *  Reader reader: 字符输入流,可以读取含有中文的键值对
     *
     */
    private static void show03() {
        Properties prop = new Properties();
        try (FileReader reader = new FileReader("prop.txt");
        FileInputStream fis=new FileInputStream("prop.txt")) {
            prop.load(fis);
            Set<String> set = prop.stringPropertyNames();
            if (set.size() > 0) {
                System.out.println(" key" + " | " + "value ");
            }
            for (String s : set) {
                String property = prop.getProperty(s);
                System.out.println(s + " | " + property);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * 把临时数据写入硬盘中持久化
     * void	store(OutputStream out, String comments) 将此属性列表（键和元素对）写入此 Properties表中，以适合于使用 load(InputStream)方法
     *                                               加载到 Properties表中的格式输出流
     * void	store(Writer writer, String comments) 将此属性列表（键和元素对）写入此 Properties表中，以适合使用 load(Reader)方法的格式输出到
     *                                            输出字符流。
     * 参数:
     *    OutputStream out: 字节输出流,不能写中文
     *    Writer writer: 字符输出流,可以写中文
     *    String comments:  注释,不能写中文,因为默认是Unicode编码,写中文会乱码,一般使用""空字符串
     */
    private static void show02() {
        Properties prop = new Properties();
        prop.setProperty("张三", "168");
        prop.setProperty("李四", "168");
        prop.setProperty("王五", "168");
        //创建字符流
        try (FileWriter fw = new FileWriter("prop.txt");
             FileOutputStream fos = new FileOutputStream("prop2.txt")) {
            prop.store(fw, "save data");
            prop.store(fos,"save data");
        } catch (IOException e) {
            System.out.println(e);
        }


    }

    /**
     * 使用Properties集合存储数据,遍历取出Properties中的数据
     *  Object setProperty(String key, String value) 致电 Hashtable方法 put 。
     *  String getProperty(String key) 使用此属性列表中指定的键搜索属性
     *  Set<String>	stringPropertyNames() 返回此属性列表中的一组键，其中键及其对应的值为字符串，包括默认属性列表中的不同键，
     *                                    如果尚未从主属性列表中找到相同名称的键
     */
    private static void show01() {
        Properties prop = new Properties();
        prop.setProperty("张三", "168");
        prop.setProperty("李四", "168");
        prop.setProperty("王五", "168");

        // 使用stringPropertyNames()把Properties集合中的键取出,存储到一个Set集合中
        Set<String> set = prop.stringPropertyNames();
        // 遍历set集合,取出Properties集合的每一个键
        for (String s : set) {
            String value = prop.getProperty(s);
            System.out.println("Key : " + s + " | Value : " + value);
        }
    }
}
