package model.dao;

import java.sql.Connection;
import java.util.List;

import DB.Db;
import model.entities.Professor;

public class ProfessorDao implements EntityDao<Professor> {
	
	private Connection connection;
	
	public void AlunoDaoImpl() {
		this.connection = Db.getConnection();
	}

	@Override
	public void insert(Professor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Professor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
