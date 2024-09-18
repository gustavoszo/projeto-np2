package views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class TelaCadastroAluno extends JFrame {
	
	private TelaHome home;

	private JLabel nome, cpf, email, dataNascimento, idCurso;
	private JTextField nomeField, cpfField, emailField, dataNascField;
	private JList<String> listaCursos;
	private JButton btnSalvar, btnLimpar, btnConsultar, btnDeletar;

	public TelaCadastroAluno(TelaHome home) {
		this.home = home;
		initComponents();
	}
	
	private void initComponents() {
		setBounds(400, 250, 500, 400);
		getContentPane().setLayout(null);

		// Labels
		nome = new JLabel("Nome:");
		nome.setBounds(30, 30, 100, 25);

		cpf = new JLabel("CPF:");
		cpf.setBounds(30, 70, 100, 25);

		email = new JLabel("E-mail:");
		email.setBounds(30, 110, 100, 25);

		dataNascimento = new JLabel("Data de Nascimento:");
		dataNascimento.setBounds(30, 150, 150, 25);

		idCurso = new JLabel("Curso:");
		idCurso.setBounds(30, 190, 100, 25);

		// Text Fields
		nomeField = new JTextField();
		nomeField.setBounds(180, 30, 200, 25);

		cpfField = new JTextField();
		cpfField.setBounds(180, 70, 200, 25);

		emailField = new JTextField();
		emailField.setBounds(180, 110, 200, 25);

		dataNascField = new JTextField();
		dataNascField.setBounds(180, 150, 200, 25);

		// List
		listaCursos = new JList<>();
		listaCursos.setBounds(180, 190, 200, 100);

		// Buttons
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(30, 480, 100, 40);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(150, 480, 100, 40);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(270, 480, 100, 40);
		btnConsultar.addActionListener(e -> {
			this.setVisible(false);
			new TelaListaAluno(this).setVisible(true);
		});

		btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(390, 480, 100, 40);
		btnDeletar.setVisible(false);
		
		addWindowListener(new WindowAdapter() {
			 @Override
	         public void windowClosing(WindowEvent e) {
				 TelaCadastroAluno tela = (TelaCadastroAluno) e.getWindow();
	             tela.home.setVisible(true);
	             tela.dispose();
			 }
	     });

		getContentPane().add(nome);
		getContentPane().add(cpf);
		getContentPane().add(email);
		getContentPane().add(dataNascimento);
		getContentPane().add(idCurso);
		getContentPane().add(nomeField);
		getContentPane().add(cpfField);
		getContentPane().add(emailField);
		getContentPane().add(dataNascField);
		getContentPane().add(listaCursos);
		getContentPane().add(btnSalvar);
		getContentPane().add(btnConsultar);
		getContentPane().add(btnLimpar);
		getContentPane().add(btnDeletar);
	}

	public TelaHome getHome() {
		return home;
	}

	public void setHome(TelaHome home) {
		this.home = home;
	}
	
}
