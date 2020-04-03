package cn.lgl.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lgl
 * @Description: 模拟内存溢出
 * @date 2020/3/16 4:02 下午
 */
public class TestJvmOutOfMemory {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            String str = "";
            for (int j = 0; j < 1000; j++) {
                str += UUID.randomUUID().toString();
            }
            list.add(str);
        }
        System.out.println("ok");
    }
}
