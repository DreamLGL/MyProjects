package cn.lgl.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * @author lgl
 * @Description: 测试垃圾回收
 * @date 2020/3/17 3:24 下午
 */
public class TestGC {
    /**
     * 实现: 不断的产生新的数据(对象),随机废弃对象(垃圾)
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        List<Object> list = new ArrayList<>();
        while (true) {
            int sleep = new Random().nextInt(100);
            if (System.currentTimeMillis() % 2 == 0) {
                //当前的时间戳,是偶数
                list.clear();
            } else {
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_" + i, "value_" + i);
                    list.add(properties);
                }
            }
            Thread.sleep(sleep);
        }
    }
}
