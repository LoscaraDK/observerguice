package br.com.cetip.observer.hibernate.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the WIDGET_TYPE database table.
 * 
 */
@Entity
@Table(name="WIDGET_TYPE",schema="CETIP")
@NamedQueries
({
@NamedQuery(name="WidgetType.findAll", query="SELECT w FROM WidgetType w"),
})
@JsonRootName(value="widgetType",namespace="widgetType")
@XmlRootElement(name="widgetType",namespace="widgetType")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription(value="widgetType")
@JsonIgnoreProperties(ignoreUnknown=true)
public class WidgetType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public WidgetType() {
	}
		
	public WidgetType(long numIdWidgetType) {
		super();
		this.numIdWidgetType = numIdWidgetType;
	}

	public WidgetType(String nomWidgetType, List<Widget> widgets, String options) {
		super();
		this.nomWidgetType = nomWidgetType;
		this.widgets = widgets;
		this.options = options;
	}



	@Id
	@SequenceGenerator(name="WIDGET_TYPE_NUMIDWIDGETTYPE_GENERATOR", sequenceName="S_WIDGET_TYPE",schema="CETIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WIDGET_TYPE_NUMIDWIDGETTYPE_GENERATOR")
	@Column(name="NUM_ID_WIDGET_TYPE")
	@JsonProperty
	private long numIdWidgetType;

	@Column(name="NOM_WIDGET_TYPE")
	@JsonProperty
	private String nomWidgetType;

	//bi-directional many-to-one association to Widget
	@OneToMany(mappedBy="widgetType",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Widget> widgets;
	
	@Lob
	@Column(name="OPTIONS")
	@JsonProperty
	private String options;

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

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "WidgetType [numIdWidgetType=" + numIdWidgetType + ", nomWidgetType=" + nomWidgetType + "]";
	}

}