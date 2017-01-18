package br.com.cetip.observer.services.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cetip.observer.dto.VolumeFinanceiroDiarioDTO;
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;
import br.com.cetip.observer.util.ConverterUtils;


@Path("/setting")
public class SettingService{
	
	
	private IWidgetSettingDAO dao;
	
	@Inject
	public SettingService(IWidgetSettingDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.services.impl.IVolumeFinanceiroDiarioService#getMsg(java.lang.String, int, javax.ws.rs.core.UriInfo)
	 */
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Widget widget) throws Exception{

		System.out.println(">>>>>>> SettingService > Servico para informacoes sobre volume financeiro diario!");
		System.out.println(widget);	
		dao.save(widget);
		
		System.out.println("<<< SettingService <");
	}
}