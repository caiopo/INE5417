package model;

import others.CPF;

public class Participante extends Pessoa {

	public Participante(String nome, CPF cpf) {
		super(nome, cpf);
	}

	public Participante(String nome, String matricula) {
		super(nome, matricula);
	}
	
}
