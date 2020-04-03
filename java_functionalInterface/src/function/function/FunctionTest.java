package function.function;

import java.util.function.Function;

/**
 * @author lgl
 * @Description: 自定义函数模型拼接
 * @date 2020/4/2 1:41 上午
 */
public class FunctionTest {
    public static void change(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        System.out.println(fun1.andThen(fun2).andThen(fun3).apply(s));
    }

    public static void main(String[] args) {
        String s = "赵丽颖,20";
        change(s, str -> str.split(",")[1], str -> Integer.parseInt(str), num -> num + 100);
    }
}
