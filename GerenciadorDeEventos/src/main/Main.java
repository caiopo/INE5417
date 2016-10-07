package main;

import model.curso.Evento;
import model.db.Database;
import view.CadastroEvento;
import view.TelaInicial;

public class Main {

	public static void main(String[] args) {

		Evento evento = CadastroEvento.cadastroEvento();

		Database.init(evento.getNome());

		new TelaInicial();
	}
}
