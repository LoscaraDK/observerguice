package br.com.cetip.observer.test.conf;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class JPAInitializer {
	private PersistService persistService;
	
	@Inject
	public JPAInitializer(PersistService service) {
		persistService = service;
		persistService.start();
	}
	
	public void stop(){
		persistService.stop();
	}
}
