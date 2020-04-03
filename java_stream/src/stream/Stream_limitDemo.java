package stream;

import java.util.stream.Stream;

/**
 * @author lgl
 * @Description: Stream流中的常用方法 limit: 用于截取流中的元素
 * limit方法可以对流进行截取,只取用前n个.
 * Stream<T> limit(Long maxSize);
 *      参数是一个long型,如果集合当前长度大于参数则进行截取;否则不进行操作
 * limit方法是一个延迟方法,只是对流中的元素进行截取,返回的是一个新的流,所以可以继续调用Stream流中的其他方法
 * @date 2020/4/2 4:34 下午
 */
public class Stream_limitDemo {
    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"美羊羊", "喜羊羊", "懒羊羊", "沸羊羊", "灰太狼", "红太狼"};
        // 使用limit对Stream流中的元素进行截取,只取前4个元素
        Stream.of(arr).limit(4).forEach(name -> System.out.println(name));
    }
}
