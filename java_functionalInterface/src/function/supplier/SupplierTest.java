package function.supplier;

import java.util.function.Supplier;

/**
 * @author lgl
 * @Description: 求数组元素最大值
 * 使用Supplier接口作为方法参数类型,通过Lambda表达式求出int数组中的最大值.
 * 提示: 接口的泛型使用java.lang.Integer
 * @date 2020/4/1 12:09 上午
 */
public class SupplierTest {
    /**
     * 定义一个方法,用于获取int类型数组中元素的最大值,方法的参数传递Supplier接口,泛型使用Integer
     *
     * @param sup
     * @return
     */
    public static Integer getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        //定义一个int类型的数组,并赋值
        int[] arr = {100, 0, -50, 88, 99, 33, -30};
        //调用getMax方法
        Integer maxValue = getMax(() -> {
            //获取数组的最大值并返回
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(maxValue);
    }
}
