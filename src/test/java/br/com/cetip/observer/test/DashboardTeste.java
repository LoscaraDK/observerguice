package br.com.cetip.observer.test;

import javax.inject.Inject;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import com.google.inject.Guice;

import br.com.cetip.observer.hibernate.dao.IDashboardDAO;
import br.com.cetip.observer.services.DashboardService;
import br.com.cetip.observer.test.conf.TestModule;

public class DashboardTeste extends JerseyTestNg.ContainerPerClassTest {
	@Inject
	IDashboardDAO dao;
	
	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		// TODO Auto-generated method stub
		Guice.createInjector(new TestModule()).injectMembers(this);
		return new ResourceConfig().register(new DashboardService(dao));
	}
	
	@Test
	public void getWidgets() throws Exception{
		System.out.println("Widgets: " + dao.findAllByUser(0));
	}
}
