package br.com.wipro.dto;

import java.io.Serializable;

/**
 * DTO utilizado para os dados dos itens de FAQ
 * @author brunoj - Bruno Alves Justino - Wipro
 */
public class FaqItemDTO implements Serializable{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id do item
	 */
	private Long idNumber;
	
	/**
	 * Descri��o do item de FAQ.
	 */
	private String description;
	
	/**
	 * Descri��o do item de FAQ com quantidade de 50 caracteres.
	 */
	private String shortdescription;
	
	/**
	 * T�tulo do item de FAQ.
	 */
	private String title;
	
	/**
	 * M�todo get do atributo
	 * @return idNumber - Long - chave prim�ria. 
	 */
	public Long getIdNumber() {
		return this.idNumber;
	}

	/**
	 * M�todo set do atributo
	 * @param idNumber - Long - chave prim�ria. 
	 */
	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}
	
	/**
	 * M�todo get do atributo title.
	 * @return title - String - Representa o t�tulo de um item de Faq
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * M�todo set do atributo title.
	 * @param title - String - Representa o t�tulo de um item de Faq
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * M�todo get do atributo description.
	 * @return description - String - Representa a descri��o de um item de Faq
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * M�todo set do atributo description.
	 * @param description - String - Representa a descri��o de um item de Faq
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * M�todo get do atributo shortdescription.
	 * @return shortdescription - String - representa uma pequena descri��o de at� 50 caracteres.
	 */
	public String getShortdescription() {
		return this.shortdescription;
	}
	
	/**
	 * M�todo set do atributo shortdescription.
	 * @param shortdescription - String - representa uma pequena descri��o de at� 50 caracteres.
	 */
	public void setShortdescription(final String shortdescription) {
		this.shortdescription = shortdescription;
	}
	
}