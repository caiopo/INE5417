package model.db;

import model.db.map.MapeadorPessoa;
import model.id.Matricula;
import model.pessoa.Participante;

public class TestePG {

	public static void main(String[] args) {
		// System.out.println(SQLStrings.DB_DROP);

		Database db = Database.getInstance();

		for (String sql : SQLStrings.TABLES_CREATE) {
			System.out.println(sql);
			db.executeSQL(sql);
		}

		// db.executeSQL(
		// String.format(SQLStrings.INSERT_PESSOA, "15100724", "Caio", 1));
		//
		// ResultSet rs = db.executeSQL("SELECT * FROM PESSOAS");
		//
		// try {
		// rs.next();
		// System.out.println(rs.getString("nome"));
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

		for (int i = 0; i < 50; i++) {

			MapeadorPessoa.put(new Participante("caiopo",
					new Matricula(Integer.toString(i))));
		}

		System.out.println(MapeadorPessoa.get(10));

	}

}
