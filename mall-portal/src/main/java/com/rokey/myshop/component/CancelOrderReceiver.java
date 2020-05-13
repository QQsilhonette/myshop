package com.rokey.myshop.component;

import com.rokey.myshop.service.OmsPortalOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/5/13 5:55 下午
 * @description：取消订单的消息处理者
 */
@Slf4j
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    @Resource
    private OmsPortalOrderService portalOrderService;

    @RabbitHandler
    public void handler(Long orderId) {
        portalOrderService.cancelOrder(orderId);
        log.info("process orderId:{}", orderId);
    }
}
