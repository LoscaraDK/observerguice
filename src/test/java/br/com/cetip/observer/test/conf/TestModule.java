package br.com.cetip.observer.test.conf;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

import br.com.cetip.observer.hibernate.dao.IDashboardDAO;
import br.com.cetip.observer.hibernate.dao.IGenericDAO;
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.dao.impl.DashBoardDAOImpl;
import br.com.cetip.observer.hibernate.dao.impl.GenericDAOImpl;
import br.com.cetip.observer.services.DashboardService;
import br.com.cetip.observer.services.VolumeFinanceiroDiarioService;
import br.com.cetip.observer.services.WidgetSettingService;
import br.com.cetip.observer.test.dao.OperacaoDAOMockImpl;
import br.com.cetip.observer.test.dao.WidgetSettingDAOMockImpl;

public class TestModule extends AbstractModule {
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		install(new JpaPersistModule("prototipo"));
		
		bind(JPAInitializer.class).asEagerSingleton();
		bind(IGenericDAO.class).to(GenericDAOImpl.class);
		bind(IOperacaoDAO.class).to(OperacaoDAOMockImpl.class);
		bind(IWidgetSettingDAO.class).to(WidgetSettingDAOMockImpl.class);
		bind(IDashboardDAO.class).to(DashBoardDAOImpl.class);
		bind(VolumeFinanceiroDiarioService.class);
		bind(WidgetSettingService.class);
		bind(DashboardService.class);
		
	}

}
