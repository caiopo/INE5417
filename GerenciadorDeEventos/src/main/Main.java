package main;

import model.db.Database;
import model.db.map.MapeadorLocal;
import model.local.Auditorio;
import model.local.Laboratorio;
import model.local.SalaDeAula;
import view.TelaInicial;

public class Main {

	public static void main(String[] args) {

		// Database.init(evento.getNome());

		Database.init("seccom");

		MapeadorLocal.put(new SalaDeAula("Sala1", 10));
		MapeadorLocal.put(new Laboratorio("Sala2", 10, 5));
		MapeadorLocal.put(new Auditorio("Sala3", 100));
		MapeadorLocal.put(new SalaDeAula("Sala4", 150));

		new TelaInicial("seccom");
	}
}
