package com.cts.gatewaymaster.controller;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.exception.GatewayNotFoundException;
import com.cts.gatewaymaster.service.GatewayMasterService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GatewayController  
{
	@Autowired
	GatewayMasterService  gatewayMasterService;
	@Operation(summary = "To get information of All the gateway")
	@Cacheable(value = "configurations")
	@GetMapping("/getAll")
	public List<GatewayMasterDto> getAllGatewayMaster() throws GatewayNotFoundException
	{
		log.info("/getAll api called");
		return gatewayMasterService.getAllGateWay();
	}
	@Operation(summary = "To search gateway with Id")
	@Cacheable(value = "configurations", key="#id")
	@GetMapping("/get/{id}")
	public GatewayMasterDto searchGatewayById(@PathVariable long id) throws GatewayNotFoundException
	{
		log.info("/searchById api called");
		return gatewayMasterService.searchById(id);
	}
	@Operation(summary = "To add information of gateway")
	@PostMapping("/save")
	public GatewayMasterDto saveGatewayMaster(@Valid @RequestBody GatewayMasterDto gatewayMasterDto)
	{
		log.info("/save api called");
		return gatewayMasterService.saveGatewayMaster(gatewayMasterDto);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteGatewayMaster(@PathVariable long id) throws GatewayNotFoundException
	{
		log.info("/delete api called");
		return gatewayMasterService.deleteGatewayMaster(id);
	}
	
}
