package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.CtrlConsultarAlunos;
import model.Aluno;

public class JanelaConsultarAlunos extends JanelaAbstrata {
	//
	// ATRIBUTOS
	//
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private Aluno[] listaAlunos;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarAlunos(CtrlConsultarAlunos c, Aluno[] lstAlunos) {
		super(c);
		setTitle("Alunos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.atualizarDados(lstAlunos);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Pede ao controlador que o caso de uso seja encerrado
				getCtrl().encerrar();
			}
		});
		btSair.setBounds(317, 227, 89, 23);
		contentPane.add(btSair);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlConsultarAlunos ctrl = (CtrlConsultarAlunos)getCtrl();
				ctrl.iniciarIncluirAluno();
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno a = obterLinhaSelecionada();
				if(a == null) {
					notificar("objeto não selecionado");
					return;
				}
				CtrlConsultarAlunos ctrl = (CtrlConsultarAlunos)getCtrl();
				ctrl.iniciarCtrlExcluirAluno(a);
				
			}
		});
		btnNewButton_1.setBounds(109, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Alterar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno a = obterLinhaSelecionada();
				if(a == null) {
					notificar("objeto não selecionado");
					return;
				}
				CtrlConsultarAlunos ctrl = (CtrlConsultarAlunos)getCtrl();
				ctrl.iniciarCtrlAlterarAluno(a);
			}
		});
		btnNewButton_1_1.setBounds(208, 227, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		this.setVisible(true);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados(Aluno[] lstAlunos) {
		this.listaAlunos = lstAlunos;
		HelperTableModel h = new HelperTableModel(lstAlunos);
		if(this.tabela == null)
			this.tabela = new JTable(h.getTableModel());
		else 
			this.tabela.setModel(h.getTableModel());
	}

	/**
	 * Retorna qual objeto 
	 * @return
	 */
	public Aluno obterLinhaSelecionada() {
		int numLinhaSelecionada = this.tabela.getSelectedRow();
		if(numLinhaSelecionada != -1)
			return this.listaAlunos[numLinhaSelecionada];
		return null;
	}
}