/*
 * Copyright (c) 2016 Aberger Software GmbH. All Rights Reserved.
 *               http://www.aberger.at
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package br.com.cetip.observer.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;

import br.com.cetip.observer.config.RestServletModule;
import br.com.cetip.observer.hibernate.dao.IDashboardDAO;
import br.com.cetip.observer.hibernate.dao.IGenericDAO;
import br.com.cetip.observer.hibernate.dao.IOperacaoDAO;
import br.com.cetip.observer.hibernate.dao.IWidgetSettingDAO;
import br.com.cetip.observer.hibernate.dao.impl.DashBoardDAOImpl;
import br.com.cetip.observer.hibernate.dao.impl.GenericDAOImpl;
import br.com.cetip.observer.hibernate.dao.impl.OperacaoDAOImpl;
import br.com.cetip.observer.hibernate.dao.impl.WidgetSettingDAOImpl;

public class ObserverServletContextListener extends GuiceServletContextListener {
	@Override
	protected Injector getInjector() {
	    return Guice.createInjector(new RestServletModule() {
			@Override
			protected void configureServlets() {
				rest("/rest/*").packages("br.com.cetip.observer.services");
				
				install(new JpaPersistModule("prototipo"));
				filter("/*").through(PersistFilter.class);
				
				bind(IOperacaoDAO.class).to(OperacaoDAOImpl.class);
				bind(IWidgetSettingDAO.class).to(WidgetSettingDAOImpl.class);
				bind(IGenericDAO.class).to(GenericDAOImpl.class);
				bind(IDashboardDAO.class).to(DashBoardDAOImpl.class);
			}
	    });
	}
}