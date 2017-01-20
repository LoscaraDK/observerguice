package br.com.cetip.observer.services.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cetip.observer.dto.VolumeFinanceiroDiarioDTO;
import br.com.cetip.observer.hibernate.dao.IGenericDAO;
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.util.ConverterUtils;


@Path("/volumefinanceirodiario")
public class VolumeFinanceiroDiarioService{
	
	
	private IOperacaoDAO dao;
	
	private IGenericDAO generic;
	
	@Inject
	public VolumeFinanceiroDiarioService(IOperacaoDAO dao,IGenericDAO generic) {
		this.dao = dao;
		this.generic = generic;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.services.impl.IVolumeFinanceiroDiarioService#getMsg(java.lang.String, int, javax.ws.rs.core.UriInfo)
	 */
	@GET
	@Path("/{codigosituacao}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<VolumeFinanceiroDiarioDTO> getVolumePorStatus(@PathParam("codigosituacao") int codigoSituacaoOperacao) throws Exception{

		System.out.println(">>>>>>> VolumeFinanceiroDiarioService > Servico para informacoes sobre volume financeiro diario!");
		
		Calendar dataHoje = generic.getDataHoje();
			
		List<VolumeFinanceiroDiarioDTO> lista = dao.getVolFinanceiroDiarioComStatus(codigoSituacaoOperacao, dataHoje);
		
		System.out.println("<<< VolumeFinanceiroDiarioService <");
		return lista;
	}
}