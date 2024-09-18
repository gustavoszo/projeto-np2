package model.services;

import model.dao.AlunoDao;
import model.entities.Aluno;

public class AlunoService {
	
	private AlunoDao alunoDao = new AlunoDao();
	
	public void save(Aluno aluno) {
		if (aluno.getId() == null) {
			alunoDao.insert(aluno);
		} else {
			alunoDao.update(aluno);
		}
	}
	
	public Aluno findById(Aluno aluno) {
		return alunoDao.findById(String.valueOf(aluno.getId()));
	}
	
	public void delete(Aluno aluno) {
		alunoDao.deleteById(String.valueOf(aluno.getId()));
	}

}
