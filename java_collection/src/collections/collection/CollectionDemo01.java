package collections.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lgl
 * @Description: java.util.Collection接口
 *                  所有单例集合最顶层的接口,里边定义了所有的单例集合共性的方法
 *                  任意的单例集合都可以使用Collection接口中的方法
 *               共性的方法:
 *               public boolean add(E e); 把给定对象添加到当前集合中
 *               public void clear(); 清空集合中所有的元素
 *               public boolean remove(E e); 把给定的对象在当前集合中删除
 *               public boolean contains(E e); 判断当前集合中是否包含给定的对象
 *               public boolean isEmpty(); 判断当前集合是否为空
 *               public int size(); 返回集合中元素的个数
 *               public Object[] toArray(E e); 把集合中的元素,存储到数组中
 * @date 2020/2/22 4:29 下午
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        //创建集合对象,可以使用多态
        Collection<String> coll = new ArrayList<>();
        //重写了toString方法 [];
        System.out.println(coll);
        /*
        public boolean add(E e); 把给定对象添加到当前集合中
        返回值是boolean值,一般返回都是true,所以可以不用接收
         */
        boolean b1 = coll.add("张三");
        System.out.println("b1: " + b1);
        System.out.println(coll);
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);

        /*
        public boolean remove(E e); 把给定的对象在当前集合中删除
        返回值是一个boolean值,集合中存在元素,删除元素,返回true;集合中不存在元素,删除元素,返回false
         */
        boolean b2 = coll.remove("赵六");
        System.out.println("b2: " + b2);
        boolean b3 = coll.remove("赵四");
        System.out.println("b3: " + b3);
        System.out.println(coll);
    }
}
