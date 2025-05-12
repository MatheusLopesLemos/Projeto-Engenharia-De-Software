package controller;

public enum StatusExecucao {
	EM_EXECUCAO("Caso de Uso em Execução"),
	EM_ESPERA("Caso de Uso em Espera por ter iniciado outro Caso de Uso"),
	SUSPENSO("Caso de Uso provisoriamente suspenso"),
	ENCERRADO("Caso de Uso encerrado");
	
	
	final private String descricao;
	
	private StatusExecucao(String desc) {
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String toString() {
		return this.descricao;
	}
	
}
