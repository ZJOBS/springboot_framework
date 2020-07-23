package jiezhang.console.service.impl;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//此方法迁移至消费者MQ中，并且优先启动消费者
@Service
public class TService {
    @RabbitListener(queues = "aaa")
    @RabbitHandler
    public void process(String text, Channel channel, Message message) {
        try {
            System.out.println("接收到消息" + text);
            System.out.println(message);
        } catch (Exception e) {

        } finally {
            try {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
