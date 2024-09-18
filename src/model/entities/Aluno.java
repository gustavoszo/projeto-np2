package model.entities;

import java.util.Date;

import java.util.Date;

public class Aluno {
	
	private Integer id;
	private String nome;
	private String cpf;
	private Date dtNascimento;
	private Curso curso;
	
	public Aluno() {}
	
	public Aluno(Integer id, String nome, String cpf, Date dtNascimento, Curso curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
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
