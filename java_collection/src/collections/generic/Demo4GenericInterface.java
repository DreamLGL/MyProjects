package collections.generic;

/**
 * @author lgl
 * @Description: 测试泛型接口
 * @date 2020/3/12 4:49 下午
 */
public class Demo4GenericInterface {
    public static void main(String[] args) {
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.method("hello");

        GenericInterfaceImpl2<Integer> genericInterface1 = new GenericInterfaceImpl2<>();
        genericInterface1.method(10);
    }
}
