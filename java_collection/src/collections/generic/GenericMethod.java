package collections.generic;

/**
 * @author lgl
 * @Description: 定义一个含有泛型的方法:泛型定义在方法的修饰符和返回值之间
 * 格式:
 * 修饰符 <泛型> 返回值类型 方法名(参数列表(使用泛型)){
 * <p>
 * }
 * @date 2020/3/12 4:23 下午
 */
public class GenericMethod {
    /**
     * 定义一个含有泛型的方法
     *
     * @param m
     * @param <M>
     */
    public <M> void method(M m) {
        System.out.println(m);
    }

    /**
     * 定义一个含有泛型的静态方法
     * @param s
     * @param <S>
     */
    public static <S> void method2(S s){
        System.out.println(s);
    }
}
