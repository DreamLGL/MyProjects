package stream;

import java.util.stream.Stream;

/**
 * @author lgl
 * @Description: 如果需要将流中的元素映射到另一个流中, 可以使用map方法
 * @date 2020/4/2 3:58 下午
 */
public class Stream_mapDemo {
    public static void main(String[] args) {
        // 获取一个stream流
        Stream<String> stream1 = Stream.of("1", "2", "3", "4", "5");
        Stream<Integer> stream2 = stream1.map(s -> Integer.parseInt(s));
        stream2.forEach(s -> System.out.println(s));
    }
}
