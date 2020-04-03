package stream.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lgl
 * @Description: 集合元素处理(传统方式)
 * 1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
 * 2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
 * 3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
 * 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
 * 5. 将两个队伍合并为一个队伍；存储到一个新集合中。
 * 6. 根据姓名创建 Person 对象；存储到一个新集合中。
 * 7. 打印整个队伍的Person对象信息。
 * @date 2020/4/2 5:15 下午
 */
public class StreamTestDemo1 {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        ArrayList<String> newOne = new ArrayList<>();
        for (String s : one) {
            //2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
            if (s.length() == 3 && newOne.size() < 3) {
                newOne.add(s);
            }
        }
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        ArrayList<String> newTwo = new ArrayList<>();
        int index = 0;
        for (String s : two) {
            if (s.startsWith("张")) {
                if (index > 1) {
                    newTwo.add(s);
                } else {
                    index++;
                }
            }
        }

        //5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        ArrayList<String> all = new ArrayList<>();
        all.addAll(newOne);
        all.addAll(newTwo);

        ArrayList<Person> persons = new ArrayList<>();
        for (String s : all) {
            Person person = new Person();
            person.setName(s);
            persons.add(person);
        }

        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
