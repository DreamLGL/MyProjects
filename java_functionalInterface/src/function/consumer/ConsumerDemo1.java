package function.consumer;

import java.util.function.Consumer;

/**
 * @author lgl
 * @Description: java.util.function Interface Consumer<T>接口正好与Supplier接口相反,
 * 它不是生产一个数据,而是消费一个数据,其数据类型由泛型决定.
 * Consumer接口中包含抽象方法void accept(T t),意为消费一个指定泛型的数据
 * <p>
 * Consumer接口是一个消费型接口,泛型执行什么类型,就可以使用accept方法消费什么类型的数据
 * 至于具体怎么消费(使用),需要自定义(输出,计算...)
 * @date 2020/4/1 4:51 下午
 */
public class ConsumerDemo1 {
    /**
     * 定义一个方法
     * 方法的参数传递一个字符串姓名
     * 方法的参数传递Consumer接口,泛型使用String
     * 可以使用Consumer接口消费字符串姓名
     *
     * @param name
     * @param consumer
     */
    public static void method(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    public static void main(String[] args) {
        method("胡歌", name -> {
            //消费方式一:直接输出字符串
            System.out.println("消费方式一: " + name);
            //消费方式二: 把字符串进行反转输出
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println("消费方式二: " + reName);
        });
    }
}
