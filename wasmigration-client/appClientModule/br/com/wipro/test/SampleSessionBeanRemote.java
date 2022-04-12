package br.com.wipro.test;
import java.util.List;

import javax.ejb.Remote;

/**
 * Interface remota de negócio.
 * @author brunoj - Bruno Justino - Wipro
 */
@Remote
public interface SampleSessionBeanRemote {
	
	/**
	 * Método utilizado para adicionar uma String à lista.
	 * @param string - String - string à ser adicionada na lista.
	 */
	void addString(String string);
	
	/**
	 * Método para retornar uma lista de Strings.
	 * @return List<String> - ArrayList<String> - Lista de Strings.
	 */
	List<String> getList();
	
}