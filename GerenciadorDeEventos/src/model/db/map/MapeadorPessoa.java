package model.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;

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

		System.out.println(sql);

		ResultSet rs = db.executeSQL(sql);

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

			ResultSet rs = db.executeSQL(sql);

			try {
				rs.next();

				System.out.println(rs.getInt("id"));

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			String sql = String.format(SQLStrings.UPDATE_PESSOA,
					p.getId().get(), p.getNome(), p.getOID());

			db.executeSQL(sql);
		}
	}

}
