package arraymethodreference;

/**
 * @author lgl
 * @Description: 定义一个创建数组的函数式接口
 * @date 2020/4/3 12:23 上午
 */
@FunctionalInterface
public interface ArrayBuilder {
    /**
     * 定义一个创建int类型数组的方法,参数传递数组的长度,返回创建好的int类型数组
     * @param length
     * @return
     */
    int[] builderArray(int length);
}
