package br.com.wipro.test;
import java.util.List;

import javax.ejb.Remote;

/**
 * Interface remota de neg�cio.
 * @author brunoj - Bruno Justino - Wipro
 */
@Remote
public interface SampleSessionBeanRemote {
	
	/**
	 * M�todo utilizado para adicionar uma String � lista.
	 * @param string - String - string � ser adicionada na lista.
	 */
	void addString(String string);
	
	/**
	 * M�todo para retornar uma lista de Strings.
	 * @return List<String> - ArrayList<String> - Lista de Strings.
	 */
	List<String> getList();
	
}