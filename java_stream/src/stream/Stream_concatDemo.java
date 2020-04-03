package stream;

import java.util.stream.Stream;

/**
 * @author lgl
 * @Description: Stream流中的常用方法 concat: 用于把流组合到一起
 * @date 2020/4/2 4:53 下午
 */
public class Stream_concatDemo {
    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"美羊羊", "喜羊羊", "懒羊羊", "沸羊羊", "灰太狼", "红太狼"};
        String[] arr2 = {"张三丰", "张翠山", "赵敏", "周芷若", "李四", "王五", "赵六", "田七"};
        // 使用limit对Stream流中的元素进行截取,只取前4个元素
        Stream.concat(Stream.of(arr), Stream.of(arr2)).forEach(name -> System.out.println(name));
    }
}
