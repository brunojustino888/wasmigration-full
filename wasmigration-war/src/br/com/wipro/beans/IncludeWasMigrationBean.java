package br.com.wipro.beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.wipro.dto.ApplicationItemDTO;
import br.com.wipro.enums.ApplicationItemEnum;
import br.com.wipro.service.ApplicationItemService;

/**
 * Back-end da tela include-wasmigration.xhtml
 * @author Bruno Justino
 */
@Named
@ViewScoped
public class IncludeWasMigrationBean implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Servi�o respons�vel pelas a��es da tela. 
	 */
	@EJB
	private ApplicationItemService applicationItemService;
	
	/**
	 * DTO do objeto selecionado na tabela da tela home-wasmigration.xhtml.
	 */
	private ApplicationItemDTO applicationItemDTO;
	
	/**
	 * Representa a data de t�rmino prevista coletada em tela
	 */
	private Date dataPrevistaTermino;
	
	/**
	 * Representa a data de t�rmino coletada em tela
	 */
	private Date dataTermino;
	
	/**
	 * Representa o status selecionado pelo usu�rio na tela
	 */
	private String statusSelected;
	
	/**
	 * Representa o centro de custo coletado em tela
	 */
	private String cccc;
	
	/**
	 * Representa se o ramo est� criado para o aplicativo (coletado em tela).
	 */
	private boolean ramoCriado;
	
	/**
	 * Representa se o starteam concede acesso (coletado em tela).
	 */
	private boolean acessoRamo;
	
	/**
	 * Representa se o o aplicativo foi disponibilizado para migra��o (coletado em tela).
	 */
	private boolean disponibilizado;
	
	/**
	 * Representa a observa��o do ramo.
	 */
	private String obsRamo;
	
	/**
	 * Representa a observa��o coletada em tela.
	 */
	private String obs;

	/**
	 * Usado para modificar o form na tela.
	 */
	private boolean calendarTermino = false;

	/**
	 * Utilizado para modificar o form na tela.
	 */
	private boolean calendarPrevisao = true;
	
	/**
	 * M�todo utilizado para finalizar a inclus�o de um novo registro.
	 */
	public void include() { 
		this.applicationItemDTO = new ApplicationItemDTO();
		this.applicationItemDTO.setAcessoStarteam(acessoRamo==true? "Sim": "N�o");
		this.applicationItemDTO.setRamoCriado(ramoCriado==true? "Sim": "N�o");
		this.applicationItemDTO.setDisponibilizado(disponibilizado==true? "Sim": "N�o");
		this.applicationItemDTO.setCentroCusto(cccc);
		this.applicationItemDTO.setDataPrevistaTermino(dataPrevistaTermino);
		this.applicationItemDTO.setDataTermino(dataTermino);
		if(obs == null || "".equals(obs)) {
			this.applicationItemDTO.setObservacao("Nenhuma observa��o � ser exibida.");
		}else {
			this.applicationItemDTO.setObservacao(obs);
		}
		if(obsRamo == null || "".equals(obsRamo)) {
			this.applicationItemDTO.setObsRamo("Nenhuma observa��o � ser exibida.");
		}else {
			this.applicationItemDTO.setObsRamo(obsRamo);
		}
		this.applicationItemDTO.setStatus(statusSelected); 
		try {
			this.applicationItemService.cadastrar(this.applicationItemDTO);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Opera��o realizada com sucesso!","O projeto "+this.cccc+" foi cadastrado corretamente."));
		}catch(Throwable error) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Por favor contate o administrador do sistema.","Um erro ocorreu!\nPor favor contate o administrador do sistema."));
			error.printStackTrace();
		}
	}
	
	/**
	 * Limpa o formul�rio da tela de inclus�o
	 */
	public void limparCampos() {
		this.acessoRamo = false;
		this.ramoCriado = false;
		this.disponibilizado = false;
		this.cccc = null;
		this.dataPrevistaTermino = null;
		this.dataTermino = null;
		this.obs = null;
		this.obsRamo = null;
		this.statusSelected = null;
	}
	
	/**
	 * Carrega o combo de status na tela.
	 * @return statusCombo - ArrayList<String> - status dos aplicativos.
	 */
	public List<String> loadComboStatus(){
		List<String> statusCombo = new ArrayList<String>();
		for(ApplicationItemEnum aux : ApplicationItemEnum.values()) {
			statusCombo.add(aux.toString());
		}
		return statusCombo;
	}
	
	/**
	 * M�todo utilizado para verificar o status da aplica��o que ser� inclusa na tabela.
	 */
	public void verificaStatus() {
		if(this.statusSelected.equals("Finalizado")){
			this.calendarTermino = true;
			this.calendarPrevisao = false;
		}else {
			this.calendarTermino = false;
			this.calendarPrevisao = true;
		}
	}
	
	/**
	 * M�todo get do atributo cccc.
	 * @return cccc - String - centro de custo coletado em tela.
	 */
	public String getCccc() {
		return this.cccc;
	}

	/**
	 * M�todo set do atributo cccc.
	 * @param cccc - String - centro de custo coletado em tela.
	 */
	public void setCccc(final String cccc) {
		this.cccc = cccc;
	}

	/**
	 * M�todo get do atributo statusSelected.
	 * @return statusSelected - String - valor do status selecionado em tela.
	 */
	public String getStatusSelected() {
		return this.statusSelected;
	}

	/**
	 * M�todo set do atributo statusSelected.
	 * @param statusSelected - String - valor do status selecionado em tela.
	 */
	public void setStatusSelected(final String statusSelected) {
		this.statusSelected = statusSelected;
	}

	/**
	 * M�todo get do atributo ramoCriado.
	 * @return ramoCriado - boolean - representa se o ramo est� criado.
	 */
	public boolean isRamoCriado() {
		return this.ramoCriado;
	}

	/**
	 * M�todo set do atributo ramoCriado.
	 * @param ramoCriado - boolean - representa se o ramo est� criado.
	 */
	public void setRamoCriado(final boolean ramoCriado) {
		this.ramoCriado = ramoCriado;
	}

	/**
	 * M�todo get do atributo acessoRamo.
	 * @return acessoRamo - boolean - representa se possui acesso.
	 */
	public boolean isAcessoRamo() {
		return this.acessoRamo;
	}

	/**
	 * M�todo set do atributo acessoRamo.
	 * @param acessoRamo - boolean - representa se possui acesso.
	 */
	public void setAcessoRamo(final boolean acessoRamo) {
		this.acessoRamo = acessoRamo;
	}

	/**
	 * M�todo get do atributo disponibilizado.
	 * @return disponibilizado - boolean - representa se est� dispon�vel para migrar.
	 */
	public boolean isDisponibilizado() {
		return this.disponibilizado;
	}

	/**
	 * M�todo set do atributo disponibilizado.
	 * @param disponibilizado - boolean - representa se est� dispon�vel para migrar.
	 */
	public void setDisponibilizado(final boolean disponibilizado) {
		this.disponibilizado = disponibilizado;
	}

	/**
	 * Representa a data de t�rmino prevista
	 * @return dataPrevistaTermino - Date - data de t�rmino prevista.
	 */
	public Date getDataPrevistaTermino() {
		return this.dataPrevistaTermino;
	}
	
	/**
	 * Representa a data de t�rmino prevista
	 * @param dataPrevistaTermino - Date - data de t�rmino prevista.
	 */
	public void setDataPrevistaTermino(final Date dataPrevistaTermino) {
		this.dataPrevistaTermino = dataPrevistaTermino;
	}

	/**
	 * M�todo get do atributo obsRamo
	 * @return obsRamo - String observa��o do ramo coletada em tela.
	 */
	public String getObsRamo() {
		return this.obsRamo;
	}

	/**
	 * M�todo set do atributo obsRamo.
	 * @param obsRamo - String - oserva��o do ramo coletada em tela.
	 */
	public void setObsRamo(final String obsRamo) {
		this.obsRamo = obsRamo;
	}

	/**
	 * M�todo get do atributo
	 * @return obs - String - observa��o coletada em tela.
	 */
	public String getObs() {
		return this.obs;
	}

	/**
	 * M�todo set do atributo.
	 * @param obsRamo - String - observa��o coletada em tela.
	 */
	public void setObs(final String obs) {
		this.obs = obs;
	}

	/**
	 * M�todo get do atributo dataTermino.
	 * @return dataTermino - Date - representa o dia que foi finalizada a migra��o.
	 */
	public Date getDataTermino() {
		return this.dataTermino;
	}

	/**
	 * M�todo set do atributo dataTermino.
	 * @param dataTermino - Date - representa o dia que foi finalizada a migra��o.
	 */
	public void setDataTermino(final Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	/**
	 * M�todo get do atributo calendarTermino
	 * @return calendarTermino - boolean - representa se est� selecionado no combo o status Finalizado.
	 */
	public boolean isCalendarTermino() {
		return this.calendarTermino;
	}

	/**
	 * M�todo set do atributo calendarTermino
	 * @param calendarTermino - boolean - representa se est� selecionado no combo o status Finalizado.
	 */
	public void setCalendarTermino(final boolean calendarTermino) {
		this.calendarTermino = calendarTermino;
	}

	/**
	 * M�todo get do atributo calendarPrevisao
	 * @return calendarPrevisao - boolean - representa se est� selecionado no combo o status Pendente ou Andamento.
	 */
	public boolean isCalendarPrevisao() {
		return this.calendarPrevisao;
	}

	/**
	 * M�todo set do atributo calendarPrevisao
	 * @param calendarPrevisao - boolean - representa se est� selecionado no combo o status Pendente ou Andamento.
	 */
	public void setCalendarPrevisao(final boolean calendarPrevisao) {
		this.calendarPrevisao = calendarPrevisao;
	}
	
	/**
	 * Utilizado para bloquear os dias no calend�rio mostrado em tela.
	 * @return new Date() - Date - a data de hoje.
	 */ 
	public Date today() {
		return new Date();
	}
	
}