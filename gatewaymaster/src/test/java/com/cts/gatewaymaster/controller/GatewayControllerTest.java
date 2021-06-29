package com.cts.gatewaymaster.controller;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.model.GatewayMaster;
import com.cts.gatewaymaster.service.GatewayMasterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.status.Status;
import junit.framework.Assert;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class GatewayControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	GatewayMasterService gatewayMasterService;
	@Test
	@WithMockUser(username = "user")
	void testGetAll() throws Exception
	{
		List<GatewayMasterDto> list=new ArrayList<>();
		GatewayMasterDto gatewayMaster=new GatewayMasterDto(1, "Zuul", "Gateway1", "best gateway", 1, false);
		GatewayMasterDto gatewayMaster1=new GatewayMasterDto(2, "AWS", "Gateway2", "good gateway", 2, true);
		list.add(gatewayMaster);
		list.add(gatewayMaster1);
		when(gatewayMasterService.getAllGateWay()).thenReturn(list);
		MvcResult result=mockMvc.perform(get("/getAll")).andReturn();
		assertEquals(200, result.getResponse().getStatus());
															
	}
	@Test
	@WithMockUser(username = "user")
	void testGetById() throws Exception
	{
		GatewayMasterDto gatewayMaster=new GatewayMasterDto(1, "Zuul", "Gateway1", "best gateway", 1, false);
		when(gatewayMasterService.searchById(1)).thenReturn(gatewayMaster);
		MvcResult result=mockMvc.perform(get("/get/"+1)).andReturn();
		assertEquals(200, result.getResponse().getStatus());		 
	}
	
	
}
