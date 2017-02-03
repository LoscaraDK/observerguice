package br.com.cetip.observer.hibernate.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.persist.Transactional;

import br.com.cetip.observer.hibernate.dao.IGenericDAO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;
import br.com.cetip.observer.hibernate.entity.WidgetQuery;
import br.com.cetip.observer.hibernate.entity.WidgetType;

public class WidgetSettingDAOImpl implements IWidgetSettingDAO {
	@Inject
	protected EntityManager entityManager;
	
	@Inject
	protected IGenericDAO generic;
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
		System.out.println("WidgetSettingDAOImpl > save > Data de hoje > " + generic.getDataHoje());
		widget.setDatInclusao(generic.getDataHoje());
		entityManager.persist(widget);
		System.out.println("Id do objeto persistido -> "+widget.getNumIdWidget());
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#delete(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void delete(long id) throws Exception{
		Query query = entityManager.createNamedQuery(WIDGET_DELETE_BY_ID);
		query.setParameter("numIdWidget", id);
		query.executeUpdate();
		System.out.println("Widget removido > "+ id);
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#update(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void update(Widget widget) throws Exception{
		widget.setDatInclusao(generic.getDataHoje());
		entityManager.merge(widget);
	}

	@Override
	public List<WidgetType> getAllTypes() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("WidgetType.findAll").getResultList();
	}

	@Override
	public List<WidgetQuery> getAllQuerys() throws Exception {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("WidgetQuery.findAll").getResultList();
	}
	
	@Override
	public List<Widget> getAllById(Long idUser) throws Exception {
		Query query = entityManager.createNamedQuery(WIDGET_FIND_BY_USER);	
		query.setParameter("numIdUsuario", idUser);
		List<Widget> retorno = query.getResultList();
		
		return retorno;
	}
	
	
}
