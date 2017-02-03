package br.com.cetip.observer.test.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import br.com.cetip.observer.dto.VolumeFinanceiroDiarioDTO;
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.hibernate.entity.Operacao;


public class OperacaoDAOMockImpl implements IOperacaoDAO {
	

	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IOperacaoDAO#getById(java.lang.Long)
	 */
	@Override
	public Operacao getById(final Long numIdOperacao) throws Exception{
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IOperacaoDAO#getByDate(java.util.Calendar)
	 */
	@Override
	public List<Operacao> getByDate(Calendar datOperacao) throws Exception{
		return null;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IOperacaoDAO#getByDatePaginated(java.util.Calendar, int)
	 */
	@Override
	public List<Operacao> getByDatePaginated(Calendar datOperacao,int page) throws Exception {
		
		return null;
	}
											   
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IOperacaoDAO#getVolFinanceiroDiarioComStatus(java.lang.Integer, java.util.Calendar)
	 */
	@Override
	public List<VolumeFinanceiroDiarioDTO> getVolFinanceiroDiarioComStatus(Integer codSituacaoOperacao, Calendar datOperacao) throws Exception{
		System.out.println("entrou aqui no metodo getVolFinanceiroDiarioComStatus - classe Mock de teste");
		List<VolumeFinanceiroDiarioDTO> resultado = new ArrayList<>();
		
		resultado.add(new VolumeFinanceiroDiarioDTO(new BigDecimal(3.5),"CDB"));
		resultado.add(new VolumeFinanceiroDiarioDTO(new BigDecimal(4.5),"CDBS"));
		resultado.add(new VolumeFinanceiroDiarioDTO(new BigDecimal(5.5),"CDBV"));
		resultado.add(new VolumeFinanceiroDiarioDTO(new BigDecimal(6.5),"DI"));
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see br.com.cetip.observer.hibernate.dao.impl.IOperacaoDAO#getTotalByDate(java.lang.Class, java.util.Calendar)
	 */
	@Override
	public int getTotalByDate(Class clazz, Calendar datOperacao) throws Exception{
		return 0;
	}
}
