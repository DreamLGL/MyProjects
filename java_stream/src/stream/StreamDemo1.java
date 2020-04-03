package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgl
 * @Description: Stream().filter()
 *      使用 Stream 流的方式遍历集合,对集合中的数据进行过滤
 *      Stream流是jdk1.8之后出现的
 *      关注的是做什么,而不是怎么做
 * @date 2020/4/2 10:34 上午
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");
        list.add("张翠山");
        list.add("灭绝师太");
        list.add("金毛狮王");

        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println(name));
    }
}
