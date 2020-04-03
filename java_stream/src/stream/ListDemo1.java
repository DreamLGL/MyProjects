package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgl
 * @Description: 使用传统的方式, 遍历集合, 对集合中的数据进行过滤
 * @date 2020/4/2 10:27 上午
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");
        list.add("张翠山");
        list.add("灭绝师太");
        list.add("金毛狮王");

        // 对list中的元素过滤,只要以张开头的元素,存储到一个新的集合中
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                list1.add(s);
            }
        }
        System.out.println(list1);

        // 对list中的元素过滤,只要姓名长度为3的人,存储到一个新的集合中
        List<String> list2 = new ArrayList<>();
        for (String s : list) {
            if (s.length() == 3) {
                list2.add(s);
            }
        }
        System.out.println(list2);
    }
}
