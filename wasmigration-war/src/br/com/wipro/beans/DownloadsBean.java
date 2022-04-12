package br.com.wipro.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * Bean respons�vel pela tela de downloads.
 * @author brunoj - Bruno Alves Justino - Wipro
 */
@Named
@ViewScoped
public class DownloadsBean implements Serializable {

	/**
	 * Serial verison UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Lista com os nomes dos documentos dispon�veis para download.
	 */
	private List<String> docsNameList;
	
	/**
	 * Representa o arquivo que ser� baixado pelo usu�rio.
	 */
	private StreamedContent file;
	
	/**
	 * Representa o arquivo que ser� baixado pelo usu�rio.
	 */
	private StreamedContent file1;
	
	/**
	 * Representa o arquivo que ser� baixado pelo usu�rio.
	 */
	private StreamedContent file2;
	
	/**
	 * Representa o arquivo que ser� baixado pelo usu�rio.
	 */
	private StreamedContent file3;
	
	/**
	 * Representa o arquivo que ser� baixado pelo usu�rio.
	 */
	private StreamedContent file4;

	/**
	 * Nome do arquivo que dever� ser baixado.
	 */
	private String fileName;

	/**
	 * Construtor inicializando a lista de documentos dispon�veis para download.
	 */
	public DownloadsBean() {
		this.docsNameList = new ArrayList<String>();
		this.docsNameList.add("Armazenamento de jar's no StarTeam_v1.1.pdf");
		this.docsNameList.add("JAAS - Manual do usu�rio_v1.1.pdf");
		this.docsNameList.add("Laudo de migra��o WASv85_cccc_v1.1.pdf");
		this.docsNameList.add("Padr�es de nomenclatura WASv85 intranet_v1.0.pdf");
		this.docsNameList.add("Procedimentos de migra��o WASv85 intranet_v1.3.pdf");
	}
	
	/**
	 * M�todo get do atributo docsNameList.
	 * @return docsNameList - List<String> - lista com nome dos documentos.
	 */
	public List<String> getDocsNameList() {
		return this.docsNameList;
	}

	/**
	 * M�todo set do atributo docsNameList.
	 * @param docsNameList - List<String> - lista com nome dos documentos.
	 */
	public void setDocsNameList(final List<String> docsNameList) {
		this.docsNameList = docsNameList;
	}
	
	/**
	 * M�todo get do atributo fileName.
	 * @return fileName - String - representa o nome do arquivo.
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * M�todo set do atributo fileName.
	 * @param fileName - String - representa o nome do arquivo.
	 */
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	/**
	 * M�todo get do documento que ser� disponibilizado para download
	 * @return file - StreamedContent - arquivo para download.
	 */
    public StreamedContent getFile() {
    	InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/Procedimentos de migra��o WASv85 intranet_v1.3.pdf");
        this.file = new DefaultStreamedContent(stream, "application/pdf", "Procedimentos de migra��o WASv85 intranet_v1.3.pdf");
        return this.file;
    }
    
	/**
	 * M�todo get do documento que ser� disponibilizado para download
	 * @return file1 - StreamedContent - arquivo para download.
	 */
    public StreamedContent getFile1() {
    	InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/Padr�es de nomenclatura WASv85 intranet_v1.0.pdf");
        this.file1 = new DefaultStreamedContent(stream, "application/pdf", "Padr�es de nomenclatura WASv85 intranet_v1.0.pdf");
        return this.file1;
    }
    
	/**
	 * M�todo get do documento que ser� disponibilizado para download
	 * @return file2 - StreamedContent - arquivo para download.
	 */
    public StreamedContent getFile2() {
    	InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/Laudo de migra��o WASv85_cccc_v1.1.docx");
        this.file2 = new DefaultStreamedContent(stream, "application/docx", "Laudo de migra��o WASv85_cccc_v1.1.docx");
        return this.file2;
    }
    
	/**
	 * M�todo get do documento que ser� disponibilizado para download
	 * @return file3 - StreamedContent - arquivo para download.
	 */
    public StreamedContent getFile3() {
    	InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/JAAS - Manual do usu�rio_v1.1.pdf");
        this.file3 = new DefaultStreamedContent(stream, "application/pdf", "JAAS - Manual do usu�rio_v1.1.pdf");
        return this.file3;
    }
    
	/**
	 * M�todo get do documento que ser� disponibilizado para download
	 * @return file4 - StreamedContent - arquivo para download.
	 */
    public StreamedContent getFile4() {
    	InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/Armazenamento de jar's no StarTeam_v1.1.pdf");
        this.file4 = new DefaultStreamedContent(stream, "application/pdf", "Armazenamento de jar's no StarTeam_v1.1.pdf");
        return this.file4;
    }
	
}