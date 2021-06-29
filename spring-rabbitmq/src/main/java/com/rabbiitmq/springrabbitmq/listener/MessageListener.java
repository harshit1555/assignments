package com.rabbiitmq.springrabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbiitmq.springrabbitmq.config.MessgaeConfig;
import com.rabbiitmq.springrabbitmq.model.CustomMessage;
import com.rabbiitmq.springrabbitmq.sender.MessageSender;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageListener 
{
	@RabbitListener(queues = MessgaeConfig.QUEUE)
	public void listener(CustomMessage customMessage)
	{
		log.info(customMessage.toString());
		
	}
}
