package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lgl
 * @Description: Stream流中的常用方法 count:用于统计Stream流中元素的个数
 * long count()
 * count方法是一个终结方法
 * @date 2020/4/2 4:05 下午
 */
public class Stream_countDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }
}
