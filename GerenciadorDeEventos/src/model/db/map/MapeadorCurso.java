package model.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

public class MapeadorCurso {

	private static int PALESTRA = 0, MINICURSO = 1;

	public static Curso get(Integer oid) {
		Database db = Database.getInstance();

		Curso c = null;
		String nome = null;
		Local local = null;
		LocalDateTime horario = null;
		Palestrante palestrante = null;
		int tipo = -1;
		int duracao = 0;

		String sql = String.format(SQLStrings.SELECT_PESSOA, oid);

		System.out.println(sql);

		ResultSet rs = db.execute(sql);

		try {
			rs.next();

			nome = rs.getString("nome");
			tipo = rs.getInt("tipo");
			local = MapeadorLocal.get(rs.getInt("local"));
			duracao = rs.getInt("duracao");
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

		if (curso.getOID() == null) {
			String sql = String.format(SQLStrings.INSERT_CURSO, curso.getNome(),
					"1999-01-08 04:05:06", curso.getDuracao(), tipo,
					curso.getPalestrante().getOID());

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
					curso.getPalestrante().getOID());

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
				cursos.add(get(rs.getInt("curso")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cursos;
	}
}
