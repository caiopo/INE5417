package model.pessoa;

import model.id.Identificador;

public class Participante extends Pessoa {

	public Participante(String nome, Identificador id) {
		super(nome, id);
	}
	
	@Override
	public String toString() {
		return super.toString().replace("Pessoa", "Participante");
	}
	
}
