package view;

import controller.ICtrl;

public interface IViewer {
	/**
	 * Método para informar qual é o controlador de caso de uso 
	 * vinculado ao Viewer
	 * @return
	 */
	public abstract ICtrl getCtrl();
	/**
	 * Método que todo viewer tem para exibir um texto de notificação
	 * @param textoDeNotificacao
	 */
	public abstract void  notificar(String textoDeNotificacao);
	/**
	 * Método que define o que precisa ser feito para finalizar o viewer
	 */
	public abstract void  finalizar();
	/**
	 * Método que define o que precisa ser feito para o viewer ser 
	 * apresentado ao usuário 
	 */
	public abstract void  apresentar();
}
