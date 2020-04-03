package com.lgl.io.recurison;

/**
 * @author lgl
 * @Description: 递归Demo3
 * 练习:
 * 使用递归计算阶乘
 * n的阶乘: n! = n * (n-1) *...* 3 * 2 * 1
 * 5的阶乘: 5! = 5 * (5-1) * (5-2) * (5-3) * (5-4)
 * @date 2019-08-06 00:05
 */
public class RecursionDemo3 {
    public static void main(String[] args) {
        int num = 5;
        int factorial = factorial(num);
        System.out.println(factorial);
    }

    /**
     * @param num
     * @return
     */
    private static int factorial(int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }
}
