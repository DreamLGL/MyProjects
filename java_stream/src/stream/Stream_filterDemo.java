package stream;

import java.util.stream.Stream;

/**
 * @author lgl
 * @Description: Stream流中的常用方法filter
 * @date 2020/4/2 3:50 下午
 */
public class Stream_filterDemo {
    public static void main(String[] args) {
        // 获取一个stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "李四", "王五", "赵六", "田七");
        Stream<String> stream2 = stream.filter(name -> name.startsWith("张"));
        stream2.forEach(name -> System.out.println(name));

        /*
            Stream流属于管道流,只能被消费(使用)一次
            第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕,就会关闭了
            所以第一个Stream流就不能再调用方法了
         */
        // stream.forEach(name -> System.out.println(name)); //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
    }
}
