package br.com.cetip.observer.hibernate.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the WIDGET_QUERY database table.
 * 
 */
@Entity
@Table(name="WIDGET_QUERY")
@NamedQuery(name="WidgetQuery.findAll", query="SELECT w FROM WidgetQuery w")
public class WidgetQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WIDGET_QUERY_NUMIDWIDGETQUERY_GENERATOR", sequenceName="S_WIDGET_QUERY",schema="CETIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WIDGET_QUERY_NUMIDWIDGETQUERY_GENERATOR")
	@Column(name="NUM_ID_WIDGET_QUERY")
	private long numIdWidgetQuery;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ALTERACAO")
	private Calendar datAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_EXCLUSAO")
	private Calendar datExclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_INCLUSAO")
	private Calendar datInclusao;

	@Column(name="DES_QUERY")
	private String desQuery;

	@Column(name="NOM_METHOD_QUERY")
	private String nomMethodQuery;

	@Column(name="NOM_SERVICE")
	private String nomService;

	//bi-directional many-to-one association to Widget
	@OneToMany(mappedBy="widgetQuery")
	private List<Widget> widgets;

	public WidgetQuery() {
	}

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

}