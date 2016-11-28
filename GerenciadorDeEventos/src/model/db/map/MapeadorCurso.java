package model.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.curso.Curso;
import model.curso.Minicurso;
import model.curso.Palestra;
import model.db.Database;
import model.db.SQLStrings;
import model.local.Local;
import model.pessoa.Palestrante;
import model.pessoa.Participante;
import model.pessoa.Pessoa;

public class MapeadorCurso {

	private static int PALESTRA = 0, MINICURSO = 1;

	public static Curso get(Integer oid) {
		Database db = Database.getInstance();

		Curso c = null;
		String nome = null;
		Local local = null;
		String horario = null;
		Palestrante palestrante = null;
		int tipo = -1;
		int duracao = 0;

		String sql = String.format(SQLStrings.SELECT_CURSO, oid);

		ResultSet rs = db.execute(sql);

		try {
			rs.next();

			nome = rs.getString("nome");
			tipo = rs.getInt("tipo");
			local = MapeadorLocal.get(rs.getInt("local"));
			duracao = rs.getInt("duracao");
			horario = rs.getString("horario");
			palestrante = (Palestrante) MapeadorPessoa
					.get(rs.getInt("palestrante"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (tipo == PALESTRA) {
			c = new Palestra(nome, horario, local, palestrante, duracao);
		} else {
			c = new Minicurso(nome, horario, local, palestrante, duracao);
		}

		sql = String.format(SQLStrings.SELECT_PART_CURSO, oid);

		try {
			while (rs.next()) {
				Participante part = (Participante) MapeadorPessoa
						.get(rs.getInt("participante"));

				c.adicionaParticipante(part);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		c.setOID(oid);

		return c;
	}

	public static void put(Curso curso) {

		Database db = Database.getInstance();

		int tipo = curso instanceof Palestra ? PALESTRA : MINICURSO;

		if (curso.getPalestrante().getOID() == null) {
			MapeadorPessoa.put(curso.getPalestrante());
		}

		if (curso.getLocal().getOID() == null) {
			MapeadorLocal.put(curso.getLocal());
		}

		if (curso.getOID() == null) {
			String sql = String.format(SQLStrings.INSERT_CURSO, curso.getNome(),
					curso.getHorario(), curso.getDuracao(), tipo,
					curso.getPalestrante().getOID(), curso.getLocal().getOID());

			ResultSet rs = db.execute(sql);

			try {
				rs.next();

				curso.setOID(rs.getInt("id"));

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			String sql = String.format(SQLStrings.UPDATE_CURSO, curso.getNome(),
					curso.getHorario(), curso.getDuracao(), tipo,
					curso.getPalestrante().getOID(), curso.getLocal().getOID(),
					curso.getOID());

			db.execute(sql);
		}

		for (Participante p : curso.getParticipantes()) {
			if (p.getOID() == null) {
				MapeadorPessoa.put(p);
			}

			String sql = String.format(SQLStrings.INSERT_PART_CURSO,
					curso.getOID(), p.getOID());

			db.execute(sql);
		}

	}

	public static List<Curso> getAll() {
		Database db = Database.getInstance();

		List<Curso> cursos = new ArrayList<>();

		ResultSet rs = db.execute(SQLStrings.SELECT_ALL_ID_CURSO);

		try {

			while (rs.next()) {
				cursos.add(get(rs.getInt("id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursos;
	}
	
	public static void putPresenca(Curso curso, Pessoa pessoa) {

		Database db = Database.getInstance();

		
		String sql = String.format(SQLStrings.INSERT_PRES_CURSO,
				curso.getOID(), pessoa.getOID());

		db.execute(sql);

	}
	
	public static List<Participante> getPresenca(Curso c) {
		Database db = Database.getInstance();

		List<Participante> participantes = new ArrayList<>();

		if (c == null) {
			return participantes;
		}

		String sql = String.format(SQLStrings.SELECT_PRES_CURSO,
				c.getOID());

		ResultSet rs = db.execute(sql);

		try {
			while (rs.next()) {
				int participante = rs.getInt("participante");

				participantes.add((Participante) MapeadorPessoa.get(participante));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return participantes;

	}
}
