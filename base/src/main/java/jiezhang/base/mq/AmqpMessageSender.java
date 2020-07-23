package jiezhang.base.mq;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AmqpMessageSender implements RabbitTemplate.ReturnCallback {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String topicExchange, String routingKey, Map<String, Object> messageMap) {

        if (MapUtil.isEmpty(messageMap)) {
//            log.warn("amqp消息为空");
            return;
        }
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("消息发送失败" + cause + correlationData.toString());
            }
        });
        this.rabbitTemplate.convertAndSend(topicExchange, routingKey, JSON.toJSONString(messageMap));
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
//        log.info("sender return success" + message.toString() + "===" + i + "===" + s1 + "===" + s2);
    }
}
