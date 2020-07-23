package jiezhang.console;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

public enum Queues {
    TEXT(new Queue("aaa"), new TopicExchange("bb"), "cc");

    private Queue queue;
    private TopicExchange topicExchange;
    private String routingKey;

    Queues(Queue queue, TopicExchange topicExchange, String routingKey) {
        this.queue = queue;
        this.topicExchange = topicExchange;
        this.routingKey = routingKey;
    }

    @Bean
    public Queue testQueue() { return TEXT.queue; }
    @Bean
    TopicExchange testTopicExchange() { return TEXT.topicExchange; }
    @Bean
    Binding bindingExchangeTfData() { return BindingBuilder.bind(TEXT.queue).to(TEXT.topicExchange).with(TEXT.routingKey);}
}
