package com.lgl.io.recurison;

/**
 * @author lgl
 * @Description: 递归Demo2
 * @date 2019-08-06 00:05
 */
public class RecurisonDemo2 {
    public static void main(String[] args) {
        int s = sum(100);
        System.out.println(s);
    }

    private static int sum(int i) {
        //获取到1的时候结束
        if (i == 1) {
            return 1;
        }
        //获取下一个被加的数字
        return i + sum(i - 1);
    }
}
