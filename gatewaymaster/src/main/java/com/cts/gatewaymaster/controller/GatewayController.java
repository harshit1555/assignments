package com.cts.gatewaymaster.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.exception.GatewayNotFoundException;
import com.cts.gatewaymaster.model.GatewayMaster;
import com.cts.gatewaymaster.repo.GatewayMasterRepo;
import com.cts.gatewaymaster.service.GatewayMasterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GatewayController 
{
	@Autowired
	GatewayMasterRepo gatewayRepo;
		@PostConstruct
		public void init()
		{
			
		GatewayMaster gatewayMaster=new GatewayMaster(2, "Abc", "asgd", "best gateway", 10, false);
		gatewayRepo.save(gatewayMaster);
		}
	@Autowired
	GatewayMasterService  gatewayMasterService;
	@GetMapping("/getAll")
	public List<GatewayMasterDto> getAllGatewayMaster() throws GatewayNotFoundException
	{
		log.info("/getAll api called");
		return gatewayMasterService.getAllGateWay();
	}
	@GetMapping("/get/{id}")
	public GatewayMasterDto searchGatewayById(@PathVariable long id) throws GatewayNotFoundException
	{
		log.info("/searchById api called");
		return gatewayMasterService.searchById(id);
	}
	@PostMapping("/save")
	public GatewayMasterDto saveGatewayMaster(@Valid @RequestBody GatewayMasterDto gatewayMasterDto)
	{
		log.info("/save api called");
		return gatewayMasterService.saveGatewayMaster(gatewayMasterDto);
	}
	
}
