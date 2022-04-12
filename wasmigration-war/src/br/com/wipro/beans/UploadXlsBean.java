package br.com.wipro.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.wipro.components.ExcelReader;
import br.com.wipro.components.ExcelWriter;
import br.com.wipro.dto.ApplicationItemDTO;
import br.com.wipro.service.ApplicationItemService;

/**
 * Classe utilizada para import de uma planilha excel.
 * 
 * @author brunoj - Bruno Alves Justino
 *
 */
@Named
@ViewScoped
public class UploadXlsBean implements Serializable {

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
	 * Atributo para esconder o bot�o de upload enquanto o arquivo n�o for carregado
	 * corretamente.
	 */
	private boolean uploadButtomVisible;

	/**
	 * Representa a planilha em arquivo.
	 */
	private UploadedFile file;
	
	/**
	 * Representa o arquivo de Excel modelo de importa��o que pode ser baixado
	 */
	private StreamedContent downloadFile;
	
	/**
	 * Representa a planilha importada no sistema.
	 */
	private List<ArrayList<String>> planilha;
	
	/**
	 * Representa a planilha importada no sistema em forma de DTO.
	 */
	private List<ApplicationItemDTO> planilhaDTO;
	
	/**
	 * M�todo respons�vel pelo controle do evento ap�s upload do arquivo selecionado
	 * em tela
	 * 
	 * @param event
	 *            - FileUploadEvent - Evento de upload.
	 */
	public void handleFileUpload(FileUploadEvent event) {
		this.file = event.getFile();
		if(this.file!=null) {
			this.uploadButtomVisible = true;
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Nenhum arquivo foi carregado.", "Certifique-se que a planilha Excel est� no padr�o modelo."));
			this.uploadButtomVisible = false;
		}
	}
	
	/**
	 * M�todo utilizado para mostrar o arquivo que ser� importado na tela.
	 * @return Clique em finalizar para importar o arquivo [nomeDoarquivo] - String - nome do arquivo que ser� importado.
	 */
	public String messagePreUpload() {
		return "Clique em finalizar para importar o arquivo "+this.file.getFileName();
	}

	/**
	 * Utilizado para finalizar o upload do arquivo carregado na view.
	 */
	public void upload() {
		try {
			new ExcelWriter(this.file); 
			this.planilha =	new ExcelReader("C:\\tmp\\" + this.file.getFileName()).getData();
			this.createDTOList();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Opera��o realizada com sucesso!", "A planilha foi importada corretamente."));
		}catch (Exception e ) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"O arquivo n�o pode ser carregado.", "Certifique-se que se trata de uma planilha Excel igual o modelo de importa��o disponibilizado."));
		}finally {
		    this.file = null;
			this.uploadButtomVisible = false;
		}
	}

	/**
	 * Respons�vel por criar a lista de DTO que ser� inserida na base de dados.
	 * @throws ParseException 
	 */
	private void createDTOList() {
		this.planilhaDTO = new ArrayList<ApplicationItemDTO>();
		for(int i = 1; i < this.planilha.size(); i++) {
			int coluna = 0;
			ApplicationItemDTO applicationItemDTO = new ApplicationItemDTO();
			applicationItemDTO.setStatus(this.planilha.get(i).get(coluna++));
			applicationItemDTO.setCentroCusto(this.planilha.get(i).get(coluna++));
			try {
				applicationItemDTO.setDataPrevistaTermino(new SimpleDateFormat("dd/MM/yyyy").parse(this.planilha.get(i).get(coluna++)));
			} catch (Exception e) {
				applicationItemDTO.setDataPrevistaTermino(null);
			}
			try {
				applicationItemDTO.setDataTermino(new SimpleDateFormat("dd/MM/yyyy").parse(this.planilha.get(i).get(coluna++)));
			} catch (Exception e) {
				applicationItemDTO.setDataTermino(null);
			}
			applicationItemDTO.setObservacao(this.planilha.get(i).get(coluna++));
			applicationItemDTO.setAcessoStarteam(this.planilha.get(i).get(coluna++));
			applicationItemDTO.setRamoCriado(this.planilha.get(i).get(coluna++));
			applicationItemDTO.setObsRamo(this.planilha.get(i).get(coluna++));
			applicationItemDTO.setDisponibilizado(this.planilha.get(i).get(coluna++));
			this.planilhaDTO.add(applicationItemDTO);
			this.applicationItemService.cadastrar(applicationItemDTO);
		}
	}

	/**
	 * M�todo get do atributo file.
	 * 
	 * @return file - UploadedFile - Representa a planilha carregada
	 */
	public UploadedFile getFile() {
		return this.file;
	}

	/**
	 * M�todo set do atributo file.
	 * 
	 * @param file
	 *            - UploadedFile - Representa a planilha carregada
	 */
	public void setFile(final UploadedFile file) {
		this.file = file;
	}

	/**
	 * M�todo get do atributo uploadButtomVisible.
	 * 
	 * @return uploadButtomVisible - boolean - representa se o bot�o de upload est�
	 *         vis�vel.
	 */
	public boolean isUploadButtomVisible() {
		return this.uploadButtomVisible;
	}

	/**
	 * M�todo set do atributo uploadButtomVisible.
	 * 
	 * @param uploadButtomVisible
	 *            - boolean - representa se o bot�o de upload est� vis�vel.
	 */
	public void setUploadButtomVisible(final boolean uploadButtomVisible) {
		this.uploadButtomVisible = uploadButtomVisible;
	}

	/**
	 * M�todo get do atributo planilha.
	 * @return planilha - List<ArrayList<String>> - planilha importada.
	 */
	public List<ArrayList<String>> getPlanilha() {
		return this.planilha;
	}

	/**
	 * M�todo set do atributo planilha.
	 * @param planilha - List<ArrayList<String>> - planilha importada.
	 */
	public void setPlanilha(final List<ArrayList<String>> planilha) {
		this.planilha = planilha;
	}

	/**
	 * M�todo get do atributo downloadFile.
	 * @return downloadFile - StreamedContent - planilha modelo para download.
	 */
	public StreamedContent getDownloadFile() {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/xlsx/ModeloXlsx.xlsx");
		downloadFile = new DefaultStreamedContent(stream, "application/xlsx" ,"downloaded_modelo.xlsx");
		return this.downloadFile;
	}
	
}