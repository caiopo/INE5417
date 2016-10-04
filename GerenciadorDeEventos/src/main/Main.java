package main;

import model.curso.Evento;
import view.CadastroEvento;
import view.TelaInicial;

public class Main {

	public static void main(String[] args) {

		Evento evento = CadastroEvento.cadastroEvento();

		Evento.setInstance(evento);

		new TelaInicial();
	}
}
