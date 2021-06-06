package com.cts.gatewaymaster.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.exception.GatewayNotFoundException;
import com.cts.gatewaymaster.model.GatewayMaster;
import com.cts.gatewaymaster.repo.GatewayMasterRepo;
import com.cts.gatewaymaster.service.GatewayMasterService;

@SpringBootTest 
class GatewaymasterApplicationTests 
{ 
	@Autowired
	GatewayMasterService gatewayMasterService;
	
	@MockBean
	GatewayMasterRepo gatewayMasterRepo;
	
	@Test
	 void testGetAll() throws Exception
	{
		List<GatewayMaster> list=new ArrayList<>();
		
		GatewayMaster gatewayMaster=new GatewayMaster(2, "Abc", "asgd", "best gateway", 10, false);
		list.add(gatewayMaster);
		Mockito.when(gatewayMasterRepo.findAll()).thenReturn(list);
		List<GatewayMasterDto> listOfGatewayMasterDto=gatewayMasterService.getAllGateWay();
		List<GatewayMaster> listOfGatewayMaster=new ArrayList<>();
		listOfGatewayMasterDto.forEach(gatewayMasterDto->{listOfGatewayMaster.add(gatewayMasterService.gateWayMasterDtoToGatewayMaster(gatewayMasterDto));});
		assertEquals(gatewayMasterRepo.findAll(), listOfGatewayMaster);
	}
	@Test
	 void testSearchById() throws Exception
	{
		GatewayMaster gatewayMaster=new GatewayMaster(2, "Abc", "asgd", "best gateway", 10, false);
		Mockito.when(gatewayMasterRepo.getById(2L)).thenReturn(gatewayMaster);
		
		GatewayMaster gatewayMasterActual=gatewayMasterService.gateWayMasterDtoToGatewayMaster(gatewayMasterService.searchById(2L));
		assertEquals(gatewayMasterRepo.getById(2L), gatewayMasterActual);
	}
	@Test
	 void testSave()
	{
		GatewayMaster gatewayMaster=new GatewayMaster(2, "Abc", "asgd", "best gateway", 10, false);
		Mockito.when(gatewayMasterRepo.save(gatewayMaster)).thenReturn(gatewayMaster);
		GatewayMasterDto gatewayMasterDto=new GatewayMasterDto(2, "Abc", "asgd", "best gateway", 10, false);
		GatewayMaster Actual=gatewayMasterService.gateWayMasterDtoToGatewayMaster(gatewayMasterService.saveGatewayMaster(gatewayMasterDto));
		assertEquals(gatewayMasterRepo.save(gatewayMaster).toString(), Actual.toString());
		
	}
	@Test
	void testGatewayNotFoundException()
	{
		long id=5;
		assertThrows(GatewayNotFoundException.class,()->gatewayMasterService.searchById(id),"Gateway with id ["+id+"] not found");
	}
	@Test
	 void testDataNotFoundException()
	{
		assertThrows(GatewayNotFoundException.class,()->gatewayMasterService.getAllGateWay(),"No Data is found");
	}
	}
