package model;

import others.CPF;

public abstract class Pessoa {

	private String nome = null, matricula = null;
	private CPF cpf = null;

	public Pessoa(String nome, CPF cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Pessoa(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}
	
	
}
