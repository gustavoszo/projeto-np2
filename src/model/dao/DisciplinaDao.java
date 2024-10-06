package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Db;
import DB.DbException;
import model.entities.Curso;
import model.entities.Disciplina;
import model.services.CursoService;

public class DisciplinaDao implements EntityDao<Disciplina> {
	
	private Connection connection;
	private CursoService cursoService;
	
	public DisciplinaDao() {
		this.connection = Db.getConnection();
		this.cursoService = new CursoService();
	}

	@Override
	public void insert(Disciplina obj) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO disciplinas(nome, carga_horaria, id_curso) " +
					"VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS		
			);
			preparedStatement.setString(1, obj.getNome());
			preparedStatement.setInt(2, obj.getCargaHoraria());
			preparedStatement.setInt(3, obj.getCurso().getId());
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					int id = resultSet.getInt(1);
					obj.setId(id);
				}
				
			} else {
				throw new DbException("Erro inesperado. Nenhuma linha alterada");
			}
			
			
		} catch(SQLException e) {
			throw new DbException("Ocorreu um erro ao salvar a disciplina: " + e.getMessage());
		}
		
	}

	@Override
	public void update(Disciplina obj) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE disciplinas "
					+ "SET nome = ?, carga_horaria = ?, id_curso = ? " +
					"WHERE id_disciplina = ?"		
			);
			preparedStatement.setString(1, obj.getNome());
			preparedStatement.setInt(2, obj.getCargaHoraria());
			preparedStatement.setInt(3, obj.getCurso().getId());
			preparedStatement.setInt(4, obj.getId());
			
			preparedStatement.executeUpdate();

		} catch(SQLException e) {
			throw new DbException("Ocorreu um erro ao salvar a disciplina: " + e.getMessage());
		}
		
	}

	@Override
	public List<Disciplina> findAll() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM disciplinas");
			resultSet = preparedStatement.executeQuery();
			
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			while(resultSet.next()) {
				Integer id_disciplina = resultSet.getInt("id_disciplina");
				String nome = resultSet.getString("nome");
				int cargaHoraria = resultSet.getInt("carga_horaria");
				String id_curso = String.valueOf(resultSet.getInt("id_curso"));
				Curso curso = cursoService.findById(id_curso);
				
				disciplinas.add(new Disciplina(id_disciplina, nome, cargaHoraria, curso));
			}
			return disciplinas;
			
		} catch(SQLException e) {
			throw new DbException("Ocorreu um erro ao salvar a disciplina: " + e.getMessage());
		}
	}

	@Override
	public Disciplina findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM disciplinas WHERE id_disciplina = ?");
			preparedStatement.setInt(1, Integer.parseInt(id));
			
			preparedStatement.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException("Ocorreu um erro ao apagar a disciplina: " + e.getMessage());
		}
		
	}
	
	
}
