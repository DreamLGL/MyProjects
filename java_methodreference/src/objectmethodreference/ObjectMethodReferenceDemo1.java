package objectmethodreference;

/**
 * @author lgl
 * @Description: 通过对象引用成员方法
 * 使用前提是对象名是已存在的,成员方法也是已经存在的
 * @date 2020/4/2 11:12 下午
 */
public class ObjectMethodReferenceDemo1 {
    /**
     * 定义一个方法,方法的参数传递Printable接口
     *
     * @param p
     */
    public static void printString(Printable p) {
        p.print("Hello");
    }

    public static void main(String[] args) {
        printString(msg->{
            MethodReferenceObject obj = new MethodReferenceObject();
            obj.printUpperCaseString(msg);
        });
        /*
            使用方法引用优化
         */
        MethodReferenceObject obj = new MethodReferenceObject();
        printString(obj::printUpperCaseString);
    }
}
