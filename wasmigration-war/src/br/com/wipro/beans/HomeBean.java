package br.com.wipro.beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.wipro.dto.ApplicationItemDTO;
import br.com.wipro.service.ApplicationItemService;

/**
 * Back-end da tela home-wasmigration.xhtml
 * @author Bruno Justino
 */
@Named
@ViewScoped
public class HomeBean implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Servi�o respons�vel pelas a��es da tela. 
	 */
	@EJB
	private ApplicationItemService applicationItemService;
	
	/**
	 * Lista de aplicativos mostrada em tela
	 */
	private List<ApplicationItemDTO> appList = new ArrayList<ApplicationItemDTO>();
	
	/**
	 * Respresenta o id do objeto que ser� editado.
	 */
	private Long editItem;
	
	/**
	 * Construtor default do bean. 
	 * Respons�vel por carregar a tabela de aplicativos que dever�o ser migrados posteriormente.
	 */
	@PostConstruct
	public void init() {
		this.appList = applicationItemService.listar();
	}
	
	/**
	 * Utilizado para excluir um determinado registro da tabela mostrada em tela
	 * @param id - Long - pk do registro
	 */
	public void excluir(final Long id) {
		try {
			ApplicationItemDTO item = null;
			for(int i=0; i<this.appList.size() ;i++) {
				if(appList.get(i).getIdNumber()==id) {
					item = this.appList.get(i);
					this.applicationItemService.excluir(item);
				}
			}
			this.appList.remove(item);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Opera��o realizada com sucesso!","O projeto "+item.getCentroCusto()+" foi exclu�do corretamente."));
		}catch(Throwable error) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Por favor contate o administrador do sistema.","Um erro ocorreu!\nPor favor contate o administrador do sistema."));
			error.printStackTrace();
		}
	}
	
	/**
	 * Utilizado para migrar um determinado registro de pendente para finalizado (tabela mostrada em tela).
	 * @param id - Long - pk do registro que sofrer� a altera��o.
	 */
	public void migrar(final Long id) {
		try {
			ApplicationItemDTO item = null;
			for(int i=0; i<this.appList.size() ;i++) {
				if(appList.get(i).getIdNumber()==id) {
					item = this.appList.get(i);
					item.setStatus("Finalizado");
					item.setDataTermino(new Date());
					this.applicationItemService.editar(item);
				}
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Opera��o realizada com sucesso!","O projeto "+item.getCentroCusto()+" foi migrado corretamente."));
		}catch(Throwable error) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL,
							"Por favor contate o administrador do sistema.","Um erro ocorreu!\nPor favor contate o administrador do sistema."));
			error.printStackTrace();
		}
	}
	
	/**
	 * Respons�vel pela navega��o da tela home-wasmigration.xhtml para a edi��o de um determinado registro.
	 * @return edit-wasmigration.xhtml - String - nome da tela 
	 */
	public String edit() {
		ApplicationItemDTO dto = this.applicationItemService.buscarPorId(Long.parseLong(this.editItem.toString()));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editDTO", dto);
		return "edit-wasmigration.xhtml?faces-redirect=true";
	}
	
	/**
	 * M�todo get da lista de projetos mostrada em tela no datatable
	 * @return appList - List<ApplicationItemDTO> - lista de projetos.
	 */
	public List<ApplicationItemDTO> getAppList() {
		return this.appList;
	}

	/**
	 * M�todo set da lista de projetos que s�o mostrados em tela
	 * @param appList - List<ApplicationItemDTO> - lista de projetos.
	 */
	public void setAppList(final List<ApplicationItemDTO> appList) {
		this.appList = appList;
	}

	/**
	 * M�todo get do atributo editItem.
	 * @return editItem - Long - id do item que ser� editado.
	 */
	public Long getEditItem() {
		return this.editItem;
	}

	/**
	 * M�todo set do atributo editItem.
	 * @param editItem - Long - id do item que ser� editado.
	 */
	public void setEditItem(final Long editItem) {
		this.editItem = editItem;
	}
	
}