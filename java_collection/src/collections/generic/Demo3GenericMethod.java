package collections.generic;

/**
 * @author lgl
 * @Description: 测试含有泛型的方法
 * @date 2020/3/12 4:36 下午
 */
public class Demo3GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm=new GenericMethod();
        gm.method(10);
        gm.method("abc");
        gm.method(true);

        gm.method2("静态方法,不建议创建对象使用");
        GenericMethod.method2("静态方法");
        GenericMethod.method2(1);
    }
}
