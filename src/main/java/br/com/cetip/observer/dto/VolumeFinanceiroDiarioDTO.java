package br.com.cetip.observer.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="volumefinanceirodiario",namespace="volumefinanceirodiario")
public class VolumeFinanceiroDiarioDTO {
	
	private Long totalOperacoes;
	private BigDecimal volFinanceiro;
	private String desSituacaoOperacao;
	private String codTipoIF;
	
	public VolumeFinanceiroDiarioDTO() {
	}
	
	public VolumeFinanceiroDiarioDTO(Long totalOperacoes, BigDecimal volFinanceiro, String desSituacaoOperacao,
			String codTipoIF) {
		super();
		this.totalOperacoes = totalOperacoes;
		this.volFinanceiro = volFinanceiro;
		this.desSituacaoOperacao = desSituacaoOperacao;
		this.codTipoIF = codTipoIF;
	}


	@JsonProperty
	public Long getTotalOperacoes() {
		return totalOperacoes;
	}


	@JsonProperty
	public BigDecimal getVolFinanceiro() {
		return volFinanceiro;
	}


	@JsonProperty
	public String getDesSituacaoOperacao() {
		return desSituacaoOperacao;
	}


	@JsonProperty
	public String getCodTipoIF() {
		return codTipoIF;
	}
	
	public void setTotalOperacoes(Long totalOperacoes) {
		this.totalOperacoes = totalOperacoes;
	}


	public void setVolFinanceiro(BigDecimal volFinanceiro) {
		this.volFinanceiro = volFinanceiro;
	}


	public void setDesSituacaoOperacao(String desSituacaoOperacao) {
		this.desSituacaoOperacao = desSituacaoOperacao;
	}


	public void setCodTipoIF(String codTipoIF) {
		this.codTipoIF = codTipoIF;
	}
	
}
