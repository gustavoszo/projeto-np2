package views;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListaProfessor extends JFrame {

	public TelaCadastroProfessor telaCadastroProfessor;

	JTable table;
	JLabel labelTitulo;

	public TelaListaProfessor(TelaCadastroProfessor tela) {
		this.telaCadastroProfessor = tela;
		initComponents();
	}

	public void initComponents() {
	    setTitle("Lista de Professores");
	    setResizable(false);
	    setSize(600, 500);
	    setLocation(100, 100);

	    labelTitulo = new JLabel("Lista de professores");
	    labelTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
	    labelTitulo.setSize(250, 30);
	    labelTitulo.setLocation(195, 20);

	    table = new JTable(new DefaultTableModel(
	        new Object[][] {},
	        new String[] {"ID", "Nome", "CPF", "Email"}
	    ));

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setSize(350, 300);
	    scrollPane.setLocation(90, 80);

	    // Adicionando o listener para eventos de clique
	    table.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                System.out.println("Pronto");
	            }
	        }
	    });

	    add(labelTitulo);
	    add(scrollPane);

	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            TelaListaProfessor tela = (TelaListaProfessor) e.getWindow();
	            tela.dispose();
	            tela.telaCadastroProfessor.setVisible(true);
	        }
	    });

	    setLayout(null);

	}

}