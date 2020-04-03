package function.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lgl
 * @Description: Predicate接口练习
 *  集合信息筛选:
 *     1.必须是女生;
 *     2.名字为四个字;
 * @date 2020/4/2 12:44 上午
 */
public class PredicateTest {
    /**
     *
     * @param arr
     * @param pre1
     * @param pre2
     * @return
     */
    public static ArrayList<String> screenArr(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : arr) {
            if (pre1.and(pre2).test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        ArrayList<String> list = screenArr(arr, s -> s.split(",")[0].length() == 4, s -> s.split(",")[1].equals("女"));
        System.out.println(list);
    }
}
