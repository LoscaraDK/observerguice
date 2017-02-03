package br.com.cetip.observer.hibernate.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 * The persistent class for the WIDGET_QUERY database table.
 * 
 */
@Entity
@Table(name="WIDGET_QUERY",schema="CETIP")
@NamedQuery(name="WidgetQuery.findAll", query="SELECT w FROM WidgetQuery w")
@JsonRootName(value="widgetQuery",namespace="widgetQuery")
@XmlRootElement(name="widgetQuery",namespace="widgetQuery")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonClassDescription(value="widgetQuery")
@JsonIgnoreProperties(ignoreUnknown=true)
public class WidgetQuery implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	public WidgetQuery() {
		super();
	}

	public WidgetQuery(long numIdWidgetQuery) {
		super();
		this.numIdWidgetQuery = numIdWidgetQuery;
	}
	
	public WidgetQuery(Calendar datInclusao, String desQuery, String nomMethodQuery, String nomService) {
		super();
		this.datInclusao = datInclusao;
		this.desQuery = desQuery;
		this.nomMethodQuery = nomMethodQuery;
		this.nomService = nomService;
	}

	@Id
	@SequenceGenerator(name="WIDGET_QUERY_NUMIDWIDGETQUERY_GENERATOR", sequenceName="S_WIDGET_QUERY",schema="CETIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WIDGET_QUERY_NUMIDWIDGETQUERY_GENERATOR")
	@Column(name="NUM_ID_WIDGET_QUERY")
	@JsonProperty
	private long numIdWidgetQuery;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ALTERACAO")
	@JsonProperty
	private Calendar datAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_EXCLUSAO")
	@JsonProperty
	private Calendar datExclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_INCLUSAO")
	@JsonProperty
	private Calendar datInclusao;

	@Column(name="DES_QUERY")
	@JsonProperty
	private String desQuery;

	@Column(name="NOM_METHOD_QUERY")
	@JsonProperty
	private String nomMethodQuery;

	@Column(name="NOM_SERVICE")
	@JsonProperty
	private String nomService;

	//bi-directional many-to-one association to Widget
	@OneToMany(mappedBy="widgetQuery",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Widget> widgets;

	public long getNumIdWidgetQuery() {
		return this.numIdWidgetQuery;
	}

	public void setNumIdWidgetQuery(long numIdWidgetQuery) {
		this.numIdWidgetQuery = numIdWidgetQuery;
	}

	public Calendar getDatAlteracao() {
		return this.datAlteracao;
	}

	public void setDatAlteracao(Calendar datAlteracao) {
		this.datAlteracao = datAlteracao;
	}

	public Calendar getDatExclusao() {
		return this.datExclusao;
	}

	public void setDatExclusao(Calendar datExclusao) {
		this.datExclusao = datExclusao;
	}

	public Calendar getDatInclusao() {
		return this.datInclusao;
	}

	public void setDatInclusao(Calendar datInclusao) {
		this.datInclusao = datInclusao;
	}

	public String getDesQuery() {
		return this.desQuery;
	}

	public void setDesQuery(String desQuery) {
		this.desQuery = desQuery;
	}

	public String getNomMethodQuery() {
		return this.nomMethodQuery;
	}

	public void setNomMethodQuery(String nomMethodQuery) {
		this.nomMethodQuery = nomMethodQuery;
	}

	public String getNomService() {
		return this.nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public List<Widget> getWidgets() {
		return this.widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public Widget addWidget(Widget widget) {
		getWidgets().add(widget);
		widget.setWidgetQuery(this);

		return widget;
	}

	public Widget removeWidget(Widget widget) {
		getWidgets().remove(widget);
		widget.setWidgetQuery(null);

		return widget;
	}

	@Override
	public String toString() {
		return "WidgetQuery [numIdWidgetQuery=" + numIdWidgetQuery +  ", desQuery=" + desQuery + ", nomMethodQuery="
				+ nomMethodQuery + ", nomService=" + nomService + "]";
	}

}