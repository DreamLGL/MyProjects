package com.lgl.consumer.controller;

import com.lgl.consumer.client.UserClient;
import com.lgl.consumer.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/24 11:47 下午
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {
//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private RibbonLoadBalancerClient client;

    @Autowired
    private UserClient userClient;

    @RequestMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }




//    @RequestMapping("{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallback")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
//    })

//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
//    })
//    public String queryById(@PathVariable("id") Long id) {
//        if (id % 2 == 0) {
//            throw new RuntimeException("test bug");
//        }
//        String url = "http://user-service/user/" + id;
//        System.out.println("url :" + url);
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }

    public String queryByIdFallback(Long id) {
        return "不好意思,服务器正忙";
    }

    public String defaultFallback() {
        return "不好意思,服务器正忙";
    }


//    @RequestMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        //根据服务id去获取实例
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //从实例当中取出ip和端口
////        ServiceInstance instance = instances.get(0);
//
//        //负载均衡算法:随机,轮询,hash,最少访问
////        ServiceInstance instance = client.choose("user-service");
////        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/ " + id;
//        String url = "http://user-service/user/" + id;
//        System.out.println("url :" + url);
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }
}
