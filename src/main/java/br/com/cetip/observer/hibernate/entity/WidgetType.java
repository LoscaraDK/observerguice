package br.com.cetip.observer.hibernate.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the WIDGET_TYPE database table.
 * 
 */
@Entity
@Table(name="WIDGET_TYPE")
@NamedQuery(name="WidgetType.findAll", query="SELECT w FROM WidgetType w")
public class WidgetType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WIDGET_TYPE_NUMIDWIDGETTYPE_GENERATOR", sequenceName="S_WIDGET_TYPE",schema="CETIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WIDGET_TYPE_NUMIDWIDGETTYPE_GENERATOR")
	@Column(name="NUM_ID_WIDGET_TYPE")
	private long numIdWidgetType;

	@Column(name="NOM_WIDGET_TYPE")
	private String nomWidgetType;

	//bi-directional many-to-one association to Widget
	@OneToMany(mappedBy="widgetType")
	private List<Widget> widgets;

	public WidgetType() {
	}

	public long getNumIdWidgetType() {
		return this.numIdWidgetType;
	}

	public void setNumIdWidgetType(long numIdWidgetType) {
		this.numIdWidgetType = numIdWidgetType;
	}

	public String getNomWidgetType() {
		return this.nomWidgetType;
	}

	public void setNomWidgetType(String nomWidgetType) {
		this.nomWidgetType = nomWidgetType;
	}

	public List<Widget> getWidgets() {
		return this.widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public Widget addWidget(Widget widget) {
		getWidgets().add(widget);
		widget.setWidgetType(this);

		return widget;
	}

	public Widget removeWidget(Widget widget) {
		getWidgets().remove(widget);
		widget.setWidgetType(null);

		return widget;
	}

}