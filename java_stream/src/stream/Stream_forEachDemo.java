package stream;

import java.util.stream.Stream;

/**
 * @author lgl
 * @Description: Stream 流中的常用方法 forEach
 * void forEach(Consumer<? super T> action)
 * 该方法接收一个Consumer接口函数,会将每一个流元素交给函数进行处理
 * Consumer是一个消费型的函数式接口,可以传递Lambda表达式,消费数据
 *
 * 简单记:
 *      forEach方法,用来遍历流中的数据
 *      是一个终结方法,遍历之后就不能继续调用Stream流中的其他方法
 * @date 2020/4/2 3:38 下午
 */
public class Stream_forEachDemo {
    public static void main(String[] args) {
        // 获取一个stream流
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
        // 使用Stream中的forEach遍历数组
        stream.forEach(name -> System.out.println(name));
    }
}
