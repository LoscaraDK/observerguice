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
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.util.ConverterUtils;


@Path("/volumefinanceirodiario")
public class VolumeFinanceiroDiarioService{
	
	
	private IOperacaoDAO dao;
	
	@Inject
	public VolumeFinanceiroDiarioService(IOperacaoDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.services.impl.IVolumeFinanceiroDiarioService#getMsg(java.lang.String, int, javax.ws.rs.core.UriInfo)
	 */
	@GET
	@Path("/{data}/{codigosituacao}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public List<VolumeFinanceiroDiarioDTO> getMsg(@PathParam("data") String data,@PathParam("codigosituacao") int codigoSituacaoOperacao) throws Exception{

		System.out.println(">>>>>>> VolumeFinanceiroDiarioService > Servico para informacoes sobre volume financeiro diario!");
		
		Calendar dataHoje = ConverterUtils.transformStringToCalendar(data, ConverterUtils.YYYYMMDD);
			
		List<VolumeFinanceiroDiarioDTO> lista = dao.getVolFinanceiroDiarioComStatus(codigoSituacaoOperacao, dataHoje);
		
		System.out.println("<<< VolumeFinanceiroDiarioService <");
		return lista;
	}
}