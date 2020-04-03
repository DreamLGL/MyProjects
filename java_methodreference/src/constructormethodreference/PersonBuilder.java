package constructormethodreference;

/**
 * @author lgl
 * @Description: 定义一个创建Person对象的函数式接口
 * @date 2020/4/3 12:07 上午
 */
@FunctionalInterface
public interface PersonBuilder {
    /**
     * 定义一个方法,根据传递的姓名,创建Person对象返回
     *
     * @param name
     * @return
     */
    Person builderPerson(String name);
}
