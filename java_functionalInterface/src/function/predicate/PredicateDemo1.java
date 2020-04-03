package function.predicate;

import java.util.function.Predicate;

/**
 * @author lgl
 * @Description:
 * java.util.function Interface Predicate<T>接口
 * 作用: 对某种数据类型的数据进行判断,结果返回一个boolean值
 *
 * Predicate接口包含一个抽象方法:
 *  boolean test(T t): 用来对指定数据类型进行判断的方法
 *  结果:
 *      符合条件,返回true
 *      不符合条件,返回false
 * @date 2020/4/1 11:58 下午
 */
public class PredicateDemo1 {
    /**
     * 定义一个方法,参数传递一个String类型的字符串,传递一个Predicate接口,泛型使用String
     * 使用Predicate中的方法test对字符串进行判断,并把判断结果返回
     *
     * @param s
     * @param pre
     * @return
     */
    public static boolean checkString(String s, Predicate<String> pre) {
        return pre.test(s);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        boolean b = checkString(s, str -> str.length() > 5);
        System.out.println(b);
    }
}
