package thismethodreference;

/**
 * @author lgl
 * @Description: 通过this引用本类的成员方法
 * @date 2020/4/2 11:47 下午
 */
public class Husband {
    /**
     * 定义一个买房子的方法
     */
    public void buyHouse() {
        System.out.println("北京二环内买一套四合院");
    }

    /**
     * 定义一个结婚的方法,参数传递Richable接口
     *
     * @param r
     */
    public void marry(Richable r) {
        r.buy();
    }

    /**
     * 定义一个非常高兴的方法
     */
    public void soHappy() {
        //调用结婚的方法
        // 传统方法
        marry(() -> this.buyHouse());
        // 优化
        marry(this::buyHouse);
    }

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}
