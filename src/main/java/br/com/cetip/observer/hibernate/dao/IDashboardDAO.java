package br.com.cetip.observer.hibernate.dao;

import java.util.List;

import br.com.cetip.observer.hibernate.entity.Widget;

public interface IDashboardDAO {
	public static final String WIDGET_FIND_ALL_BY_USER = "Widget.findAllByUser";
	
	public List<Widget> findAllByUser(long numIdUsuario) throws Exception;
}
