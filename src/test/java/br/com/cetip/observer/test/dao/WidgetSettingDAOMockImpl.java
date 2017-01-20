package br.com.cetip.observer.test.dao;

import com.google.inject.persist.Transactional;

import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;

public class WidgetSettingDAOMockImpl implements IWidgetSettingDAO {
	
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#getById(java.lang.Long)
	 */
	@Override
	public Widget getById(final Long id) {
        return null;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#save(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void save(Widget widget) throws Exception{
		System.out.println("vou salvar o widget! > " + widget.getTitle());
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#delete(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void delete(Widget widget) throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#update(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void update(Widget widget) throws Exception{
	
	}
	
	
}
