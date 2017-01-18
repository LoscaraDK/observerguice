package br.com.cetip.observer.test.conf;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.services.impl.VolumeFinanceiroDiarioService;
import br.com.cetip.observer.test.dao.OperacaoDAOMockImpl;
import br.com.cetip.observer.test.dao.WidgetSettingDAOMockImpl;

public class TestModule extends AbstractModule {
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
//		install(new JpaPersistModule("prototipo"));
		
//		bind(JPAInitializer.class).asEagerSingleton();
		bind(IOperacaoDAO.class).to(OperacaoDAOMockImpl.class);
		bind(IWidgetSettingDAO.class).to(WidgetSettingDAOMockImpl.class);
		bind(VolumeFinanceiroDiarioService.class);
		
	}

}
