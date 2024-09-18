package views;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.entities.Curso;

public class TelaCadastroDisciplina extends JFrame {

    private TelaHome home;
    
    JLabel labelTitulo, labelNome, labelCargaHoraria, labelCurso;
    JTextField txtNome, txtCargaHoraria;
    JComboBox<Curso> listaCurso;
    JButton btnSalvar, btnLimpar, btnConsultar, btnDeletar;

    public TelaCadastroDisciplina(TelaHome home) {
        this.home = home;
        initComponents();
    }

    public void initComponents() {
        setTitle("Cadastro de Disciplina");
        setSize(600, 500);
        setLocation(400, 250);
        setLayout(null);

        // Label Título
        labelTitulo = new JLabel("CADASTRO DE DISCIPLINA");
        labelTitulo.setBounds(30, 20, 300, 30);

        // Label e Campo Nome
        labelNome = new JLabel("Nome: ");
        labelNome.setBounds(30, 80, 120, 30);

        txtNome = new JTextField("");
        txtNome.setBounds(150, 80, 250, 30);

        // Label e Campo Carga Horária
        labelCargaHoraria = new JLabel("Carga Horária: ");
        labelCargaHoraria.setBounds(30, 130, 120, 30);

        txtCargaHoraria = new JTextField("");
        txtCargaHoraria.setBounds(150, 130, 250, 30);

        // Label e ComboBox Curso
        labelCurso = new JLabel("Curso:");
        labelCurso.setBounds(30, 180, 120, 30);

        listaCurso = new JComboBox<>();
        listaCurso.setBounds(150, 180, 250, 30);

        // Botões
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(30, 350, 100, 40);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(150, 350, 100, 40);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(270, 350, 100, 40);
        btnConsultar.addActionListener(e -> {
            this.setVisible(false);
            new TelaListaDisciplina(this).setVisible(true);
        });

        btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(390, 350, 100, 40);
        btnDeletar.setVisible(false);
        
        addWindowListener(new WindowAdapter() {
			 @Override
	         public void windowClosing(WindowEvent e) {
				 TelaCadastroDisciplina tela = (TelaCadastroDisciplina) e.getWindow();
	             tela.home.setVisible(true);
	             tela.dispose();
			 }
	     });

        // Adicionando os componentes
        add(labelTitulo);
        add(labelNome);
        add(txtNome);
        add(labelCargaHoraria);
        add(txtCargaHoraria);
        add(labelCurso);
        add(listaCurso);
        add(btnSalvar);
        add(btnLimpar);
        add(btnConsultar);
        add(btnDeletar);
    }

    public TelaHome getHome() {
        return home;
    }

    public void setHome(TelaHome home) {
        this.home = home;
    }
}