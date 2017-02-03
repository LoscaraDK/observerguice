package br.com.cetip.observer.hibernate.dao;

import java.util.List;

import br.com.cetip.observer.hibernate.entity.Widget;
import br.com.cetip.observer.hibernate.entity.WidgetQuery;
import br.com.cetip.observer.hibernate.entity.WidgetType;

public interface IWidgetSettingDAO {
	public static final String WIDGET_FIND_ALL = "Widget.findAll";
	public static final String WIDGET_FIND_BY_USER = "Widget.findByUserId";
	public static final String WIDGET_DELETE_BY_ID = "Widget.deleteById";
	
	
	Widget getById(Long id);

	void save(Widget widget) throws Exception;

	void delete(long id) throws Exception;

	void update(Widget widget) throws Exception;
	
	List<WidgetType> getAllTypes() throws Exception;
	
	List<WidgetQuery> getAllQuerys() throws Exception;
	
	List<Widget> getAllById(Long idUser) throws Exception;

}