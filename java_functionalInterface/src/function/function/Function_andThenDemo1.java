package function.function;

import java.util.function.Function;

/**
 * @author lgl
 * @Description:
 * @date 2020/4/2 1:19 上午
 */
public class Function_andThenDemo1 {
    public static void change(String s, Function<String, Integer> fun,Function<Integer,String> fun2) {
        System.out.println(fun.andThen(fun2).apply(s));
    }

    public static void main(String[] args) {
        String s = "1234";
        change(s, str -> Integer.parseInt(str)+1000,str->str+"字符串");
    }
}
