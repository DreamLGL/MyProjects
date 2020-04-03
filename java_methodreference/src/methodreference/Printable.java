package methodreference;

/**
 * @author lgl
 * @Description: 定义一个打印的函数式接口
 * @date 2020/4/2 10:53 下午
 */
@FunctionalInterface
public interface Printable {
    /**
     * 定义字符串的抽象方法
     *
     * @param s
     */
    void print(String s);

    /**
     * 测试方法
     */
    default void test() {
        System.out.println("测试玩玩");
    }
}
