package com.example.eventms.users.config;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {



    @Value("${rabbitmq.queue.registration.name}")
    private String QUEUE;

    @Value("${rabbitmq.exchange.registration.name}")
    private String EXCHANGE;

   @Value("${rabbitmq.binding.registration.name}")
    private String ROUTING_KEY;

    //Queue creation

   @Bean
    public Queue messageQueue(){
        return new Queue(QUEUE);
    }

    //Topic Exchange creation
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    //Create Binding between queue and exchange

    @Bean
    public Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter(){
       return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;

    }
}
