package com.lgl.io.recurison;

/**
 * @author lgl
 * @Description: 递归Demo1
 * @date 2019-08-05 23:55
 */
public class RecursionDemo1 {
    public static void main(String[] args) {
//        a();
        b(1);
    }

    private static void b(int i) {
        System.out.println(i);
        if (i==20000){
            return;
        }
        b(++i);
    }

    /**
     * 递归一定要有条件限定,保证递归能够停下来,否则会发生栈内存溢出
     */
    private static void a() {
        System.out.println("a方法");
        a();
    }
}
