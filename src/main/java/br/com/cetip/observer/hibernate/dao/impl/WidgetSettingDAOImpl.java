package br.com.cetip.observer.hibernate.dao.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.inject.persist.Transactional;

import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;

public class WidgetSettingDAOImpl implements IWidgetSettingDAO {
	@Inject
	protected EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#getById(java.lang.Long)
	 */
	@Override
	public Widget getById(final Long id) {
        return entityManager.find(Widget.class, id);
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#save(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void save(Widget widget) throws Exception{
		entityManager.getTransaction().begin(); 
		entityManager.persist(widget);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#delete(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void delete(Widget widget) throws Exception{
		entityManager.getTransaction().begin(); 
		entityManager.remove(widget);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#update(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void update(Widget widget) throws Exception{
		entityManager.getTransaction().begin(); 
		entityManager.merge(widget);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	
}
