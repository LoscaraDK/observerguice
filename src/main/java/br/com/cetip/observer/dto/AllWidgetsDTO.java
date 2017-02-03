package br.com.cetip.observer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cetip.observer.hibernate.entity.Widget;
public class AllWidgetsDTO {
	@JsonProperty
	private List<Widget> widgets;

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
	
	
}
