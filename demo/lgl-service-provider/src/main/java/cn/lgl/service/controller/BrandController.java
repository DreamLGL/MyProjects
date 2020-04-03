package cn.lgl.service.controller;

import cn.lgl.service.pojo.Brand;
import cn.lgl.service.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lgl
 * @Description: Controller层
 * @date 2020/1/13 10:39 下午
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/queryUserById")
    public Brand queryUserByid(@RequestParam(name = "id",required = true) Long id){
        /*try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return brandService.queryUserByid(id);
    }
}
