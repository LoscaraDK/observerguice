package br.com.cetip.observer.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cetip.observer.dto.AllWidgetsDTO;
import br.com.cetip.observer.hibernate.dao.IDashboardDAO;
import br.com.cetip.observer.hibernate.entity.Widget;


@Path("/widgets")
public class DashboardService{
	
	
	private IDashboardDAO dao;
	
	@Inject
	public DashboardService(IDashboardDAO dao) {
		this.dao = dao;
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AllWidgetsDTO getWidgets() throws Exception{

		System.out.println(">>>>>>> getWidgets > DashboardService!");
		AllWidgetsDTO dto = new AllWidgetsDTO();
		dto.setWidgets(dao.findAllByUser(0));
		
		System.out.println("Querys" + dto.getWidgets().get(0).getWidgetQuery());
		System.out.println("Types" + dto.getWidgets().get(0).getWidgetType());
		
		System.out.println("<<< DashboardService >  getWidgets <");
		return dto;
	}
}