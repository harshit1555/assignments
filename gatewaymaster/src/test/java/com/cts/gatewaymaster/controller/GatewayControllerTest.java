package com.cts.gatewaymaster.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.model.GatewayMaster;
import com.cts.gatewaymaster.service.GatewayMasterService;
@SpringBootTest
class GatewayControllerTest 
{
	@Autowired
	GatewayController gatewayController;
	@MockBean
	GatewayMasterService gatewayMasterService;
	@Test
	void testGetAllGatway() throws Exception
	{
		List<GatewayMasterDto> listOfDto=new ArrayList();
		GatewayMasterDto gatewayMasterDto=new GatewayMasterDto(1, "Zuul", "Gateway1", "best gateway", 1, false);
		GatewayMasterDto gatewayMasterDto1=new GatewayMasterDto(2, "AWS", "Gateway2", "good gateway", 2, true);
		listOfDto.add(gatewayMasterDto);
		listOfDto.add(gatewayMasterDto1);
		Mockito.when(gatewayMasterService.getAllGateWay()).thenReturn(listOfDto);
		assertEquals(gatewayMasterService.getAllGateWay(), gatewayController.getAllGatewayMaster());
	}
	@Test
	void testSearchGatewayById() throws Exception
	{
		GatewayMasterDto gatewayMasterDto=new GatewayMasterDto(2, "AWS", "Gateway2", "good gateway", 2, true);
		Mockito.when(gatewayMasterService.searchById(2L)).thenReturn(gatewayMasterDto);
		assertEquals(gatewayMasterService.searchById(2L), gatewayController.searchGatewayById(2L));
	}
	@Test
	void testSaveGateway()
	{
		GatewayMasterDto gatewayMasterDto=new GatewayMasterDto(2, "Abc", "asgd", "best gateway", 10, false);
		Mockito.when(gatewayMasterService.saveGatewayMaster(gatewayMasterDto)).thenReturn(gatewayMasterDto);
		assertEquals(gatewayMasterService.saveGatewayMaster(gatewayMasterDto), gatewayController.saveGatewayMaster(gatewayMasterDto));
	}

}
