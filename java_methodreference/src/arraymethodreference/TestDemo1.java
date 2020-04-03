package arraymethodreference;

/**
 * @author lgl
 * @Description: 数组的构造器
 * @date 2020/4/3 12:26 上午
 */
public class TestDemo1 {
    public static int[] createArray(int length,ArrayBuilder ab){
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        int[] array = createArray(10, length -> new int[length]);
        System.out.println(array.length);

        // 优化
        int[] array1 = createArray(10, int[]::new);
        System.out.println(array1.length);
    }
}
