package com.cts.gatewaymaster.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
public class ErrorResponseDto 
{	
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
