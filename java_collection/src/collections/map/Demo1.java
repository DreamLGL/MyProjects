package collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author lgl
 * @Description: MapDemo1:map遍历
 * @date 2020/3/13 3:11 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        show2();
    }

    /**
     * entrySet()遍历
     */
    private static void show2() {
        Map<String, Integer> map = new HashMap<>(10);
        map.put("张三", 170);
        map.put("李四", 175);
        map.put("王五", 180);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }
    }

    /**
     * keySet()遍历
     */
    private static void show1() {
        Map<String, Integer> map = new HashMap<>(10);
        map.put("张三", 170);
        map.put("李四", 175);
        map.put("王五", 180);
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println("key: " + s);
            System.out.println("value: " + map.get(s));
        }
    }
}
