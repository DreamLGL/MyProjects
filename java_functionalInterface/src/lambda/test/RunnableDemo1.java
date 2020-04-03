package lambda.test;

/**
 * @author lgl
 * @Description: 函数式接口作为参数
 * @date 2020/3/31 11:42 下午
 */
public class RunnableDemo1 {
    /**
     * 定义一个方法startThread,方法的参数使用函数式接口Runnable
     *
     * @param run
     */
    public static void startThread(Runnable run) {
        //开启多线程
        new Thread(run).start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            startThread(() -> System.out.println(Thread.currentThread().getName() + " : 启动了!"));
        }
    }
}
