package com.rabbiitmq.springrabbitmq.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
@Configuration
public class MessgaeConfig
{
	private static final String EXCHANGE = "priority-exchange";

	public static final String QUEUE = "priority-queue";

	private static final String ROUTING_KEY = "priority.queue.#";
	@Bean
	Queue queue() {
	    Map<String, Object> args= new HashMap<>();
	    args.put("x-max-priority", 10);
	    return new Queue(QUEUE, false, false, false, args);
	}
	@Bean
	TopicExchange exchange() {
	    return new TopicExchange(EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
	    return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	@Bean
	public MessageConverter converter()
	{
		return new Jackson2JsonMessageConverter();
	}
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory)
	{
		RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}
 	
}
