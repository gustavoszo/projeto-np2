package model.dao;

import java.sql.Connection;
import java.util.List;

import DB.Db;
import model.entities.Disciplina;

public class DisciplinaDao implements EntityDao<Disciplina> {
	
private Connection connection;
	
	public void DisciplinaDao() {
		this.connection = Db.getConnection();
	}

	@Override
	public void insert(Disciplina obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Disciplina obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Disciplina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disciplina findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
