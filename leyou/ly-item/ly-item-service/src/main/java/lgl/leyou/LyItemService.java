package lgl.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lgl
 * @Description: 启动类
 * @date 2020/1/5 11:35 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("lgl.leyou.item.mapper")
public class LyItemService {
    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class, args);
    }
}
