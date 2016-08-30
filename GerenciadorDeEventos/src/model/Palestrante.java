package model;

import others.CPF;

public class Palestrante extends Participante {

	public Palestrante(String nome, CPF cpf) {
		super(nome, cpf);
	}

	public Palestrante(String nome, String matricula) {
		super(nome, matricula);
	}
	
}
