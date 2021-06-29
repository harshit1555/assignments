package com.cts.gatewaymaster.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.exception.GatewayNotFoundException;
import com.cts.gatewaymaster.model.GatewayMaster;
import com.cts.gatewaymaster.repo.GatewayMasterRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GatewayMasterService 
{
	@Autowired
	GatewayMasterRepo gatewayMasterRepo;
	
	@Transactional
	public List<GatewayMasterDto> getAllGateWay() throws GatewayNotFoundException
	{
		log.info("getAllGateway called:");
		List<GatewayMaster> listOfGatewayMaster=gatewayMasterRepo.findAll();
		List<GatewayMasterDto> listOfGatewayMasterDto=new ArrayList<>();
		listOfGatewayMaster.forEach(gatewayMaster->listOfGatewayMasterDto.add(gatewayMasterToGatewayMasterDto(gatewayMaster)));
		if(listOfGatewayMaster.isEmpty())
		{
			throw new GatewayNotFoundException("No Data is found");
		}
		log.info(listOfGatewayMasterDto.toString());
		return listOfGatewayMasterDto;
	}
	@Transactional
	public GatewayMasterDto searchById(long id) throws GatewayNotFoundException
	{ 
		log.info("getway is searching by id:");
		var gatewayMaster=gatewayMasterRepo.getById(id);	
		if(gatewayMaster==null) {
			
			throw new GatewayNotFoundException("Gateway with id ["+id+"] not found");
		}
		var gatewayMasterDto=gatewayMasterToGatewayMasterDto(gatewayMaster);
			log.info(gatewayMasterDto.toString());
		return gatewayMasterDto;
	}
	@Transactional
	public GatewayMasterDto saveGatewayMaster(GatewayMasterDto gatewayMasterDto)
	{
		log.info("Saving a new gateway");
		var gatewayMaster=gateWayMasterDtoToGatewayMaster(gatewayMasterDto);
		gatewayMasterRepo.save(gatewayMaster);
		log.info("data saved");
		return gatewayMasterDto;
	}
	@Transactional
	public String deleteGatewayMaster(long id) throws GatewayNotFoundException
	{
		log.info("Deleting a gateway");
		var gatewayMaster=gatewayMasterRepo.findById(id).orElse(null);
		if(gatewayMaster==null)
		{
			throw new GatewayNotFoundException("Gateway with id ["+id+"] not found");
		}
		gatewayMasterRepo.delete(gatewayMaster);
		log.info("Gateway deleted");
		return "Gateway Succesfully deleted";
	}
	public GatewayMaster gateWayMasterDtoToGatewayMaster(GatewayMasterDto gatewayMasterDto)
	{
		var gatewayMaster=new GatewayMaster();
		gatewayMaster.setGatewayId(gatewayMasterDto.getGatewayId());
		gatewayMaster.setActive(gatewayMasterDto.isActive());
		gatewayMaster.setCreatedon(gatewayMasterDto.getCreatedon());
		gatewayMaster.setUpdatedon(gatewayMasterDto.getUpdatedon());
		gatewayMaster.setGatewayCode(gatewayMasterDto.getGatewayCode());
		gatewayMaster.setGatewayDescription(gatewayMasterDto.getGatewayDescription());
		gatewayMaster.setGatewayType(gatewayMasterDto.getGatewayType());
		gatewayMaster.setGatewayTypeProviderId(gatewayMasterDto.getGatewayTypeProviderId());
		return gatewayMaster;
	}
	public GatewayMasterDto gatewayMasterToGatewayMasterDto(GatewayMaster gatewayMaster)
	{
		var gatewayMasterDto=new GatewayMasterDto();
		gatewayMasterDto.setGatewayId(gatewayMaster.getGatewayId());
		gatewayMasterDto.setActive(gatewayMaster.isActive());
		gatewayMasterDto.setCreatedon(gatewayMaster.getCreatedon());
		gatewayMasterDto.setUpdatedon(gatewayMaster.getUpdatedon());
		gatewayMasterDto.setGatewayCode(gatewayMaster.getGatewayCode());
		gatewayMasterDto.setGatewayDescription(gatewayMaster.getGatewayDescription());
		gatewayMasterDto.setGatewayType(gatewayMaster.getGatewayType());
		gatewayMasterDto.setGatewayTypeProviderId(gatewayMaster.getGatewayTypeProviderId());
		return gatewayMasterDto;	
	}
}
