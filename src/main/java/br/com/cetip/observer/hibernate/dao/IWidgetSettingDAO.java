package br.com.cetip.observer.hibernate.dao;

import br.com.cetip.observer.hibernate.entity.Widget;

public interface IWidgetSettingDAO {

	Widget getById(Long id);

	void save(Widget widget) throws Exception;

	void delete(Widget widget) throws Exception;

	void update(Widget widget) throws Exception;

}