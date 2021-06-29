package com.cts.gatewaymaster.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.cts.gatewaymaster.dto.ErrorResponseDto;
public class GlobalExceptionHandler  
{
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({Exception.class})
	public ErrorResponseDto cartNotFoundException(Exception ex,HttpServletRequest request )
	{
		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
}
