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
 *      1.判断字符串长度是否大于5
 *      2.判断字符串中是否包含a
 *  两个条件只需要满足其一
 * @date 2020/4/2 12:12 上午
 */
public class Predicate_orDemo1 {
    /**
     * 定义一个方法测试Predicate接口的or方法
     *
     * @param s
     * @param pre1
     * @param pre2
     * @return
     */
    public static boolean orCheck(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(s);
    }

    public static void main(String[] args) {
        String s = "哈哈哈哈哈sdf";
        boolean b = orCheck(s, str -> str.length() > 5, str -> str.indexOf("a") != -1);
        System.out.println(b);
    }
}
