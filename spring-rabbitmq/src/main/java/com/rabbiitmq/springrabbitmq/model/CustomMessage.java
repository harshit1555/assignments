package com.rabbiitmq.springrabbitmq.model;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomMessage 
{
	private String messageId;
	private String message;
	private Date date;
	private int priority;
}
