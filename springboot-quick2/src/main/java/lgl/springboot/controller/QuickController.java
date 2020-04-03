package lgl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description:
 * @date 2019/12/22 5:54 下午
 */
@RestController
@RequestMapping("/quick")
public class QuickController {

    @RequestMapping("/quick2")
    public String quick() {
        return "hello springboot";
    }

}
