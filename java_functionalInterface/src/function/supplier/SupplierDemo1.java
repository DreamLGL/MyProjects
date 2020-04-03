package function.supplier;

import java.util.function.Supplier;

/**
 * @author lgl
 * @Description: 常用的函数式接口
 * java.util.function.Supplier<T> 接口仅包含一个无参的方法: T get(). 用来获取一个泛型参数指定类型的对象数据
 *
 * Supplier<T> 接口被称之为生产型接口,指定的接口泛型是什么类型,那么接口中的get方法就会生产什么类型的数据
 * @date 2020/4/1 12:09 上午
 */
public class SupplierDemo1 {
    /**
     * 定义一个方法,方法的参数传递Supplier<T>接口,泛型执行String,get方法就会返回一个String
     *
     * @param sup
     * @return
     */
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        // 调用getString方法,方法的参数Supplier是一个函数式接口,所以可以传递Lambda表达式
        String s = getString(() -> "胡歌");
        System.out.println(s);
    }
}
