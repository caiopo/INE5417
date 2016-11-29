package model.db.map;

import java.util.List;
import java.util.stream.Collectors;

import model.curso.Evento;
import model.db.Database;

public class MapeadorEvento {

	public static List<Evento> getAll() {
		List<String> nomes = Database.listDBs();

		nomes.remove("postgres");

		return nomes.stream().map(s -> {
			String[] namePasswd = s.split("__", 2);

			return new Evento(namePasswd[0], namePasswd[1]);
		}).collect(Collectors.toList());
	}
}
