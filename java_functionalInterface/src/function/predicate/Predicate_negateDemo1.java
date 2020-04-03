package function.predicate;

import java.util.function.Predicate;

/**
 * @author lgl
 * @Description:
 *  逻辑表达式:可以连接多个判断条件
 *  &&: 与运算,有false则false
 *  ||: 或运算,有true则true
 *  !: 非(取反)运算,非真则假,非假则真
 *
 *  需求:判断一个字符串,有两个判断条件
 *      1.判断字符串长度是否大于5,大于5返回false,不大于返回true
 * @date 2020/4/2 12:13 上午
 */
public class Predicate_negateDemo1 {
    /**
     * 定义一个方法测试Predicate接口的negate方法
     *
     * @param s
     * @param pre1
     * @return
     */
    public static boolean negateCheck(String s, Predicate<String> pre1) {
        return pre1.negate().test(s);
    }

    public static void main(String[] args) {
        String s = "哈哈哈哈哈sdf";
        boolean b = negateCheck(s, str -> str.length() > 5);
        System.out.println(b);
    }
}
