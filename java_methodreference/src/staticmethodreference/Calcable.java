package staticmethodreference;

/**
 * @author lgl
 * @Description:
 * @date 2020/4/2 11:20 下午
 */
@FunctionalInterface
public interface Calcable {
    /**
     * 定义一个抽象方法,传递一个整数,对整数进行绝对值计算并返回
     *
     * @param number
     * @return
     */
    int calsAbs(int number);
}
