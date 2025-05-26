package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import  controller.CtrlPrograma;


public class JanelaPrincipal extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma c) {
		super(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAluno.setBounds(40, 25, 100, 50);
		contentPane.add(btnAluno);
		
		JButton btnTurma = new JButton("Turma");
		btnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTurma.setBounds(170, 25, 100, 50);
		contentPane.add(btnTurma);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.setBounds(300, 25, 100, 50);
		contentPane.add(btnDisciplina);
		
		JButton btnMatricula = new JButton("Matricula");
		btnMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMatricula.setBounds(40, 86, 100, 50);
		contentPane.add(btnMatricula);
		
		JButton btnProva = new JButton("Prova");
		btnProva.setBounds(170, 86, 100, 50);
		contentPane.add(btnProva);
		
		JButton btnRealiza = new JButton("Realiza");
		btnRealiza.setBounds(300, 86, 100, 50);
		contentPane.add(btnRealiza);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.setBounds(40, 150, 100, 50);
		contentPane.add(btnProfessor);
		
		JButton btnDepartamento = new JButton("Departamento");
		btnDepartamento.setBounds(170, 150, 100, 50);
		contentPane.add(btnDepartamento);
		
		JButton btnAlocado = new JButton("Alocado");
		btnAlocado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlocado.setBounds(300, 150, 100, 50);
		contentPane.add(btnAlocado);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(170, 220, 100, 25);
		contentPane.add(btnSair);
	}
}
