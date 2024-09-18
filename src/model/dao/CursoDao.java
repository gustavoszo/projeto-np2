package model.dao;

import java.sql.Connection;
import java.util.List;

import DB.Db;
import model.entities.Curso;

public class CursoDao implements EntityDao<Curso> {
	
	private Connection connection;
	
	public void AlunoDaoImpl() {
		this.connection = Db.getConnection();
	}

	@Override
	public void insert(Curso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Curso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Curso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
