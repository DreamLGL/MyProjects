package cn.lgl.jvm;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lgl
 * @Description: jvm测试
 * @date 2020/3/16 10:39 上午
 */
public class TestJvm {
    public static void main(String[] args) {
        String str = System.getProperty("str");
        if(StringUtils.isBlank(str)){
            System.out.println("lgl");
        }else{
            System.out.println(str);
        }
    }
}
