package views;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListaCurso extends JFrame {

    public TelaCadastroCurso telaCadastroCurso;
    JTable table;
    JLabel labelTitulo;

    public TelaListaCurso(TelaCadastroCurso tela) {
        this.telaCadastroCurso = tela;
        initComponents();
    }

    public void initComponents() {
        setTitle("Lista de cursos");
        setResizable(false);
        setSize(600, 500);
        setLocation(400, 250);
        setLayout(null);

        labelTitulo = new JLabel("Lista de cursos cadastrados");
        labelTitulo.setFont(new Font("calibri", Font.BOLD, 20));
		labelTitulo.setLocation(80, 150);
		labelTitulo.setSize(150, 30);

        table = new JTable(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID", "Curso", "Periodo"
            })
        );
        
        JScrollPane scrollPane = new JScrollPane(table);
     	scrollPane.setSize(350, 300);
	    scrollPane.setLocation(90, 80);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TelaListaCurso tela = (TelaListaCurso) e.getWindow();
                tela.telaCadastroCurso.setVisible(true);
                tela.dispose();
            }
        });

        add(labelTitulo);
        add(scrollPane);
    }
}
