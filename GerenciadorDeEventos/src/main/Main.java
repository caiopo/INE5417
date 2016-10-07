package main;

import model.curso.Evento;
import view.CadastroEvento;
import view.EditaLocal;
import view.TelaInicial;
import view.VisualizarLocal;

public class Main {

	public static void main(String[] args) {

		VisualizarLocal.visualizar();
//		Evento evento = CadastroEvento.cadastroEvento();
//
//		Evento.setInstance(evento);
//
		new TelaInicial();
	}
}
