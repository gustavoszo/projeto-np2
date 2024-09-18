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

public class TelaListaDisciplina extends JFrame {

	public TelaCadastroDisciplina telaCadastroDisciplina;

	JLabel labelTitulo;
	JTable table;

	public TelaListaDisciplina(TelaCadastroDisciplina tela) {
		this.telaCadastroDisciplina = tela;
		initComponents();
	}

	public void initComponents() {
		setTitle("Lista de Disciplinas");
	  	setResizable(false);
	    setSize(600, 500);
	    setLocation(100, 100);

		labelTitulo = new JLabel("Lista de disciplinas");
		labelTitulo.setFont(new Font("calibri", Font.BOLD, 20));
		labelTitulo.setLocation(80, 150);
		labelTitulo.setSize(150, 30);

		table = new JTable(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"ID", "Nome", "Carga Horária", "Curso", "Professor"
			}
		));

		table.addMouseListener(new MouseAdapter() {
			@Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                System.out.println("Pronto");
	            }
	        }
	    });

		JScrollPane scrollPane = new JScrollPane(table);
	  	scrollPane.setSize(350, 300);
	    scrollPane.setLocation(90, 80);

		add(labelTitulo);
		add(scrollPane);

		setLayout(null);

		 addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            TelaListaDisciplina tela = (TelaListaDisciplina) e.getWindow();
	            tela.dispose();
	            tela.telaCadastroDisciplina.setVisible(true);
	        }
	    });
	}
}
