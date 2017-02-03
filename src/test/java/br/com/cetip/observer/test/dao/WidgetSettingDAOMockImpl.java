package br.com.cetip.observer.test.dao;

import java.util.List;

import com.google.inject.persist.Transactional;

import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.entity.Widget;
import br.com.cetip.observer.hibernate.entity.WidgetQuery;
import br.com.cetip.observer.hibernate.entity.WidgetType;

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
	public void delete(long id) throws Exception{
		
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IWidgetSettingDAO#update(br.com.cetip.observer.hibernate.entity.Widget)
	 */
	@Override
	@Transactional
	public void update(Widget widget) throws Exception{
	
	}

	@Override
	public List<WidgetType> getAllTypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WidgetQuery> getAllQuerys() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Widget> getAllById(Long idUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
