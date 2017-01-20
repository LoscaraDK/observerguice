package br.com.cetip.observer.test;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;

import br.com.cetip.observer.dto.VolumeFinanceiroDiarioDTO;
import br.com.cetip.observer.hibernate.dao.IGenericDAO;
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.services.impl.VolumeFinanceiroDiarioService;
import br.com.cetip.observer.test.conf.TestModule;

public class VolumeFinanceiroDiarioTeste extends JerseyTestNg.ContainerPerClassTest {
	@Inject
	IOperacaoDAO dao;
	
	@Inject
	IGenericDAO generic;
	
	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		// TODO Auto-generated method stub
		Guice.createInjector(new TestModule()).injectMembers(this);
		return new ResourceConfig().register(new VolumeFinanceiroDiarioService(dao,generic));
	}
	
	@Test
	public void testGetAll(){
		List<VolumeFinanceiroDiarioDTO> list = target("/volumefinanceirodiario/2016-12-29/43").request().get(new GenericType<List<VolumeFinanceiroDiarioDTO>>(){});
		for (VolumeFinanceiroDiarioDTO volumeFinanceiroDiarioDTO : list) {
			Assert.assertNotNull(volumeFinanceiroDiarioDTO.getCodTipoIF());
			Assert.assertNotNull(volumeFinanceiroDiarioDTO.getVolFinanceiro());
		}
	}
	
	@Test
	public void testErrorGetAll(){
		Response response = target("/volumefinanceirodiario/2016-12-29").request().get();
		Assert.assertEquals(response.getStatus(), 404);
		
	}
}
