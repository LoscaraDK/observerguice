package br.com.cetip.observer.hibernate.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;


/**
 * The persistent class for the WIDGET database table.
 * 
 */
@Entity
@NamedQuery(name="Widget.findAll", query="SELECT w FROM Widget w")
public class Widget implements Serializable {
	private static final long serialVersionUID = 1L;

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
	@SequenceGenerator(name="WIDGET_NUMIDWIDGET_GENERATOR", sequenceName="S_WIDGET",schema="CETIP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WIDGET_NUMIDWIDGET_GENERATOR")
	@Column(name="NUM_ID_WIDGET")
	private long numIdWidget;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_ALTERACAO")
	private Calendar datAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_EXCLUSAO")
	private Calendar datExclusao;

	@Temporal(TemporalType.DATE)
	@Column(name="DAT_INCLUSAO")
	private Calendar datInclusao;

	@Column(name="NUM_ID_ENTIDADE_ATUALIZ")
	private long numIdEntidadeAtualiz;

	@Column(name="NUM_ID_USUARIO")
	private long numIdUsuario;

	private String title;

	@Column(name="WIDGET_COL")
	private long widgetCol;

	@Column(name="WIDGET_ROW")
	private long widgetRow;

	@Column(name="WIDGET_SIZEX")
	private long widgetSizex;

	@Column(name="WIDGET_SIZEY")
	private long widgetSizey;

	//bi-directional many-to-one association to WidgetQuery
	@ManyToOne
	@JoinColumn(name="NUM_ID_WIDGET_QUERY",nullable=true)
	private WidgetQuery widgetQuery;

	//bi-directional many-to-one association to WidgetType
	@ManyToOne
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

}