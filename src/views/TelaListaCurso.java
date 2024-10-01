package views;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controllers.CursoController;
import model.entities.Curso;

public class TelaListaCurso extends JFrame {

    private TelaCadastroCurso telaCadastroCurso;
    private CursoController cursoController;
    
    // Components
    JTable table;
    JLabel labelTitulo;

    public TelaListaCurso(TelaCadastroCurso tela) {
        this.telaCadastroCurso = tela;
        this.cursoController = new CursoController();
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
		labelTitulo.setLocation(90, 30);
		labelTitulo.setSize(250, 30);
		
		DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Curso", "Periodo" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Desabilita a edição das células
            }
        };
        
        List<Curso> cursos = cursoController.findAll();
        cursos.forEach(c -> {
        	tableModel.addRow(new Object[] { c.getId(), c.getNome(), c.getPeriodo() });
        });
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
     	scrollPane.setSize(400, 300);
	    scrollPane.setLocation(90, 80);
        
        // Listener para a tabela
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableMouseListener(e);
        	}
        });
        
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
    
    
    private void tableMouseListener(MouseEvent e) {
    	if (e.getClickCount() == 2) {
    		 int selectedRow = table.getSelectedRow();
    	     if (selectedRow != -1) { // Verifica se há uma linha selecionada
    	         Integer id = (Integer) table.getValueAt(selectedRow, 0);
    	         String curso = (String) table.getValueAt(selectedRow, 1);
    	         String periodo = (String) table.getValueAt(selectedRow, 2);
    	            
    	         this.telaCadastroCurso.loadCurso(new Curso(id, curso, periodo));
    	         this.dispose();
    	         this.telaCadastroCurso.setVisible(true);
    	     } else {
    	         JOptionPane.showMessageDialog(null, "Nenhum curso selecionado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
    	     }
    	}
    }
    
    // Getters e Setters
	public TelaCadastroCurso getTelaCadastroCurso() {
		return telaCadastroCurso;
	}

	public void setTelaCadastroCurso(TelaCadastroCurso telaCadastroCurso) {
		this.telaCadastroCurso = telaCadastroCurso;
	}

	public CursoController getCursoController() {
		return cursoController;
	}

	public void setCursoController(CursoController cursoController) {
		this.cursoController = cursoController;
	}
    
    
}
