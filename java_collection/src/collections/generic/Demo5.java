package collections.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lgl
 * @Description: 泛型的通配符:
 * ?:代表任意的数据类型
 * 使用方式:
 * 不能创建对象使用,只能作为方法的参数使用
 * @date 2020/3/12 4:57 下午
 */
public class Demo5 {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("b");

        printArray(list01);
        printArray(list02);

//        ArrayList<?> list03 = new ArrayList<?>(); //Wildcard type '?' cannot be instantiated directly
    }

    /**
     * 定义一个方法,能遍历所有类型的ArrayList集合,这个时候我们不知道ArrayList集合使用什么数据类型,可以使用泛型的通配符?来接收数据类型
     * @param list
     */
    public static void printArray(ArrayList<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
