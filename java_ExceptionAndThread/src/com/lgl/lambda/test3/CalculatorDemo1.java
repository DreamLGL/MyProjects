package com.lgl.lambda.test3;

/**
 * @author lgl
 * @Description: lambda表达式有参数返回值的练习
 * @date 2020/3/15 10:42 下午
 */
public class CalculatorDemo1 {
    public static void main(String[] args) {
        //匿名内部类
        method(6, 11, new Calculator() {
            @Override
            public int cacl(int a, int b) {
                return a + b;
            }
        });
        // lambda表达式简化
        method(16, 11, (a, b) ->  a + b);
    }

    public static void method(int a, int b, Calculator calculator) {
        int cacl = calculator.cacl(a, b);
        System.out.println(cacl);
    }
}
