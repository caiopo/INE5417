package model.pessoa;

import model.id.Identificador;

public abstract class Pessoa {

	private String nome;
	private Identificador id;

	public Pessoa(String nome, Identificador id) {
		this.nome = nome;
		this.id = id;
	}

	public boolean equals(Pessoa outra) {
		return nome.equals(outra.nome) && id.get().equals(outra.id.get());
	}
	
	@Override
	public String toString() {
		return String.format("Pessoa(nome=%s, ID=%s)", nome, id);
	}
}
