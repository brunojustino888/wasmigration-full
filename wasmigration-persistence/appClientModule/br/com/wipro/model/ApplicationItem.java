package br.com.wipro.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.wipro.enums.ApplicationItemEnum;

/**
 * Classe modelo para representar um determinado aplicativo.
 * @author Bruno Justino
 */
@Entity
@Table(name="WASAPPLICATIONS")
public class ApplicationItem implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id do projeto
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long idNumber;
	
	/**
	 * Status do projeto
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private ApplicationItemEnum status;
	
	/**
	 * Centro de custo do projeto
	 */
	@Column(name="CENTROCUSTO")
	private String centroCusto;
	
	/**
	 * Data prevista para a migra��o do projeto
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATAPREVISTA")
	private Date dataPrevistaTermino;
	
	/**
	 * Data de finaliza��o da migra��o do projeto
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="DATATERMINO")
	private Date dataTermino;
	
	/**
	 * Observa��o do projeto
	 */ 
	@Column(name="OBSERVACAO")
	private String observacao;
	
	/**
	 * Indicador l�gico de acesso ao projeto 
	 */
	@Column(name="ACCESSOK")
	private Boolean acessoStarteam;
	
	/**
	 * Indicador l�gico para o ramo criado da migra��o
	 */
	@Column(name="RAMOOK")
	private Boolean ramoCriado;
	
	/**
	 * Observa��o pertinente ao ramo do starteam
	 */
	@Column(name="OBSRAMO")
	private String obsRamo;
	
	/**
	 * Indicador l�gico para a disponibiliza��o de migra��o de um determinado projeto
	 */
	@Column(name="AVAILABLE")
	private Boolean disponibilizado;
	
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
	 * M�todo get do atributo status.
	 * @return status - ApplicationItemEnum - Enum que representa o status.
	 */
	public ApplicationItemEnum getStatus() {
		return this.status;
	}

	/**
	 * M�todo set do atributo status.
	 * @param status - ApplicationItemEnum - Enum que representa o status.
	 */
	public void setStatus(ApplicationItemEnum status) {
		this.status = status;
	}

	/**
	 * M�todo get do atributo centroCusto
	 * @return centroCusto - String - representa o centro de custo.
	 */
	public String getCentroCusto() {
		return this.centroCusto;
	}

	/**
	 * M�todo set do atributo centroCusto
	 * @param centroCusto - String - representa o centro de custo.
	 */
	public void setCentroCusto(final String centroCusto) {
		this.centroCusto = centroCusto;
	}

	/**
	 * M�todo get do atributo dataPrevistaTermino.
	 * @return dataPrevistaTermino - Date - Representa a data prevista para t�rmino da migra��o.
	 */
	public Date getDataPrevistaTermino() {
		return this.dataPrevistaTermino;
	}

	/**
	 * M�todo set do atributo dataPrevistaTermino.
	 * @param dataPrevistaTermino - Date - Representa a data prevista para t�rmino da migra��o.
	 */
	public void setDataPrevistaTermino(final Date dataPrevistaTermino) {
		this.dataPrevistaTermino = dataPrevistaTermino;
	}

	/**
	 * M�todo get do atributo observacao.
	 * @return observacao - String - observa��o do usu�rio.
	 */
	public String getObservacao() {
		return this.observacao;
	}

	/**
	 * M�todo set do atributo observacao.
	 * @param observacao - String - observa��o do usu�rio.
	 */
	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}

	/**
	 * M�todo get do atributo acessoStarteam.
	 * @return acessoStarteam - Boolean - representa acesso ao ramo do starteam.
	 */
	public Boolean getAcessoStarteam() {
		return this.acessoStarteam;
	}

	/**
	 * M�todo set do atributo acessoStarteam.
	 * @param acessoStarteam - Boolean - Representa acesso ao ramo do starteam.
	 */
	public void setAcessoStarteam(final Boolean acessoStarteam) {
		this.acessoStarteam = acessoStarteam;
	}

	/**
	 * M�todo get do atributo ramoCriado.
	 * @return ramoCriado - Boolean - Representa se existe ramo criado no starteam para a migra��o.
	 */
	public Boolean getRamoCriado() {
		return this.ramoCriado;
	}

	/**
	 * M�todo set do atributo ramoCriado.
	 * @param ramoCriado - Boolean - Representa se existe ramo criado no starteam para a migra��o.
	 */
	public void setRamoCriado(final Boolean ramoCriado) {
		this.ramoCriado = ramoCriado;
	}

	/**
	 * M�todo get do atributo obsRamo
	 * @return obsRamo - String - observa��o do ramo.
	 */
	public String getObsRamo() {
		return this.obsRamo;
	}

	/**
	 * M�todo set do atributo obsRamo
	 * @param obsRamo - String - observa��o do ramo.
	 */
	public void setObsRamo(final String obsRamo) {
		this.obsRamo = obsRamo;
	}

	/**
	 * M�todo get do atributo disponibilizado.
	 * @return disponibilizado - Boolean - representa se a aplica��o foi disponibilizada para a migra��o.
	 */
	public Boolean getDisponibilizado() {
		return this.disponibilizado;
	}

	/**
	 * M�todo set do atributo disponibilizado.
	 * @param disponibilizado - Boolean - representa se a aplica��o foi disponibilizada para a migra��o.
	 */
	public void setDisponibilizado(final Boolean disponibilizado) {
		this.disponibilizado = disponibilizado;
	}

	/**
	 * M�todo get do atributo dataTermino.
	 * @return dataTermino - Date - data de t�rmino da migra��o.
	 */
	public Date getDataTermino() {
		return this.dataTermino;
	}

	/**
	 * M�todo set do atributo dataTermino.
	 * @param dataTermino - Date - data de t�rmino da migra��o.
	 */
	public void setDataTermino(final Date dataTermino) {
		this.dataTermino = dataTermino;
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
		result = prime * result + ((acessoStarteam == null) ? 0 : acessoStarteam.hashCode());
		result = prime * result + ((atualizacao == null) ? 0 : atualizacao.hashCode());
		result = prime * result + ((centroCusto == null) ? 0 : centroCusto.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataPrevistaTermino == null) ? 0 : dataPrevistaTermino.hashCode());
		result = prime * result + ((dataTermino == null) ? 0 : dataTermino.hashCode());
		result = prime * result + ((disponibilizado == null) ? 0 : disponibilizado.hashCode());
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((obsRamo == null) ? 0 : obsRamo.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((ramoCriado == null) ? 0 : ramoCriado.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ApplicationItem other = (ApplicationItem) obj;
		if (acessoStarteam == null) {
			if (other.acessoStarteam != null)
				return false;
		} else if (!acessoStarteam.equals(other.acessoStarteam))
			return false;
		if (atualizacao == null) {
			if (other.atualizacao != null)
				return false;
		} else if (!atualizacao.equals(other.atualizacao))
			return false;
		if (centroCusto == null) {
			if (other.centroCusto != null)
				return false;
		} else if (!centroCusto.equals(other.centroCusto))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataPrevistaTermino == null) {
			if (other.dataPrevistaTermino != null)
				return false;
		} else if (!dataPrevistaTermino.equals(other.dataPrevistaTermino))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (disponibilizado == null) {
			if (other.disponibilizado != null)
				return false;
		} else if (!disponibilizado.equals(other.disponibilizado))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (obsRamo == null) {
			if (other.obsRamo != null)
				return false;
		} else if (!obsRamo.equals(other.obsRamo))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (ramoCriado == null) {
			if (other.ramoCriado != null)
				return false;
		} else if (!ramoCriado.equals(other.ramoCriado))
			return false;
		if (status != other.status)
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