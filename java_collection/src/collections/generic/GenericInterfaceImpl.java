package collections.generic;

/**
 * @author lgl
 * @Description: IGenericInterface接口实现类
 *  实现方式:
 *      第一种: 定义接口的实现类,实现接口,指定接口泛型
 * @date 2020/3/12 4:45 下午
 */
public class GenericInterfaceImpl implements IGenericInterface<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
