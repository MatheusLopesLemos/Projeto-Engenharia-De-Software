package controller;

import model.Aluno;

import model.ModelException;
import model.dao.DaoAluno;
import model.dao.DaoAluno2;
import viewer.JanelaAluno;

public class CtrlAlterarAluno extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	
	private JanelaAluno  janela;
	private Aluno aluno;
	
	//
	// MÉTODOS
	//
	public CtrlAlterarAluno(CtrlConsultarAlunos ctrl, Aluno a) {
		super(ctrl);
		this.janela = new JanelaAluno(this);
		this.janela.abrir();
		this.aluno = a;
		this.janela.preencherDados(a);
	}

	
	public void editarAluno(String c, String n, String d, String e, String t) {
		try {
			
			this.aluno.setCpf(c);
			this.aluno.setNome(n);
			this.aluno.setTelefone(t);
			this.aluno.setDataNasc(d);
			this.aluno.setEndereco(e);
			DaoAluno2 dao = new DaoAluno2();
			dao.alterar(this.aluno);
			this.janela.notificar("Objeto Aluno alterado: " + this.aluno);
		} catch(ModelException me) {
			this.janela.notificar(me.getMessage());
		}
		this.finalizar();
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
		return this.aluno;
	}


	@Override
	public void finalizarFilho(ICtrl ctrlFilho) {
		// TODO Auto-generated method stub
		
	}
		
}
