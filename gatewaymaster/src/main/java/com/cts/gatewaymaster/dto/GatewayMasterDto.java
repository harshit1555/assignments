package com.cts.gatewaymaster.dto;

import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class GatewayMasterDto 
{

	@NotNull
	private long gatewayId;
	@NotNull
	private String gatewayType;
	@NotNull
	private String gatewayCode;
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
	public GatewayMasterDto(@NotNull long gatewayId, @NotNull String gatewayType, @NotNull String gatewayCode,
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
