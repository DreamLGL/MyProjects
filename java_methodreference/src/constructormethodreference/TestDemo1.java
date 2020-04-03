package constructormethodreference;

/**
 * @author lgl
 * @Description: 类的构造器(构造方法)引用
 * @date 2020/4/3 12:13 上午
 */
public class TestDemo1 {
    /**
     * 定义一个方法,参数传递姓名和PersonBuilder接口
     * @param name
     * @param pb
     */
    public static void printName(String name ,PersonBuilder pb){
        final Person person = pb.builderPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        //传统Lambda
        printName("李四",s->new Person(s));
        //优化
        printName("张三",Person::new);
    }
}
