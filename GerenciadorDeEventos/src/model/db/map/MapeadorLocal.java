package model.db.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.db.Database;
import model.db.SQLStrings;
import model.local.Auditorio;
import model.local.Laboratorio;
import model.local.Local;
import model.local.SalaDeAula;

public class MapeadorLocal {

	private static final int AUDITORIO = 0, SALA_DE_AULA = 1, LABORATORIO = 2;

	public static Local get(Integer oid) {
		Database db = Database.getInstance();

		Local local = null;

		String nome = null;
		int capacidade = 0;
		int tipo = -1;
		int numComp = 0;

		String sql = String.format(SQLStrings.SELECT_LOCAL, oid);

		ResultSet rs = db.execute(sql);

		try {
			rs.next();

			nome = rs.getString("nome");
			capacidade = rs.getInt("capacidade");
			tipo = rs.getInt("tipo");
			numComp = rs.getInt("num_comp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		switch (tipo) {
		case AUDITORIO:
			local = new Auditorio(nome, capacidade);
			break;
		case SALA_DE_AULA:
			local = new SalaDeAula(nome, capacidade);
			break;

		case LABORATORIO:
			local = new Laboratorio(nome, capacidade, numComp);
			break;
		}

		local.setOID(oid);

		return local;

	}

	public static void put(Local local) {
		Database db = Database.getInstance();

		int tipo = local instanceof Auditorio ? AUDITORIO
				: (local instanceof SalaDeAula ? SALA_DE_AULA : LABORATORIO);

		if (local.getOID() == null) {

			String sql = String.format(SQLStrings.INSERT_LOCAL, local.getNome(),
					local.getCapacidade(), tipo,
					local.getNumeroDeComputadores());

			ResultSet rs = db.execute(sql);

			try {
				rs.next();

				local.setOID(rs.getInt("id"));

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			String sql = String.format(SQLStrings.UPDATE_LOCAL, local.getNome(),
					local.getCapacidade(), local.getNumeroDeComputadores(),
					local.getOID());

			db.execute(sql);
		}
	}

	public static List<Local> getAll() {
		Database db = Database.getInstance();

		List<Local> locais = new ArrayList<>();

		ResultSet rs = db.execute(SQLStrings.SELECT_ALL_LOCAL);

		try {
			while (rs.next()) {
				String nome = rs.getString("nome");
				int capacidade = rs.getInt("capacidade");
				int tipo = rs.getInt("tipo");
				int numComp = rs.getInt("num_comp");

				Local local = null;

				switch (tipo) {
				case AUDITORIO:
					local = new Auditorio(nome, capacidade);
					break;
				case SALA_DE_AULA:
					local = new SalaDeAula(nome, capacidade);
					break;

				case LABORATORIO:
					local = new Laboratorio(nome, capacidade, numComp);
					break;
				}

				local.setOID(rs.getInt("id"));

				locais.add(local);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return locais;
	}

}
