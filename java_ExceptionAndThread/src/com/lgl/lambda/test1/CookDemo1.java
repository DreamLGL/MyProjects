package com.lgl.lambda.test1;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/15 8:06 下午
 */
public class CookDemo1 {
    public static void main(String[] args) {
        //调用invokeCook方法,参数是Cook接口,传递Cook接口的匿名内部类对象
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("开始做饭");
            }
        });
        // 使用lambda表达式简化匿名内部类的书写
        invokeCook(() -> System.out.println("吃饭了"));

    }

    /**
     * 定义一个方法,参数传递Cook接口,方法内部调用Cook接口中的方法makeFood
     */
    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
