package controller;

import model.Aluno;
import model.dao.DaoAluno;
import model.dao.DaoAluno2;
import viewer.JanelaConsultarAlunos;

public class CtrlConsultarAlunos extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	private JanelaConsultarAlunos  janela;
	private CtrlIncluirAluno ctrlIncluirAluno;
	private CtrlExcluirAluno ctrlExcluirAluno;
	private CtrlAlterarAluno ctrlAlterarAluno;
			
	//
	// MÉTODOS
	//
	public CtrlConsultarAlunos(CtrlPrograma c) {
		super(c);
		this.iniciar();
		this.ctrlAlterarAluno = null;
		this.ctrlExcluirAluno = null;
		this.ctrlIncluirAluno = null;
	}
	


	public void iniciar() {
		DaoAluno2 dao = new DaoAluno2();
		Aluno[] listaAlunos = dao.consultarTodos();
		this.janela = new JanelaConsultarAlunos(this, listaAlunos);
		this.janela.abrir();
	}
	
	
	
	public void iniciarIncluirAluno() {
		if(this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
	}
	

	
	public void iniciarCtrlExcluirAluno(Aluno a) {
		if(this.ctrlExcluirAluno == null)
			this.ctrlExcluirAluno = new CtrlExcluirAluno(this,a);
	}

	public void iniciarCtrlAlterarAluno(Aluno a) {
		if(this.ctrlAlterarAluno == null)
			this.ctrlAlterarAluno = new CtrlAlterarAluno(this,a);
	}
	
	public void informarEncerramentoDeCtrlAlterarAluno() {
	

	}



	@Override
	public void finalizar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		this.getCtrlPai().finalizarFilho(this);
	}



	@Override
	public Object getBemTangivel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void finalizarFilho(ICtrl filho) {
		if (filho instanceof CtrlIncluirAluno){
			DaoAluno2 dao = new DaoAluno2();
			Aluno[] lista = dao.consultarTodos();
			this.janela.atualizarDados(lista);
			this.ctrlIncluirAluno = null;
		}
		else if(filho instanceof CtrlAlterarAluno) {
			DaoAluno2 dao = new DaoAluno2();
			Aluno[] lista = dao.consultarTodos();
			this.janela.atualizarDados(lista);
			this.ctrlAlterarAluno = null;	
		}
		else if(filho instanceof CtrlExcluirAluno) {
			DaoAluno2 dao = new DaoAluno2();
			Aluno[] lista = dao.consultarTodos();
			this.janela.atualizarDados(lista);
			this.ctrlExcluirAluno = null;
		}
		
		
	}
	
	
	
	
}
