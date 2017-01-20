package br.com.cetip.observer.hibernate.dao.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cetip.observer.hibernate.dao.IGenericDAO;

public class GenericDAOImpl implements IGenericDAO{
	
	@Inject
	EntityManager entityManager;

	@Override
	public Calendar getDataHoje() throws Exception {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("select cetip.get_datahoje() from dual");
		
		Timestamp t = (Timestamp) query.getSingleResult(); 
		
		Calendar dataHoje =   Calendar.getInstance();
		dataHoje.setTimeInMillis(t.getTime());
		
		return dataHoje;
	}
	
}
