package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.Db;
import DB.DbException;
import model.entities.Curso;

public class CursoDao implements EntityDao<Curso> {
	
	private Connection connection;
	
	public CursoDao() {
		this.connection = Db.getConnection();
	}

	@Override
	public void insert(Curso obj) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO cursos(nome, periodo) VALUES(?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, obj.getNome());
			preparedStatement.setString(2, obj.getPeriodo());
			
			int rowsAffected = preparedStatement.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					obj.setId(resultSet.getInt(1));
				}
			} else {
				throw new DbException("Erro inesperado. Nehuma linha alterada");
			}
			
		} catch (SQLException e) {
			throw new DbException("Ocorreu um erro ao salvar o curso: " + e.getMessage());
		} finally {
			Db.closeStatement(preparedStatement);
		}
		
	}

	@Override
	public void update(Curso obj) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("UPDATE cursos "
					+ "SET nome = ?, periodo = ? "
					+ "WHERE id_curso = ?"
					);
			preparedStatement.setString(1, obj.getNome());
			preparedStatement.setString(2, obj.getPeriodo());
			preparedStatement.setInt(3, obj.getId());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException("Ocorreu um erro ao atualizar o curso: " + e.getMessage());
		} finally {
			Db.closeStatement(preparedStatement);
		}
		
	}

	@Override
	public List<Curso> findAll() {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM cursos");
			resultSet = preparedStatement.executeQuery();
			
			List<Curso> cursos = new ArrayList<Curso>();
			while (resultSet.next()) {
				Curso curso = new Curso();
				curso.setId(resultSet.getInt("id_curso"));
				curso.setNome(resultSet.getString("nome"));
				curso.setPeriodo(resultSet.getString("periodo"));
				cursos.add(curso);
			}
			return cursos;
			
		} catch (SQLException e) {
			throw new DbException("Ocorreu um erro ao listar os cursos: " + e.getMessage());
		} finally {
			Db.closeResultSet(resultSet);
			Db.closeStatement(preparedStatement);
		}
	}

	@Override
	public Curso findById(String id) {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM cursos WHERE id_curso = ?");
			preparedStatement.setInt(1, Integer.parseInt(id));
			resultSet = preparedStatement.executeQuery();
			
			Curso curso = new Curso();
			if (resultSet.next()) {
				curso.setId(resultSet.getInt("id_curso"));
				curso.setNome(resultSet.getString("nome"));
				curso.setPeriodo(resultSet.getString("periodo"));
			}
			return curso;
			
		} catch (SQLException e) {
			throw new DbException("Ocorreu um erro ao buscar o curso: " + e.getMessage());
		} finally {
			Db.closeResultSet(resultSet);
			Db.closeStatement(preparedStatement);
		}
	}

	@Override
	public void deleteById(String id) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM cursos WHERE id_curso = ?");
			preparedStatement.setInt(1, Integer.parseInt(id));
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException("Ocorreu um erro ao apagar o curso: " + e.getMessage());
		} finally {
			Db.closeStatement(preparedStatement);
		}
		
	}
	
}
