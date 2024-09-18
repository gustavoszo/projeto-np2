package views;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class TelaCadastroCurso extends JFrame {

    private TelaHome home;

    JButton btnSalvar, btnLimpar, btnConsultar, btnDeletar;
    JLabel labelTitulo;
    JLabel labelCurso;
    JLabel labelPeriodo;
    JRadioButton radioManha, radioNoite, radioTarde;
    ButtonGroup groupPeriodo;
    JComboBox<String> listCursos;

    public TelaCadastroCurso(TelaHome home) {
        this.home = home;
        initComponents();
    }

    public void initComponents() {
        setResizable(false);
        setSize(500, 400);
        setLocation(100, 100);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        labelTitulo = new JLabel("CADASTRO DE CURSO");
        labelTitulo.setLocation(20, 10);
        labelTitulo.setSize(250, 20);

        labelCurso = new JLabel("Selecione o curso");
        labelCurso.setLocation(35, 65);
        labelCurso.setSize(95, 20);

        labelPeriodo = new JLabel("Periodo");
        labelPeriodo.setLocation(35, 150);
        labelPeriodo.setSize(80, 20);

        String[] cursos = { "Administração de Empresas", "Bio Medicina", "Ciências Biológicas", "Ciencias da Computação",
                "Direito", "Educação Física", "Farmacologia", "Rede de Computadores", "Sistemas de Informações" };

        listCursos = new JComboBox<String>(cursos); // Parâmetro de tipo String
        listCursos.setLocation(35, 90);
        listCursos.setSize(150, 30);

        radioManha = new JRadioButton("Manhã", false);
        radioManha.setLocation(35, 170);
        radioManha.setSize(60, 30);

        radioTarde = new JRadioButton("Tarde", false);
        radioTarde.setLocation(105, 170);
        radioTarde.setSize(60, 30);

        radioNoite = new JRadioButton("Noite", false);
        radioNoite.setLocation(170, 170);
        radioNoite.setSize(60, 30);

        groupPeriodo = new ButtonGroup();
        groupPeriodo.add(radioManha);
        groupPeriodo.add(radioTarde);
        groupPeriodo.add(radioNoite);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setLocation(50, 310);
        btnSalvar.setSize(80, 30);
        btnSalvar.setBackground(new Color(150, 220, 255));

        btnLimpar = new JButton("Limpar");
        btnLimpar.setLocation(150, 310);
        btnLimpar.setSize(80, 30);
        btnLimpar.setBackground(new Color(150, 220, 255));

        btnConsultar = new JButton("Consultar");
        btnConsultar.setSize(80, 30);
        btnConsultar.setLocation(250, 310);
        btnConsultar.setBackground(new Color(150, 220, 255));

        btnConsultar.addActionListener(e -> {
            new TelaListaCurso(this).setVisible(true);
            this.setVisible(false);
        });

        btnDeletar = new JButton("Deletar");
        btnDeletar.setSize(80, 30);
        btnDeletar.setLocation(350, 310);
        btnDeletar.setBackground(new Color(150, 220, 255));
        btnDeletar.setVisible(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TelaCadastroCurso tela = (TelaCadastroCurso) e.getWindow();
                tela.home.setVisible(true);
                tela.dispose();
            }
        });

        add(labelTitulo);
        add(labelCurso);
        add(labelPeriodo);
        add(listCursos);
        add(radioManha);
        add(radioTarde);
        add(radioNoite);
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