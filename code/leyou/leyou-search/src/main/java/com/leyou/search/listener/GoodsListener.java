package com.leyou.search.listener;

import com.leyou.search.service.impl.SearchServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lgl
 * @Description:
 * @date 2020/3/3 12:04 上午
 */
@Component
@Slf4j
public class GoodsListener {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private SearchServiceImpl searchService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "LEYOU.SEARCH.SAVE.QUEUE", durable = "true"),
            exchange = @Exchange(value = "LEYOU.ITEM.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"item.insert", "item.update"}
    ))
    public void save(Long id) throws Exception {
        if (id == null) {
            return;
        }
        searchService.save(id);

        log.info("RabbitMQ: 监听保存方法成功");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "LEYOU.SEARCH.DELETE.QUEUE", durable = "true"),
            exchange = @Exchange(value = "LEYOU.ITEM.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"item.delete"}
    ))
    public void delete(Long id) throws Exception {
        if (id == null) {
            return;
        }
        searchService.delete(id);

        log.info("RabbitMQ: 监听删除方法成功");
    }
}
