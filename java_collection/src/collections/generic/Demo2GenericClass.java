package collections.generic;

/**
 * @author lgl
 * @Description: 测试自定义泛型
 * @date 2020/3/12 4:25 下午
 */
public class Demo2GenericClass {
    public static void main(String[] args) {
        // 不写泛型默认为Object
        GenericClass gc = new GenericClass();
        gc.setName("字符串");

        //创建GenericClass对象,泛型使用Integer
        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(1);

        Integer name = gc2.getName();
        System.out.println(name);
    }
}
