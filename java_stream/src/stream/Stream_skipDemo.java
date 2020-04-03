package stream;

import java.util.stream.Stream;

/**
 * @author
 * @Description: Stream流中的常用方法 skip: 用于跳过元素
 * 如果希望跳过前几个元素,可以使用skip方法获取一个截取之后的新流:
 * Stream<T> skip(long n);
 *      如果流的当前长度大于n,则跳过前n个;否则将会得到一个长度为0的空流
 * @date 2020/4/2 4:44 下午
 */
public class Stream_skipDemo {
    public static void main(String[] args) {
        // 获取一个Stream流
        String[] arr = {"美羊羊", "喜羊羊", "懒羊羊", "沸羊羊", "灰太狼", "红太狼"};
        // 使用limit对Stream流中的元素进行截取,只取前4个元素
        Stream.of(arr).skip(4).forEach(name -> System.out.println(name));
    }
}
