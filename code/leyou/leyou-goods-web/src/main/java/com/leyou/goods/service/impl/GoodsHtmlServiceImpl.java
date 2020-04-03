package com.leyou.goods.service.impl;

import com.leyou.goods.service.IGoodsHtmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author lgl
 * @Description: IGoodsService接口的实现类
 * @date 2020/3/1 4:24 下午
 */
@Service
public class GoodsHtmlServiceImpl implements IGoodsHtmlService {
    @Autowired
    private TemplateEngine engine;
    @Autowired
    private GoodsServiceImpl goodsService;

    @Override
    public void createHtml(Long spuId) {
        // 初始化运行上下文
        Context context = new Context();
        context.setVariables(goodsService.loadData(spuId));
        PrintWriter printWriter = null;
        try {
            //初始化一个输出流
            File file = new File("/opt/nginx/html/item/" + spuId + ".html");
            printWriter = new PrintWriter(file);
            engine.process("item", context, printWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }

    @Override
    public void deleteHtml(Long id) {
        //初始化一个输出流
        File file = new File("/opt/nginx/html/item/" + id + ".html");
        file.deleteOnExit();
    }
}
