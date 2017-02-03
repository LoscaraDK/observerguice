package br.com.cetip.observer.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;
import br.com.cetip.observer.hibernate.entity.WidgetQuery;
import br.com.cetip.observer.hibernate.entity.WidgetType;


@Path("/setting")
public class WidgetSettingService{
	
	
	private IWidgetSettingDAO dao;
	
	@Inject
	public WidgetSettingService(IWidgetSettingDAO dao) {
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.services.impl.IVolumeFinanceiroDiarioService#getMsg(java.lang.String, int, javax.ws.rs.core.UriInfo)
	 */
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Widget save(Widget widget) throws Exception{

		System.out.println(">>>>>>> save > SettingService!");
		System.out.println("Widget >> "+widget);	
		dao.save(widget);
		System.out.println("Widget apos inclusao << "+widget);
		System.out.println("<<< SettingService <");
		
		return widget;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.services.impl.IVolumeFinanceiroDiarioService#getMsg(java.lang.String, int, javax.ws.rs.core.UriInfo)
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(@PathParam(value="id")  long id) throws Exception{

		System.out.println(">>>>>>> delete > SettingService!");
		System.out.println(">>>>>>> delete > SettingService! valor do parametro > "+id);
		dao.delete(id);
		System.out.println("<<< SettingService <");
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Widget update(Widget widget) throws Exception{

		System.out.println(">>>>>>> save > SettingService!");
		System.out.println("Widget antes de atualizar >> "+widget);
		dao.update(widget);
		System.out.println("Widget após atualizar >> "+widget);
		System.out.println("<<< SettingService <");
		
		return widget;
	}
	
	@GET
	@Path("/types")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<WidgetType> getTypes() throws Exception{

		System.out.println(">>>>>>> getTypes > SettingService!");
		List<WidgetType> retorno = dao.getAllTypes();
		System.out.println("<<< getTypes <");
		
		return retorno;
	}
	
	@GET
	@Path("/querys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<WidgetQuery> getQuerys() throws Exception{

		System.out.println(">>>>>>> getQuerys > SettingService!");
		List<WidgetQuery> retorno = dao.getAllQuerys();
		System.out.println("<<< getQuerys <");
		
		return retorno;
	}
}