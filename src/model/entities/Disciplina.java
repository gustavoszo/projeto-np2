package model.entities;

public class Disciplina {
	
	private Integer id;
	private String nome;
	private int cargaHoraria;
	private Curso curso;
	
	public Disciplina() {}
	
	public Disciplina(Integer id, String nome, int cargaHoraria, Curso curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return this.nome; 
	}

}
