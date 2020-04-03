package lambda;

/**
 * @author lgl
 * @Description: 日志案例
 *  一下demo中的代码存在资源浪费,因为只有level=1的时候才输出日志,
 *  但是msg1 + msg2 + msg3不管什么时候都会执行,不需要输出日志的时候也执行,
 *  所以存在资源浪费
 * @date 2020/3/31 11:15 下午
 */
public class LoggerDemo1 {
    /**
     * 定义一个根据日志的级别,显示日志信息的方法
     *
     * @param level
     * @param message
     */
    public static void showLog(int level, String message) {
        // 对日志等级进行判断,如果是1级别的就输出日志
        if (level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        // 定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        // 调用showLog方法,传递日志级别和日志信息
        showLog(1, msg1 + msg2 + msg3);
    }
}
