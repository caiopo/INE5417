package model.pessoa;

import others.Identificador;

public abstract class Pessoa {

	private String nome = null;
	private Identificador id = null;

	public Pessoa(String nome, Identificador id) {
		this.nome = nome;
		this.id = id;
	}
}
