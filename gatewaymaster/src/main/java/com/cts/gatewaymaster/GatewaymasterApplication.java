package com.cts.gatewaymaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info=@Info(title="CCM Gateway Application",version ="1.0.0" ))
public class GatewaymasterApplication  
{

	public static void main(String[] args) 
	{
		SpringApplication.run(GatewaymasterApplication.class, args);
	}

}
