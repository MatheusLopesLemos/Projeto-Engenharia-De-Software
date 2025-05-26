package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ICtrl;

public class JanelaAbstrata extends JFrame implements IViewer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	// ATRIBUTOS DE RELACIONAMENTO
	//
	// Todo viewer deve ter um atributo para guardar a referência
	// para o objeto Controller com quem se relaciona. No construtor,
	// ele deve receber por parâmetro a referência de seu controlador. 
	// Essa referência vai ser utilizada nos métodos 'actionPerformed'
	// para enviar mensagens para o controlador. 
	// a referência, ele deve receber em seu 
	//
	final private ICtrl ctrl;
	
	public JanelaAbstrata(ICtrl c) {
		super();
		this.ctrl = c;
	}

	@Override
	public ICtrl getCtrl() {
		return this.ctrl;
	}

	@Override
	public void notificar(String textoDeNotificacao) {
		JOptionPane.showMessageDialog(null, textoDeNotificacao);
	}

	@Override
	public void fechar() {
		this.setVisible(false);		
	}

	@Override
	public void abrir() {
		this.setVisible(true);		
	}
}
