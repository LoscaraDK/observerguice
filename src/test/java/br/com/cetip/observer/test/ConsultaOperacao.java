package br.com.cetip.observer.test;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.cetip.observer.dto.VolumeFinanceiroDiarioDTO;


public class ConsultaOperacao extends JunitGeneric{
	
//	@Test
	public void testaVolFinanceiroDiarioComStatus(){
		System.out.println("Entrou aqui");
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.DECEMBER, 23);
		List<VolumeFinanceiroDiarioDTO> list = null;
		try {
			list = dao.getVolFinanceiroDiarioComStatus(43,c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("total> "+list.size());
		System.out.println(list);
	}
	
	
	@Test
	public void testGetDataHOje(){
		Calendar c = null;
		try {
			c = generic.getDataHoje();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c);
	}
}
