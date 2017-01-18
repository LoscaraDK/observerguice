package br.com.cetip.observer.test;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.google.inject.Guice;

import br.com.cetip.observer.dto.VolumeFinanceiroDiarioDTO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Chart;
import br.com.cetip.observer.hibernate.entity.Widget;
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
		Widget widget = new Widget(1,1,1,1,"teste","teste",c,111L,new Chart("options","data","api",c));
		Entity<Widget> widgetJson = Entity.entity(widget, MediaType.APPLICATION_JSON_TYPE);
		target("/setting/save").request().post(widgetJson);
		
	}
}
