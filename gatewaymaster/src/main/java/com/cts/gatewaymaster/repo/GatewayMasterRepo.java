package com.cts.gatewaymaster.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.gatewaymaster.model.GatewayMaster;

public interface GatewayMasterRepo extends JpaRepository<GatewayMaster,Long>
{

}
