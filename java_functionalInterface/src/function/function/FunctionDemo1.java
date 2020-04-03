package function.function;

import java.util.function.Function;

/**
 * @author lgl
 * @Description:
 * java.util.function Interface Function<T,​R>接口用来根据一个类型的数据得到另一个类型的数据,
 *      前者称之为前置条件,后者称之为后置条件
 * Function接口中最主要的抽象方法为: R apply(T t),根据类型T的参数获取类型R的结果.
 *      使用场景例如: 将String类型转换为Integer类型
 * @date 2020/4/2 1:10 上午
 */
public class FunctionDemo1 {
    public static void change(String s, Function<String, Integer> fun) {
        System.out.println(fun.apply(s));
    }

    public static void main(String[] args) {
        String s = "1234";
        change(s, str -> Integer.parseInt(str));
    }
}
