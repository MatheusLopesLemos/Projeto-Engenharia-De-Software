package model;

/**
 * Representa as exceções que são lançadas quando ocorre
 * a atribuição de um valor inválido para um objeto da 
 * camada model (ou seja, um objeto de dados)
 */
public class ModelException extends Exception {	
	/**
	 * Construtor de ModelException
	 * @param textoDoErro descreve a mensagem do erro que ocorreu
	 */
	public ModelException(String textoDoErro) {
		super(textoDoErro);
	}
}
