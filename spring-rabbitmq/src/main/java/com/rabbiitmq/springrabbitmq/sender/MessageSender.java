package com.rabbiitmq.springrabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbiitmq.springrabbitmq.config.MessgaeConfig;
import com.rabbiitmq.springrabbitmq.model.CustomMessage;

import lombok.extern.slf4j.Slf4j;

@Component
public class MessageSender 
{
	private static final String EXCHANGE = "priority-exchange";

	private static final String ROUTING_KEY_PREFIX = "priority.queue.";
	@Autowired
	private  RabbitTemplate rabbitTemplate;
	public void sendPriorityMessage(CustomMessage content, Integer priority) {
	    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PREFIX   +"test", content,
	            message -> {
	                message.getMessageProperties().setPriority(priority);
	                return message;
	            });
	}
}
