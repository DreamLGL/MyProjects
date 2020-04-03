package lambda;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/31 11:24 下午
 */
@FunctionalInterface
public interface MessageBuilder {
    /**
     * 定义一个拼接消息的抽象方法,返回被拼接的消息
     *
     * @return
     */
    public abstract String builderMessage();
}
