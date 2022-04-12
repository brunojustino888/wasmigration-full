/**
 * 
 */
package br.com.wipro.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.wipro.dto.FaqItemDTO;
import br.com.wipro.model.FaqItem;

/**
 * Mapper respons�vel por converter DTO de FaqItem para Entidade e vice-versa.
 * @author brunoj - Bruno Alves Justino - Wipro.
 */
public class FaqItemMapper implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Converte lista de entidades em DTO.
	 * @param listaEntidade - List<FaqItem> - lista de entidade.
	 * @return result - List<FaqItemDTO> - lista de DTO
	 */
	public List<FaqItemDTO> convertListToDTO(List<FaqItem> listaEntidade) {
		List<FaqItemDTO> result = new ArrayList<FaqItemDTO>();
		for(FaqItem aux : listaEntidade) {
			FaqItemDTO faqDTO = new FaqItemDTO();
			faqDTO.setIdNumber(aux.getIdNumber());
			faqDTO.setTitle(aux.getTitle());
			faqDTO.setDescription(aux.getDescription());
			try {
				faqDTO.setShortdescription(aux.getDescription().substring(0,50)+"...");
			}catch(Exception e) {
				faqDTO.setShortdescription(aux.getTitle());
			}
			result.add(faqDTO);
		}
		return result;
	}

	/**
	 * Transforma DTO em entidade para realizar a modifica��o de um determinado item de FAQ.
	 * @param item - FaqItemDTO - dto que ser� transformado em entidade.
	 * @param entity - FaqItem- entidade que sofrer� a altera��o.
	 * @return entity - FaqItem - entidade com valores prontos para a altera��o.
	 */
	public FaqItem convertDTOToModel(FaqItemDTO item, FaqItem entity) {
		entity.setAtualizacao(new Date());
		entity.setDescription(item.getDescription());
		entity.setTitle(item.getTitle());
		return entity;
	}

}