package collections.generic;

/**
 * @author lgl
 * @Description: IGenericInterface接口实现类
 * 实现方式:
 * 第二种: 接口使用什么泛型,实现类就使用什么泛型,类跟着接口走,就相当于定义了一个含有泛型的类,
 * 创建对象的时候确定泛型的类型
 * @date 2020/3/12 4:45 下午
 */
public class GenericInterfaceImpl2<I> implements IGenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}
