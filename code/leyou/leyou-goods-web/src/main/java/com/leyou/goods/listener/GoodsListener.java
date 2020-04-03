package com.leyou.goods.listener;

import com.leyou.goods.service.impl.GoodsHtmlServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lgl
 * @Description: goods的RabbitMQ消费者(监听者)
 * @date 2020/3/2 11:50 下午
 */
@Component
@Slf4j
public class GoodsListener {
    @Autowired
    private GoodsHtmlServiceImpl goodsHtmlService;

    /**
     * 监听保存方法
     * @param id
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "LEYOU.ITEM.SAVE.QUEUE",durable = "true"),
            exchange = @Exchange(value = "LEYOU.ITEM.EXCHANGE",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
            key = {"item.insert","item.update"}
    ))
    public void save(Long id){
        if(id==null){
            return;
        }

        goodsHtmlService.createHtml(id);

        log.info("RabbitMQ: 监听保存方法成功");
    }

    /**
     * 监听删除方法
     * @param id
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "LEYOU.ITEM.DELETE.QUEUE",durable = "true"),
            exchange = @Exchange(value = "LEYOU.ITEM.EXCHANGE",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
            key = {"item.delete"}
    ))
    public void delete(Long id){
        if(id==null){
            return;
        }

        goodsHtmlService.deleteHtml(id);

        log.info("RabbitMQ: 监听删除方法成功");
    }
}
