package br.com.cetip.observer.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="volumefinanceirodiario",namespace="volumefinanceirodiario")
public class VolumeFinanceiroDiarioDTO {
	
	private BigDecimal value;
	private String key;
	
	public VolumeFinanceiroDiarioDTO() {
	}
	
	public VolumeFinanceiroDiarioDTO(BigDecimal value, String key) {
		super();
		this.value = value;
		this.key = key;
	}

	@JsonProperty
	public BigDecimal getValue() {
		return value;
	}

	@JsonProperty
	public String getKey() {
		return key;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
