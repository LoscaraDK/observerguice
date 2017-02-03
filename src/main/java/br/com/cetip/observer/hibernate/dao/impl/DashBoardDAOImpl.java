package br.com.cetip.observer.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cetip.observer.hibernate.dao.IDashboardDAO;
import br.com.cetip.observer.hibernate.entity.Widget;

public class DashBoardDAOImpl implements IDashboardDAO {
	
	@Inject
	EntityManager entityManager;
	
	@Override
	public List<Widget> findAllByUser(long numIdUsuario) throws Exception {
		List<Widget> widgets = new ArrayList<Widget>();
		
		Query query = entityManager.createNamedQuery(WIDGET_FIND_ALL_BY_USER);
		query.setParameter("numIdUsuario", numIdUsuario);
		widgets = query.getResultList();
		
		return widgets;
	}

}
