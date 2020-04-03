package lambda;

/**
 * @author lgl
 * @Description: 日志案例优化
 * 使用Lambda优化日志案例
 * Lambda的特点:延迟加载
 * Lambda的使用前提: 必须存在函数式接口
 * @date 2020/3/31 11:15 下午
 */
public class LoggerDemo2 {
    /**
     * 定义一个显示日志的方法,方法的参数传递日志的等级和MessageBuilder接口
     *
     * @param level
     * @param mb
     */
    public static void showLog(int level, MessageBuilder mb) {
        // 对日志等级进行判断,如果是1级别的就输出日志
        if (level == 1) {
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        // 定义三个日志信息
        String msg1 = "Hello";
        String msg2 = "World";
        String msg3 = "Java";

        // 调用showLog方法,传递日志级别和日志信息
        showLog(1, () -> msg1 + msg2 + msg3);
        /*
            使用Lambda表达式作为参数传递,仅仅是吧参数传递到showLog方法中,
            只有满足条件,日志的等级是1级,
                才会调用接口MessageBuilder中的方法builderMessage
                才会进行字符串的拼接
            如果条件不满足,日志等级不是1级
                那么接口MessageBuilder中的方法builderMessage也不会执行
                所以拼接字符串的代码也不会执行
            所以不会存在性能浪费
         */
    }
}
