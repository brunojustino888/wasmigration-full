package br.com.wipro.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.wipro.dto.FaqItemDTO;

/**
 * Service respons�vel pelos itens de FAQ.
 * @author brunoj - Bruno Alves Justino - Wipro
 */
@Remote
public interface FaqItemService {

	/**
	 * Utilizado para listar os itens de FAQ cadastrados na base de dados.
	 * @return List<FaqItemDTO> - lista de DTO's de itens de FAQ.
	 */
	List<FaqItemDTO> listar();

	/**
	 * Utilizado para exclus�o de um determinado item de FAQ
	 * @param item - FaqItemDTO - DTO do item que ser� apagado.
	 */
	void excluir(FaqItemDTO item);

	/**
	 * Respons�vel pela edi��o de um determinado item de FAQ.
	 * @param item - FaqItemDTO - DTO do item que ser� modificado.
	 */
	void editar(FaqItemDTO item);

	/**
	 * Utilizado para incluir um determinado item de FAQ na base de dados.
	 * @param includeItem - FaqItemDTO - dto da inclus�o.
	 */
	void incluir(FaqItemDTO includeItem);
	
}