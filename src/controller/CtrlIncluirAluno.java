package controller;

import model.Aluno;
import model.ModelException;
import model.dao.DaoAluno;
import viewer.JanelaAluno;

public class CtrlIncluirAluno extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	
	private JanelaAluno  janela;
	private Aluno aluno;
	
	//
	// MÉTODOS
	//
	public CtrlIncluirAluno(CtrlPrograma ctrl) {
		super(ctrl);
		this.janela = new JanelaAluno(this);
		this.janela.abrir();
	}

	
	public void incluirAluno(String c, String n, String d, String e, String t) {
		try {
			
			this.aluno = new Aluno(c, n, d, e, t);
			DaoAluno dao = new DaoAluno();
			dao.incluir(this.aluno);
			this.janela.notificar("Objeto Aluno instanciado: " + this.aluno);
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
