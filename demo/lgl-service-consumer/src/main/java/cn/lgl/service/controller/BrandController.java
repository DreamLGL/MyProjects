package cn.lgl.service.controller;

import cn.lgl.service.client.IBrandClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description: controller层
 * @date 2020/1/13 10:58 下午
 */
@RestController
@RequestMapping("consumer/brand")
//@DefaultProperties(defaultFallback = "fallbackMethod") //定义熔断返回方法的全局配置
public class BrandController {
//    @Autowired
//    private RestTemplate restTemplate;

//    //包含了拉取的所有服务信息
//    @Autowired
//    private DiscoveryClient discoveryClient;
    @Autowired
    private IBrandClient brandClient;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/queryUserById")
    @HystrixCommand //声明熔断返回方法的单独方法配置
    public String queryUserById(@RequestParam(name = "id", required = true) Long id) {
        /*List<ServiceInstance> instances = discoveryClient.getInstances("lgl-service-provider");
        ServiceInstance instance = instances.get(0);*/
//        return restTemplate.getForObject("http://lgl-service-provider/brand/queryUserById?id=" + id, String.class);
        return this.brandClient.queryUserByid(id).toString();
    }

//    public String fallbackMethod() {
//        return "服务器正忙,请稍后再试!";
//    }
}
