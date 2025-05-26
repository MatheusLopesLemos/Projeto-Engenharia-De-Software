package controller;

import model.Aluno;
import model.dao.DaoAluno;
import viewer.JanelaConsultarAlunos;

public class CtrlConsultarAlunos extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	private JanelaConsultarAlunos  janela;
	private CtrlIncluirAluno ctrlIncluirAluno;
	//private CtrlExcluirAluno ctrlExcluirAluno;
	//private CtrlAlterarAluno ctrlAlterarAluno;
			
	//
	// MÉTODOS
	//
	public CtrlConsultarAlunos(CtrlPrograma c) {
		// O construtor da superclasse (CtrlAbstrato) vai guardar a referência
		// do controlador pai (quem o chamou) e iniciar a execução do caso de
		// uso através do método 'iniciar' (veja o construtor da classe CtrlAbstrato)
		super(c);

	}
	

	/**
	 * Método que indica o que o controlador deverá executar no
	 * início de suas ações.
	 */
	public void iniciar() {
		DaoAluno dao = new DaoAluno();
		Aluno[] listaAlunos = dao.obterListaObjetos();
		this.janela = new JanelaConsultarAlunos(this, listaAlunos);
	}
	
	/**
	 * Método que indica o que o controlador deverá executar para
	 * concluir as ações do caso de uso.
	 */
	public void encerrar() {
		// Solicito o fechamento da janela
		this.janela.fechar();
		// Notifico ao controlador do programa que o caso de uso se encerrou
		CtrlPrograma ctrl = (CtrlPrograma)this.getCtrlPai(); 
		ctrl.informarFimDeConsultarAlunos();
	}
	
	public void iniciarIncluirAluno() {
		if(this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
	}
	
	public void informarEncerramentoDeCtrlIncluirAluno() {
		DaoAluno dao = new DaoAluno();
		Aluno[] lista = dao.obterListaObjetos();
		this.janela.atualizarDados(lista);
		this.ctrlIncluirAluno = null;
	}
	
	public void iniciarCtrlExcluirAluno(Aluno a) {
		if(this.ctrlExcluirAluno == null)
			this.ctrlExcluirAluno = new CtrlExcluirAluno(this,a);
	}
	
	public void informarEncerramentoDeCtrlExcluirAluno() {
		DaoAluno dao = new DaoAluno();
		Aluno[] lista = dao.obterListaObjetos();
		this.janela.atualizarDados(lista);
		this.ctrlExcluirAluno = null;
	}
	
	public void iniciarCtrlAlterarAluno(Aluno a) {
		if(this.ctrlAlterarAluno == null)
			this.ctrlAlterarAluno = new CtrlAlterarAluno(this,a);
	}
	
	public void informarEncerramentoDeCtrlAlterarAluno() {
		DaoAluno dao = new DaoAluno();
		Aluno[] lista = dao.obterListaObjetos();
		this.janela.atualizarDados(lista);
		this.ctrlAlterarAluno = null;

	}
}
