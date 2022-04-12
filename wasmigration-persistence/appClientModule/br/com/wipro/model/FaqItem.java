/**
 * 
 */
package br.com.wipro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe modelo para representar um determinado aplicativo.
 * @author Bruno Justino
 */
@Entity
@Table(name="FAQITEM")
public class FaqItem implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id do item
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idNumber;
	
	/**
	 * Observa��o pertinente ao ramo do starteam
	 */
	@Column(name="TITLE")
	private String title;
	
	/**
	 * Observa��o pertinente ao ramo do starteam
	 */
	@Column(name="DESCRIPTION")
	private String description;
	
	/**
	 * Indicador da �ltima atualiza��o do registro
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ULTIMA_ATUALIZACAO")
	private Date atualizacao;
	
	/**
	 * Usu�rio da �ltima atualiza��o de registro
	 */
	@Column(name="USUARIO_ULTIMA_ATUALIZACAO")
	private String usuarioUltimaAtualizacao;
	
	/**
	 * Usu�rio de cria��o do registro
	 */
	@Column(name="USUARIO_CRIACAO")
	private String usuarioCriacao;
	
	/**
	 * Data da cria��o do registro
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;

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
	 * M�todo get do atributo atualizacao.
	 * @return atualizacao - Date - data da atualiza��o do registro.
	 */
	public Date getAtualizacao() {
		return this.atualizacao;
	}

	/**
	 * M�todo set do atributo atualizacao.
	 * @param atualizacao - Date - data da atualiza��o do registro.
	 */
	public void setAtualizacao(final Date atualizacao) {
		this.atualizacao = atualizacao;
	}

	/**
	 * M�todo get do atributo usuarioUltimaAtualizacao.
	 * @return usuarioUltimaAtualizacao - String - usu�rio que realizou a �ltima atualiza��o de registro.
	 */
	public String getUsuarioUltimaAtualizacao() {
		return this.usuarioUltimaAtualizacao;
	}

	/**
	 * M�todo set do atributo usuarioUltimaAtualizacao.
	 * @param usuarioUltimaAtualizacao - String - usu�rio que realizou a �ltima atualiza��o de registro.
	 */
	public void setUsuarioUltimaAtualizacao(final String usuarioUltimaAtualizacao) {
		this.usuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
	}

	/**
	 * M�todo get do atributo usuarioCriacao.
	 * @return usuarioCriacao - String - usu�rio da cria��o do registro.
	 */
	public String getUsuarioCriacao() {
		return this.usuarioCriacao;
	}

	/**
	 * M�todo set do atributo usuarioCriacao.
	 * @param usuarioCriacao - String -  usu�rio da cria��o do registro.
	 */
	public void setUsuarioCriacao(final String usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	/**
	 * M�todo get do atributo dataCriacao.
	 * @return dataCriacao - Date - data da cria��o do registro.
	 */
	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	/**
	 * M�todo set do atributo dataCriacao.
	 * @param dataCriacao - Date - data da cria��o do registro.
	 */
	public void setDataCriacao(final Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atualizacao == null) ? 0 : atualizacao.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((usuarioCriacao == null) ? 0 : usuarioCriacao.hashCode());
		result = prime * result + ((usuarioUltimaAtualizacao == null) ? 0 : usuarioUltimaAtualizacao.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FaqItem other = (FaqItem) obj;
		if (atualizacao == null) {
			if (other.atualizacao != null)
				return false;
		} else if (!atualizacao.equals(other.atualizacao))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (usuarioCriacao == null) {
			if (other.usuarioCriacao != null)
				return false;
		} else if (!usuarioCriacao.equals(other.usuarioCriacao))
			return false;
		if (usuarioUltimaAtualizacao == null) {
			if (other.usuarioUltimaAtualizacao != null)
				return false;
		} else if (!usuarioUltimaAtualizacao.equals(other.usuarioUltimaAtualizacao))
			return false;
		return true;
	}
	
}