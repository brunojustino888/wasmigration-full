package br.com.wipro.service;
import java.util.List;

import javax.ejb.Remote;

import br.com.wipro.dto.ApplicationItemDTO;

/**
 * Interface utilizada para os servi�os respons�veis pela a��es do sistema.
 * @author Bruno Justino
 */
@Remote
public interface ApplicationItemService {

	/**
	 * Utilizado para cadastrar um determinado novo aplicativo no sistema.
	 */
	void cadastrar(ApplicationItemDTO item);
	
	/**
	 * Utilizado para listar os aplicativos do sistema.
	 * @return List<ApplicationItem> - lista de aplicativos cadastrados.
	 */
	List<ApplicationItemDTO> listar();
	
	/**
	 * Utilizado para editar um determinado registro.
	 * @param item - ApplicationItemDTO - objeto que representa o registro � ser editado.
	 * @return true no caso de edi��o bem sucedida.
	 */
	void editar(ApplicationItemDTO item);
	
	/**
	 * Utilizado para excluir um determinado registro.
	 * @param item - ApplicationItemDTO - objeto que representa o registro � ser exclu�do.
	 * @return true no caso de exclus�o bem sucedida.
	 */
	void excluir(ApplicationItemDTO item);
	
	/**
	 * Respons�vel por encontrar uma determinada entidade e transforma-l� em DTO.
	 * @param idNumber - Long - pk da entidade.
	 * @return ApplicationItemDTO - DTO para mostrar em tela.
	 */
	ApplicationItemDTO buscarPorId(Long idNumber);

	/**
	 * Conta a quantidade de registros da tabela.
	 * @return Long - quantidade de registros cadastrados na base de dados.
	 */
	Long countAll();
	
	/**
	 * Conta a quantidade de registros da tabela com o status pendente.
	 * @return Long - quantidade de registros cadastrados na base de dados.
	 */
	Long countStatusPendente();
	
	/**
	 * Conta a quantidade de registros da tabela com o status andamento.
	 * @return Long - quantidade de registros cadastrados na base de dados.
	 */
	Long countStatusAndamento();
	
	/**
	 * Conta a quantidade de registros da tabela com o status finalizado.
	 * @return Long - quantidade de registros cadastrados na base de dados.
	 */
	Long countStatusFinalizado();
	
}