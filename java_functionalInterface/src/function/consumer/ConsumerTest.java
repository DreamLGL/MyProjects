package function.consumer;

import java.util.function.Consumer;

/**
 * @author lgl
 * @Description: Consumer练习
 * 格式化打印信息
 * @date 2020/4/1 11:27 下午
 */
public class ConsumerTest {
    /**
     * 定义一个方法,参数传递String类型的数组和两个Consumer接口,泛型使用字符串
     *
     * @param arr
     * @param con1
     * @param con2
     */
    public static void printInfo(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        for (String s : arr) {
            con1.andThen(con2).accept(s);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"张三,18", "李四,19", "王五,20", "赵六,21"};
        printInfo(arr,
                s -> System.out.print("姓名: " + s.split(",")[0] + "; "),
                s -> System.out.println("年龄: " + s.split(",")[1] + "; ")
        );
    }
}
