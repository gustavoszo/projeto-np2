package model.entities;

public class Curso {
	
	private Integer id;
	private String nome;
	private String periodo;
	
	public Curso() {}
	
	public Curso(Integer id, String nome, String periodo) {
		super();
		this.id = id;
		this.nome = nome;
		this.periodo = periodo;
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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		return this.nome + " | " + this.periodo;
	}

}
