package br.com.cetip.observer.test;

import java.util.Calendar;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.google.inject.Guice;

import br.com.cetip.observer.hibernate.dao.IGenericDAO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;
import br.com.cetip.observer.hibernate.entity.WidgetQuery;
import br.com.cetip.observer.hibernate.entity.WidgetType;
import br.com.cetip.observer.services.impl.SettingService;
import br.com.cetip.observer.test.conf.TestModule;

public class WidgetSettingTeste extends JerseyTestNg.ContainerPerClassTest {
	@Inject
	IWidgetSettingDAO dao;
	
	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		// TODO Auto-generated method stub
		Guice.createInjector(new TestModule()).injectMembers(this);
		return new ResourceConfig().register(new SettingService(dao));
	}
	
	@Test
	public void save(){
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.DECEMBER, 23);
		WidgetQuery widgetQuery = new WidgetQuery();
		WidgetType widgetType = new WidgetType();
		Widget widget = new Widget(c, 1, "teste", 1, 1, 2, 2, null, null);
		Entity<Widget> widgetJson = Entity.entity(widget, MediaType.APPLICATION_JSON_TYPE);
		target("/setting/save").request().post(widgetJson);
		
	}
}
