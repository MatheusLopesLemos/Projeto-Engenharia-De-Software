package controller;

abstract public class CtrlAbstrato implements ICtrl {
	
	/**
	 * Referência para o controlador pai (aquele que demandou
	 * a execução do controlador corrente
	 */
	final private ICtrl     ctrlPai;
	private StatusExecucao  status;
	
	/**
	 * Construtor do CtrlAbstrato. Para que todo controlador
	 * no momento da sua instanciação tenha que passar a referência
	 * do seu controlador pai, criamos esse metodo e todas as 
	 * especializações deverão seguir esse padrão
	 * @param c
	 */
	public CtrlAbstrato(ICtrl c) {
		this.ctrlPai = c;
		this.status = StatusExecucao.EM_EXECUCAO;
	}

	@Override
	public ICtrl getCtrlPai() {
		return this.ctrlPai;
	}

	@Override
	public StatusExecucao getStatus() {
		return this.status;
	}
	
	@Override
	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
	}
	
	public void setStatus(StatusExecucao status) {
		this.status = status;
	}
	

}
