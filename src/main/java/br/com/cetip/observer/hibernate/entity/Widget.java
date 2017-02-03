package br.com.cetip.observer.hibernate.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 * The persistent class for the WIDGET database table.
 * 
 */
@Entity
@Table(name="WIDGET",schema="CETIP")
@NamedQueries
({
@NamedQuery(name="Widget.findAll", query="SELECT w FROM Widget w"),
@NamedQuery(name="Widget.findByUserId", query="SELECT w FROM Widget w JOIN FETCH w.widgetQuery JOIN FETCH w.widgetType WHERE w.numIdUsuario = :numIdUsuario"),
@NamedQuery(name="Widget.deleteById", query="DELETE FROM Widget w WHERE w.numIdWidget = :numIdWidget"),
@NamedQuery(name="Widget.findAllByUser", query="SELECT w FROM Widget w WHERE w.numIdUsuario = :numIdUsuario")

})

@JsonRootName(value="widget",namespace="widget")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Widget implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Widget(long numIdWidget) {
		super();
		this.numIdWidget = numIdWidget;
	}
	
	public Widget(Calendar datInclusao, long numIdUsuario, String title, long widgetCol, long widgetRow,
			long widgetSizex, long widgetSizey, WidgetQuery widgetQuery, WidgetType widgetType) {
		super();
		this.datInclusao = datInclusao;
		this.numIdUsuario = numIdUsuario;
		this.title = title;
		this.widgetCol = widgetCol;
		this.widgetRow = widgetRow;
		this.widgetSizex = widgetSizex;
		this.widgetSizey = widgetSizey;
		this.widgetQuery = widgetQuery;
		this.widgetType = widgetType;
	}

	@Id
	@SequenceGenerator(name="WIDGET_NUMIDWIDGET_GENERATOR", sequenceName="S_WIDGET",schema="CETIP",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WIDGET_NUMIDWIDGET_GENERATOR")
	@Column(name="NUM_ID_WIDGET")
	@JsonProperty
	private long numIdWidget;

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

	@Column(name="NUM_ID_ENTIDADE_ATUALIZ")
	@JsonProperty
	private long numIdEntidadeAtualiz;

	@Column(name="NUM_ID_USUARIO")
	@JsonProperty
	private long numIdUsuario;
	
	@JsonProperty
	@Column(name="TITLE")
	private String title;

	@Column(name="WIDGET_COL")
	@JsonProperty(value="col")
	private long widgetCol;

	@Column(name="WIDGET_ROW")
	@JsonProperty(value="row")
	private long widgetRow;

	@Column(name="WIDGET_SIZEX")
	@JsonProperty(value="sizeX")
	private long widgetSizex;
	
	@Column(name="WIDGET_SIZEY")
	@JsonProperty(value="sizeY")
	private long widgetSizey;

	//bi-directional many-to-one association to WidgetQuery
//	@JsonBackReference(value="widgetQuery")
	@JsonProperty
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="NUM_ID_WIDGET_QUERY",nullable=true)
	private WidgetQuery widgetQuery;

	//bi-directional many-to-one association to WidgetType
//	@JsonBackReference(value="widgetType")
	@JsonProperty
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="NUM_ID_WIDGET_TYPE",nullable=true)
	private WidgetType widgetType;

	public Widget() {
	}

	public long getNumIdWidget() {
		return this.numIdWidget;
	}

	public void setNumIdWidget(long numIdWidget) {
		this.numIdWidget = numIdWidget;
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

	public long getNumIdEntidadeAtualiz() {
		return this.numIdEntidadeAtualiz;
	}

	public void setNumIdEntidadeAtualiz(long numIdEntidadeAtualiz) {
		this.numIdEntidadeAtualiz = numIdEntidadeAtualiz;
	}

	public long getNumIdUsuario() {
		return this.numIdUsuario;
	}

	public void setNumIdUsuario(long numIdUsuario) {
		this.numIdUsuario = numIdUsuario;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getWidgetCol() {
		return this.widgetCol;
	}

	public void setWidgetCol(long widgetCol) {
		this.widgetCol = widgetCol;
	}

	public long getWidgetRow() {
		return this.widgetRow;
	}

	public void setWidgetRow(long widgetRow) {
		this.widgetRow = widgetRow;
	}

	public long getWidgetSizex() {
		return this.widgetSizex;
	}

	public void setWidgetSizex(long widgetSizex) {
		this.widgetSizex = widgetSizex;
	}

	public long getWidgetSizey() {
		return this.widgetSizey;
	}

	public void setWidgetSizey(long widgetSizey) {
		this.widgetSizey = widgetSizey;
	}

	public WidgetQuery getWidgetQuery() {
		return this.widgetQuery;
	}

	public void setWidgetQuery(WidgetQuery widgetQuery) {
		this.widgetQuery = widgetQuery;
	}

	public WidgetType getWidgetType() {
		return this.widgetType;
	}

	public void setWidgetType(WidgetType widgetType) {
		this.widgetType = widgetType;
	}

	@Override
	public String toString() {
		return "Widget [numIdWidget=" + numIdWidget +  ", numIdUsuario="	+ numIdUsuario + "]";
	}

}