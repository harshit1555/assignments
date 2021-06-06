package com.cts.gatewaymaster.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Valid
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatewayMaster 
{
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gatewayId;
	@Column(length = 30)
	@NotNull
	private String gatewayType;
	@Column(length=20)
	@NotNull
	private String gatewayCode;
	@Column(length = 200)
	@NotNull
	private String gatewayDescription;
	@NotNull
	private long gatewayTypeProviderId;
	@NotNull
	private boolean isActive;
	@NotNull
	private Date createdon=new Date(System.currentTimeMillis());
	@NotNull
	private Date updatedon=new Date(System.currentTimeMillis());
	
	public GatewayMaster(@NotNull long gatewayId, @NotNull String gatewayType, @NotNull String gatewayCode,
			@NotNull String gatewayDescription, @NotNull long gatewayTypeProviderId, @NotNull boolean isActive) {
		super();
		this.gatewayId = gatewayId;
		this.gatewayType = gatewayType;
		this.gatewayCode = gatewayCode;
		this.gatewayDescription = gatewayDescription;
		this.gatewayTypeProviderId = gatewayTypeProviderId;
		this.isActive = isActive;
	}
	
	
	
	
		
}
