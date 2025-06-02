package controller;

import model.Aluno;

import model.ModelException;
import model.dao.DaoAluno2;
import viewer.JanelaExcluirAluno;

public class CtrlExcluirAluno extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	
	private JanelaExcluirAluno  janela;
	private Aluno aluno;
	
	//
	// MÉTODOS
	//
	public CtrlExcluirAluno(CtrlConsultarAlunos ctrl, Aluno a) {
		super(ctrl);
		this.janela = new JanelaExcluirAluno(this, a);
		this.janela.abrir();
		this.aluno = a;
	}

	
	public void excluirAluno() {
	
			try {
				DaoAluno2 dao = new DaoAluno2();
				dao.remover(this.aluno);
				this.janela.notificar("Objeto Aluno removido: " + this.aluno);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				this.janela.notificar(e.getMessage());
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
