package com.rabbiitmq.springrabbitmq.publisher;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rabbiitmq.springrabbitmq.config.MessgaeConfig;
import com.rabbiitmq.springrabbitmq.model.CustomMessage;
import com.rabbiitmq.springrabbitmq.sender.MessageSender;


@RestController
public class MessagePublisher 
{
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private MessageSender messageSender;
	@PostMapping("/publish")
	public String publishMessage(@RequestBody CustomMessage customMessage)
	{
		customMessage.setMessageId(UUID.randomUUID().toString());
		customMessage.setDate(new Date());
		messageSender.sendPriorityMessage(customMessage, customMessage.getPriority());
		return "Success!!";		
	}
}
