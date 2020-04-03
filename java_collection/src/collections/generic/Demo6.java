package collections.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author lgl
 * @Description: 泛型的上下限限定
 *  上限限定: ? extend E 代表使用的泛型只能是E类型的子类/本身
 *  下线限定: ? super E  代表使用的泛型只能是E类型的父类/本身
 * @date 2020/3/12 5:16 下午
 */
public class Demo6 {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        getElement1(list1);
        //报错
//        getElement1(list2);
        getElement1(list3);
        //报错
//        getElement1(list4);

        //报错
//        getElement2(list1);
        //报错
//        getElement2(list2);
        getElement2(list3);
        getElement2(list4);

        /*
            类与类之间的继承关系
            Integer extends Number extends Object
            String extends Object
         */
    }

    /**
     * 泛型的上限: 此时的泛型?,必须是Number类型或者Number类型的子类
     * @param collection
     */
    public static void getElement1(Collection<? extends Number> collection){};

    /**
     * 泛型的下限: 此时的泛型?,必须是Number类型或者Number类型的父类
     * @param collection
     */
    public static void getElement2(Collection<? super Number> collection){};
}
