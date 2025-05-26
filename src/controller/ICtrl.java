package controller;

/**
 * Esta interface representa o serviço que todos os controladores
 * devem ser capazes de executar
 */
public interface ICtrl {
	
	/**
	 * Método para informar qual foi o controlador que demandou
	 * a execução do controlador corrente. A esse vamos chamar
	 * de Controlador Pai. 
	 * 
	 * Ex: CtrlPrograma --- acionou ---> CtrlIncluirPessoa
	 *     então CtrlPrograma é o CtrlPai de CtrlIncluirPessoa
	 *     
	 * @return referência para o controlador pai
	 */
	public abstract ICtrl getCtrlPai();
	
	/**
	 * Informa o status de execução do controlador
	 * @return
	 */
	public abstract StatusExecucao getStatus();
	
	/**
	 * Executa os procedimentos para finalização do caso de uso
	 */
	public abstract void finalizar();
	
	/**
	 * Retorna o bem tangível produzido pelo caso de uso ao 
	 * seu final
	 * @return
	 */
	public abstract Object getBemTangivel();
	
	/**
	 * Recebe a notificação que um controlador filho foi encerrado
	 * @param ctrlFilho referência para o controlador que terminou de executar
	 */
	public abstract void finalizarFilho(ICtrl ctrlFilho);
}
