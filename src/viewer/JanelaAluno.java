package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlAbstrato;
import controller.CtrlAlterarAluno;
import controller.CtrlIncluirAluno;
import model.Aluno;

public class JanelaAluno extends JanelaAbstrata {
	//
	// ATRIBUTOS
	//
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfData;
	private JTextField tfEndereco;
	private JTextField tfTelefone;

	/**
	 * Create the frame.
	 */
	public JanelaAluno(CtrlAbstrato c) {
		super(c);
		setTitle("Janela Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(28, 26, 46, 14);
		contentPane.add(lblNewLabel);

		tfCpf = new JTextField();
		tfCpf.setBounds(72, 23, 160, 20);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(28, 67, 46, 14);
		contentPane.add(lblNewLabel_1);

		tfNome = new JTextField();
		tfNome.setBounds(72, 64, 293, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Data nascimento:");
		lblNewLabel_2.setBounds(28, 106, 84, 14);
		contentPane.add(lblNewLabel_2);

		tfData = new JTextField();
		tfData.setBounds(128, 103, 153, 20);
		contentPane.add(tfData);
		tfData.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpf = tfCpf.getText();
				String nome = tfNome.getText();
				String endereco = tfEndereco.getText();
				String data = tfData.getText();
				String telefone = tfTelefone.getText();
			

				// Solicito ao controlador do caso de uso que faça a inclusão do aluno
				if (getCtrl() instanceof CtrlIncluirAluno) {
					CtrlIncluirAluno ctrl = (CtrlIncluirAluno) getCtrl();
					ctrl.incluirAluno(cpf, nome, data, endereco, telefone);
				}
				else if (getCtrl() instanceof CtrlAlterarAluno) {
					CtrlAlterarAluno ctrl = (CtrlAlterarAluno) getCtrl();
					ctrl.editarAluno(cpf, nome, data, endereco, telefone);
				}
			}
		}); 
		btOk.setBounds(71, 227, 89, 23);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().finalizar();
			}
		});
		btCancelar.setBounds(208, 227, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblNewLabel_2_1 = new JLabel("Telefone:");
		lblNewLabel_2_1.setBounds(28, 188, 58, 14);
		contentPane.add(lblNewLabel_2_1);
		// Para alimentar a combo box, solicitamos ao DaoCurso
		// que nos passe a referência de todos os cursos existentes


		JLabel lblNewLabel_2_2 = new JLabel("Endereço:");
		lblNewLabel_2_2.setBounds(28, 148, 58, 14);
		contentPane.add(lblNewLabel_2_2);

		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(89, 145, 192, 20);
		contentPane.add(tfEndereco);
		
		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(89, 185, 192, 20);
		contentPane.add(tfTelefone);

		// Torno a janela visível
		this.setVisible(true);
	}

	/**
	 * Método para limpar o formulário da Janela
	 */
	public void limparFormulario() {
		tfCpf.setText("");
		tfNome.setText("");
		tfData.setText("");
	}
	
	public void preencherDados(Aluno a) {
		tfCpf.setText(a.getCpf());
		tfTelefone.setText(a.getTelefone());
		tfData.setText(a.getDataNasc());
		tfEndereco.setText(a.getEndereco());
		tfNome.setText(a.getNome());
	}
}