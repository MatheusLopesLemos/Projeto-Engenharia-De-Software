package controller;

import view.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato{
	
	private JanelaPrincipal            janela;
	
	public CtrlPrograma() {
		// chamada ao construtor da superclasse (CtrlAbstrato). No
		// caso do CtrlPrograma, ele não tem um CtrlPai.
		super(null);
		this.janela = new JanelaPrincipal(this);
	}
		
//		public void iniciarIncluir() {
//			// Verificando se o caso de uso não está em execução
//			if (this.ctrlIncluir == null)
//				// Se não estiver, inicio a execução do caso de uso
//				this.ctrlIncluir = new CtrlIncluir(this);
//			else
//				// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
//				this.janela.notificar("Você já iniciou a funcionalidade de Incluir");
//		}
	
//		public void iniciarAlterar() {
//			// Verificando se o caso de uso não está em execução
//			if (this.ctrlAlterar == null)
//				// Se não estiver, inicio a execução do caso de uso
//				this.ctrlAlterar = new CtrlAlterar(this);
//			else
//				// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
//				this.janela.notificar("Você já iniciou a funcionalidade de Alteração");
//		}
	
//		public void iniciarExcluir() {
//			// Verificando se o caso de uso não está em execução
//			if (this.ctrlExcluir == null)
//				// Se não estiver, inicio a execução do caso de uso
//				this.ctrlExcluir = new CtrlExcluir(this);
//			else
//				// Se já estou executando o caso de uso, aviso que a funcionalidade está rodando
//				this.janela.notificar("Você já iniciou a funcionalidade de Exclusão");	
//		}
	
//		public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
//			if(ctrlFilho instanceof CtrlIncluir)			
//				this.ctrlIncluir = null;
//		}
	
		public void finalizar() {
			this.janela.notificar("Encerrando o programa!");
			this.janela.finalizar();
			System.exit(0);
		}
	
		public Object getBemTangivel() {
			return null;
		}
	
		public static void main(String[] args) {
			new CtrlPrograma();
		}
				
}
