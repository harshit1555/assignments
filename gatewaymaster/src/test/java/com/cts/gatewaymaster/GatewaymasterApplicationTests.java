package com.cts.gatewaymaster;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.gatewaymaster.dto.GatewayMasterDto;
import com.cts.gatewaymaster.model.GatewayMaster;
import com.cts.gatewaymaster.repo.GatewayMasterRepo;
import com.cts.gatewaymaster.service.GatewayMasterService;

@SpringBootTest
class GatewaymasterApplicationTests 
{
	@Test
	void test()
	{
		assertTrue(true);
	}
}
