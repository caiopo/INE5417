package model.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.curso.Curso;
import model.db.Database;
import model.db.SQLStrings;
import model.id.CPF;
import model.id.Identificador;
import model.id.Matricula;
import model.pessoa.Palestrante;
import model.pessoa.Participante;
import model.pessoa.Pessoa;

public class MapeadorPessoa {

	private static final int PALESTRANTE = 0, PARTICIPANTE = 1;

	public static Pessoa get(Integer oid) {
		Database db = Database.getInstance();

		Pessoa p = null;
		Identificador id = null;

		String idstr = null, nome = null;
		int tipo = 0;

		String sql = String.format(SQLStrings.SELECT_PESSOA, oid);

		ResultSet rs = db.execute(sql);

		try {
			rs.next();

			idstr = rs.getString("identificador");
			nome = rs.getString("nome");
			tipo = rs.getInt("tipo");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (idstr.length() == 11) {
			id = new CPF(idstr);
		} else {
			id = new Matricula(idstr);
		}

		if (tipo == PALESTRANTE) {
			p = new Palestrante(nome, id);
		} else {
			p = new Participante(nome, id);
		}

		p.setOID(oid);

		return p;

	}

	public static void put(Pessoa p) {
		Database db = Database.getInstance();

		if (p.getOID() == null) {

			int tipo = p instanceof Palestrante ? PALESTRANTE : PARTICIPANTE;

			String sql = String.format(SQLStrings.INSERT_PESSOA,
					p.getId().get(), p.getNome(), tipo);

			ResultSet rs = db.execute(sql);

			try {
				rs.next();

				p.setOID(rs.getInt("id"));

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			String sql = String.format(SQLStrings.UPDATE_PESSOA,
					p.getId().get(), p.getNome(), p.getOID());

			db.execute(sql);
		}
	}

	public static List<Pessoa> getAll() {
		Database db = Database.getInstance();

		List<Pessoa> pessoas = new ArrayList<>();

		ResultSet rs = db.execute(SQLStrings.SELECT_ALL_ID_PESSOA);

		try {

			while (rs.next()) {
				pessoas.add(get(rs.getInt("id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pessoas;
	}

	public static List<Palestrante> getPalestrantes() {
		return getAll().stream().filter(p -> p instanceof Palestrante)
				.map(p -> (Palestrante) p).collect(Collectors.toList());
	}

	public static List<Participante> getParticipantes() {
		return getAll().stream().filter(p -> p instanceof Participante)
				.map(p -> (Participante) p).collect(Collectors.toList());
	}

	public static List<Curso> getCursos(Participante p) {
		Database db = Database.getInstance();

		List<Curso> cursos = new ArrayList<>();

		if (p.getOID() == null) {
			return cursos;
		}

		String sql = String.format(SQLStrings.SELECT_CURSOS_FROM_PESSOA,
				p.getOID());

		ResultSet rs = db.execute(sql);

		try {
			while (rs.next()) {
				int curso = rs.getInt("curso");

				cursos.add(MapeadorCurso.get(curso));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursos;

	}

}
