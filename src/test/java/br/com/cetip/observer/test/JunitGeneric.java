package br.com.cetip.observer.test;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;

import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.test.conf.JPAInitializer;
import br.com.cetip.observer.test.conf.TestModule;

public class JunitGeneric {
	@Inject
	IOperacaoDAO dao;
	
	@Inject
	EntityManager entityManager;
	
	@Inject
	private JPAInitializer jpaInitializer;
		
	@Before
    public void setUp() throws Exception{
        Guice.createInjector(new TestModule()).injectMembers(this);
        entityManager.getTransaction().begin();
    }
	
    @After
    public void tearDown()  throws Exception{
    	jpaInitializer.stop();
    }
}
