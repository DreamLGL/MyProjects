package staticmethodreference;

/**
 * @author lgl
 * @Description: 通过类名引用静态成员方法
 * 前提是,类已经存在,静态成员方法也已经存在
 * @date 2020/4/2 11:19 下午
 */
public class StaticMethodReferenceDemo1 {
    /**
     * 定义一个方法,方法的参数传递要计算绝对值的整数,和函数式接口Calcable
     * @param number
     * @param c
     * @return
     */
    public static int method(int number,Calcable c){
        return c.calsAbs(number);
    }

    public static void main(String[] args) {
        int i = method(-10, number -> Math.abs(number));
        System.out.println(i);


        int i2 = method(-10, Math::abs);
        System.out.println(i2);
    }
}
