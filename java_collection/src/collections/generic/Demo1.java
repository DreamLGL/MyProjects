package collections.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lgl
 * @Description: 泛型demo1
 * @date 2020/3/12 4:08 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        show02();
    }

    /**
     * 创建集合对象,使用泛型
     * 好处:
     *  1.避免了类型转换的麻烦,存储的是什么类型,取出就是什么类型
     *  2.把运行期异常(代码运行之后会抛出的异常),提升到了编译期(写代码的时候会报错)
     * 弊端:
     *  泛型是什么类型,只能存储什么类型的数据
     */
    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(1);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            System.out.println(next.length());
        }
    }


    /**
     * 创建集合对象,不适用泛型
     *  好处:
     *      集合不使用泛型,默认类型是Object类型,可以存储任意类型的数据
     *  弊端:
     *      不安全,会引发异常
     */
    private static void show01() {
        ArrayList list = new ArrayList();
        list.add("abc");
        list.add(1);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            //取出的元素是Object类型
            Object next = iterator.next();
            System.out.println(next);

            //想要使用String类特有的方法length,不能直接使用,因为多态Object obj = "abc";
            //如果要使用需要向下转型
            //但是会抛出异常ClassCastException,不能把Integer类型转换为String
            String s = (String) next;
            System.out.println(s.length());
        }
    }
}
