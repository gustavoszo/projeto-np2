package model.services;

import model.dao.CursoDao;
import model.entities.Curso;

public class CursoService {

	private CursoDao cursoDao = new CursoDao();
	
	public void save(Curso curso) {
		if (curso.getId() == null) {
			cursoDao.insert(curso);
		} else {
			cursoDao.update(curso);
		}
	}
	
	public Curso findById(Curso curso) {
		return cursoDao.findById(String.valueOf(curso.getId()));
	}
	
	public void delete(Curso curso) {
		cursoDao.deleteById(String.valueOf(curso.getId()));
	}
 	
}
