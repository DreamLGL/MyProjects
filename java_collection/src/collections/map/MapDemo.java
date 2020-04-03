package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lgl
 * @Description: map集合练习:计算一个字符串中每个字符出现次数
 * @date 2020/3/13 4:00 下午
 */
public class MapDemo {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] split = s.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String s1 : split) {
            if (!map.containsKey(s1)) {
                map.put(s1, 1);
            } else {
                Integer value = map.get(s1);
                value++;
                map.put(s1, value);
            }
        }
        Set<String> keySet = map.keySet();
        for (String s1 : keySet) {
            System.out.println(s1 + ":" + map.get(s1));
        }
    }
}
