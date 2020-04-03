package cn.lgl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lgl
 * @Description: Robbin负载均衡测试
 * @date 2020/1/16 12:20 上午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonLoadBalanceTest {
    @Autowired
    private RibbonLoadBalancerClient client;

    @Test
    public void test() {
        for (int i = 0; i < 50; i++) {
            ServiceInstance instance = this.client.choose("lgl-service-provider");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}
