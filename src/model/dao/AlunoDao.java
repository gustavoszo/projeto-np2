package model.dao;

import java.sql.Connection;
import java.util.List;
import DB.Db;
import model.entities.Aluno;

public class AlunoDao implements EntityDao<Aluno> {
	
	private Connection connection;
	
	public void AlunoDaoImpl() {
		this.connection = Db.getConnection();
	}

	@Override
	public void insert(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
