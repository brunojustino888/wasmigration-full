package br.com.wipro.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.wipro.dto.FaqItemDTO;
import br.com.wipro.service.FaqItemService;

/**
 * Respons�vel por controle da tela faq-home.xhtml
 * 
 * @author brunoj - Bruno Alves Justino - Wipro
 */
@Named
@ViewScoped
public class FaqHomeBean implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ItemFAQ para inclus�o.
	 */
	private FaqItemDTO includeItem;

	/**
	 * Service respons�vel pelos itens de FAQ.
	 */
	@EJB
	private FaqItemService service;

	/**
	 * Lista de itens de FAQ que aparece em tela.
	 */
	private List<FaqItemDTO> listaDTO;

	/**
	 * Lista de itens de FAQ pesquisados que aparecem em tela.
	 */
	private List<FaqItemDTO> listaPesquisados;

	/**
	 * ItemFAQ selecionado em tela.
	 */
	private FaqItemDTO selectedItem;

	/**
	 * Construtor inicializando servi�o respons�vel pelos itens de FAQ.
	 */
	@PostConstruct
	public void init() {
		this.includeItem = new FaqItemDTO();
		this.listaDTO = this.service.listar();
	}

	/**
	 * Utilizado para inclus�o de um determinado item de FAQ.
	 */
	public void incluir() {
		try {
			this.service.incluir(this.includeItem);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Opera��o realizada com sucesso!", "Um novo de FAQ foi cadastrado corretamente."));
		} catch (Throwable error) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Por favor contate o administrador do sistema.",
							"Um erro ocorreu!\nPor favor contate o administrador do sistema."));
			error.printStackTrace();
		}
	}

	/**
	 * Utilizado para excluir um determinado item de FAQ.
	 */
	public void excluir() {
		for (int i = 0; i < this.listaDTO.size(); i++) {
			if (this.listaDTO.get(i).getIdNumber() == this.selectedItem.getIdNumber()) {
				try {
					this.service.excluir(this.listaDTO.get(i));
					this.listaDTO.remove(i);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Opera��o realizada com sucesso!", "O item foi exclu�do corretamente."));
				} catch (Throwable error) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_FATAL,
									"Por favor contate o administrador do sistema.",
									"Um erro ocorreu!\nPor favor contate o administrador do sistema."));
					error.printStackTrace();
				}
			}
		}
	}

	/**
	 * Utilizado para editar um determinado item de FAQ.
	 */
	public void editar() {
		for (int i = 0; i < this.listaDTO.size(); i++) {
			if (this.listaDTO.get(i).getIdNumber() == this.selectedItem.getIdNumber()) {
				try {
					this.service.editar(this.selectedItem);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Opera��o realizada com sucesso!", "O item foi modificado corretamente."));
				} catch (Throwable error) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_FATAL,
									"Por favor contate o administrador do sistema.",
									"Um erro ocorreu!\nPor favor contate o administrador do sistema."));
					error.printStackTrace();
				}
			}
		}
	}

	/**
	 * M�todo get do atributo listaDTO.
	 * 
	 * @return listaDTO - List<FaqItemDTO> - lista DTO de itens de FAQ.
	 */
	public List<FaqItemDTO> getListaDTO() {
		return this.listaDTO;
	}

	/**
	 * M�todo set do atributo listaDTO.
	 * 
	 * @param listaDTO
	 *            - List<FaqItemDTO> - lista DTO de itens de FAQ.
	 */
	public void setListaDTO(final List<FaqItemDTO> listaDTO) {
		this.listaDTO = listaDTO;
	}

	/**
	 * M�todo get do atributo selectedItem.
	 * 
	 * @return selectedItem - FaqItemDTO - representa o item selecionado em tela no
	 *         dataGrid.
	 */
	public FaqItemDTO getSelectedItem() {
		return this.selectedItem;
	}

	/**
	 * M�todo set do atributo selectedItem.
	 * 
	 * @param selectedItem
	 *            - FaqItemDTO - representa o item selecionado em tela no dataGrid.
	 */
	public void setSelectedItem(final FaqItemDTO selectedItem) {
		this.selectedItem = selectedItem;
	}

	/**
	 * M�todo get do atributo includeItem.
	 * 
	 * @return includeItem - FaqItemDTO - DTO utilizado para inclusao
	 */
	public FaqItemDTO getIncludeItem() {
		return this.includeItem;
	}

	/**
	 * M�todo set do atributo includeItem.
	 * 
	 * @param includeItem
	 *            - FaqItemDTO - DTO utilizado para inclusao
	 */
	public void setIncludeItem(final FaqItemDTO includeItem) {
		this.includeItem = includeItem;
	}

	/**
	 * M�todo get do atributo listaPesquisados.
	 * 
	 * @return listaPesquisados - List<FaqItemDTO> - lista contendo itens que se
	 *         encaixam na pesquisa.
	 */
	public List<FaqItemDTO> getListaPesquisados() {
		return this.listaPesquisados;
	}

	/**
	 * M�todo set do atributo listaPesquisados.
	 * 
	 * @param listaPesquisados
	 *            - List<FaqItemDTO> - lista contendo itens que se encaixam na
	 *            pesquisa.
	 */
	public void setListaPesquisados(final List<FaqItemDTO> listaPesquisados) {
		this.listaPesquisados = listaPesquisados;
	}

}