package supermethodreference;

/**
 * @author lgl
 * @Description: 定义子类
 * @date 2020/4/2 11:35 下午
 */
public class Man extends Human {
    /**
     * 子类重写父类sayHello方法
     */
    @Override
    public void sayHello() {
        System.out.println("Hello,I'm Man!");
    }

    /**
     * 定义一个方法,参数传递Greetable 接口
     *
     * @param g
     */
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        // 调用method方法,方法的参数Greetable是个函数式接口,所以可以传递Lambda
        method(() -> {
            Human h = new Human();
            h.sayHello();
        });
        //优化1:因为有子父类关系,所以存在一个关键字super,代表父类,所以我们可以直接使用super调用父类的成员方法
        method(() -> {
            super.sayHello();
        });
        //优化2:
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }
}
