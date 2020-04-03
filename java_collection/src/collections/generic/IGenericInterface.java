package collections.generic;

/**
 * @author lgl
 * @Description: 定义一个含有泛型的接口:泛型定义在方法的修饰符和返回值之间
 * @date 2020/3/12 4:23 下午
 */
public interface IGenericInterface<I> {
    /**
     * 定义抽象方法
     *
     * @param i
     */
    public abstract void method(I i);
}
