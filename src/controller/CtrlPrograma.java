			
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_prjPOO");
	private static EntityManager        entityManager = entityManagerFactory.createEntityManager();
	private JanelaPrincipal            janela;
	private CtrlIncluirAluno ctrlIncluirAluno;
	
	

	public CtrlPrograma() {
		// chamada ao construtor da superclasse (CtrlAbstrato). No
		// caso do CtrlPrograma, ele não tem um CtrlPai.
		super(null);
		this.janela = new JanelaPrincipal(this);
		this.ctrlIncluirAluno = null;
	}
	
	public static void main(String[] args) {
		new CtrlPrograma();
	}
	
	public static EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return CtrlPrograma.entityManager;
	}
	
	
	public void iniciarIncluirAluno() {
	if (this.ctrlIncluirAluno == null)
		this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
	else		
		this.janela.notificar("Você já iniciou a funcionalidade de Incluir");
}

//public void iniciarAlterar() {
//	// Verificando se o caso de uso não está em execução
//	if (this.ctrlAlterar == null)
//		// Se não estiver, inicio a execução do caso de uso
//		this.ctrlAlterar = new CtrlAlterar(this);
//	else
//		// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
//		this.janela.notificar("Você já iniciou a funcionalidade de Alteração");
//}

//public void iniciarExcluir() {
//	// Verificando se o caso de uso não está em execução
//	if (this.ctrlExcluir == null)
//		// Se não estiver, inicio a execução do caso de uso
//		this.ctrlExcluir = new CtrlExcluir(this);
//	else
//		// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
//		this.janela.notificar("Você já iniciou a funcionalidade de Exclusão");	
//}

//public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
//	if(ctrlFilho instanceof CtrlIncluir)			
//		this.ctrlIncluir = null;
//}

	@Override
	public void finalizar() {
		this.janela.notificar("Encerrando o programa!");
		this.janela.fechar();
		System.exit(0);
	}

	@Override
	public Object getBemTangivel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void finalizarFilho(ICtrl filho) {
		// TODO Auto-generated method stub
		if (filho instanceof CtrlIncluirAluno)
			this.ctrlIncluirAluno = null;
		
	}
	
	

	
}
