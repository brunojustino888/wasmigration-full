package br.com.wipro.beans;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;
import br.com.wipro.service.ApplicationItemService;
import br.com.wipro.test.SampleSessionBeanRemote;

/**
 * Responsável por realizar um teste de conexão com a base de dados no início da
 * aplicação.
 * 
 * @author Bruno Justino
 */
@Named
@RequestScoped
public class IndexBean implements Serializable {

	@EJB 
	private SampleSessionBeanRemote testEJB;
	
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Serviço responsável pelas ações da tela. 
	 */
	@EJB
	private ApplicationItemService applicationItemService;
	
	/**
	 * Representa a quantidade de aplicativos.
	 */
	private Long total;
	
	/**
	 * Representa a quantidade de aplicativos pendentes para migração.
	 */
	private Long pendentes;
	
	/**
	 * Representa a quantidade de aplicativos finalizados.
	 */
	private Long finalizados;
	
	/**
	 * Representa a quantidade de aplicativos em andamento.
	 */
	private Long andamento;
	
	/**
	 * Objeto do gráfico inserido na view.
	 */
	private PieChartModel pieModel;
	
	/**
	 * Construtor inicializando gráfico de status das aplicações na view.
	 */
	@PostConstruct
	public void init() {
		this.andamento = this.applicationItemService.countStatusAndamento();            
		this.finalizados = this.applicationItemService.countStatusFinalizado();		
		this.pendentes = this.applicationItemService.countStatusPendente();
		this.total = this.applicationItemService.countAll();
		this.pieModel = new PieChartModel(); //1988==100%  
		double percentualPeso = 1988/this.total;
		this.pieModel.set("Em andamento", percentualPeso * this.andamento);  
		this.pieModel.set("Pendentes", percentualPeso * this.pendentes);
		this.pieModel.set("Finalizados", percentualPeso * this.finalizados);
		this.pieModel.setFill(false);
		this.pieModel.setShowDataLabels(true);
		this.pieModel.setLegendPosition("w");
	}

	/**
	 * Método get do atributo total.
	 * @return total - Long - Representa a quantidade de aplicativos.
	 */
	public Long getTotal() {
		return this.total;
	}

	/**
	 * Método get do atributo andamento.
	 * @return pendentes - Long - Representa a quantidade de aplicativos pendentes na migração.
	 */
	public Long getPendentes() {
		return this.pendentes;
	}

	/**
	 * Método get do atributo andamento.
	 * @return finalizados - Long - Representa a quantidade de aplicativos finalizados na migração.
	 */
	public Long getFinalizados() {
		return this.finalizados;
	}

	/**
	 * Método get do atributo andamento.
	 * @return andamento - Long - Representa a quantidade de aplicativos em andamento na migração.
	 */
	public Long getAndamento() {
		return this.andamento;
	}
	
	/**
	 * Método get do atributo pieModel.
	 * @return pieModel - PieChartModel - gráfico inserido na tela.
	 */
	public PieChartModel getPieModel() {
		return this.pieModel;
	}

	/**
	 * Método set do atributo pieModel.
	 * @param pieModel - PieChartModel - gráfico inserido na tela.
	 */
	public void setPieModel(final PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	
}