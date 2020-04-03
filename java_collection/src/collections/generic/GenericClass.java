package collections.generic;

/**
 * @author lgl
 * @Description: 定义一个含有泛型的类, 模拟ArrayList
 * @date 2020/3/12 4:23 下午
 */
public class GenericClass<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
