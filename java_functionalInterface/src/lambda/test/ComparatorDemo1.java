package lambda.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lgl
 * @Description: 函数式接口作为返回值
 * @date 2020/3/31 11:42 下午
 */
public class ComparatorDemo1 {
    /**
     * 定义一个方法,方法的返回值类型使用函数式接口Comparator
     *
     * @return
     */
    public static Comparator<String> newComparator() {
        /*  return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 按照字符串的降序规则
                return o2.length() - o1.length();
            }
        };*/

        // 按照字符串的降序排序
        return (a, b) -> b.length() - a.length();
    }

    public static void main(String[] args) {
        // 创建字符串数组
        String[] arr = {"a", "bb", "ccc", "dddd", "eeee", "fffff", "gggggg"};
        System.out.println(Arrays.toString(arr));
        // 调用Arrays中的sort方法
        Arrays.sort(arr, newComparator());
        System.out.println(Arrays.toString(arr));
    }
}
