package model.services;

import model.dao.ProfessorDao;
import model.entities.Professor;

public class ProfessorService {
	
	private ProfessorDao professorDao = new ProfessorDao();
	
	public void save(Professor professor) {
		if (professor.getId() == null) {
			professorDao.insert(professor);
		} else {
			professorDao.update(professor);
		}
	}
	
	public Professor findById(Professor professor) {
		return professorDao.findById(String.valueOf(professor.getId()));
	}
	
	public void delete(Professor professor) {
		professorDao.deleteById(String.valueOf(professor.getId()));
	}

	
}
