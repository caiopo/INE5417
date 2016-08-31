package model.pessoa;

import model.id.Identificador;

public class Palestrante extends Participante {

	public Palestrante(String nome, Identificador id) {
		super(nome, id);
	}

	@Override
	public String toString() {
		return super.toString().replace("Participante", "Palestrante");
	}
}
