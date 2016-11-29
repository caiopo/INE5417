package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import exceptions.DatabaseException;
import model.curso.Evento;

public class Database {

	private static final String URL = "jdbc:postgresql://172.17.0.2:5432/";
	private static final String DRIVER = "org.postgresql.Driver";

	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";

	private static Database db = null;

	public static void createDB(Evento evento) {
		createDB(formatDBName(evento));
	}

	public static void createDB(String dbName) {
		Database database = new Database(URL);

		try {

			database.execute(SQLStrings.DB_CREATE + dbName);

		} catch (DatabaseException e) {

		}

		database = new Database(URL + dbName);

		for (String sql : SQLStrings.TABLES_CREATE) {
			database.execute(sql);
		}
	}

	public static void renameDB(Evento oldEvent, Evento newEvent) {
		renameDB(formatDBName(oldEvent), formatDBName(newEvent));
	}

	private static void renameDB(String oldName, String newName) {
		Database database = new Database(URL);

		database.execute(String.format(SQLStrings.DB_RENAME, oldName, newName));

	}

	public static List<String> listDBs() {
		ResultSet rs = new Database(URL).execute(SQLStrings.DB_LIST);

		ArrayList<String> dbNames = new ArrayList<>();

		try {
			while (rs.next()) {
				dbNames.add(rs.getString("datname"));
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}

		dbNames.sort(Comparator.naturalOrder());

		return dbNames;
	}

	public static void connectTo(Evento evento) {
		connectTo(formatDBName(evento));
	}

	private static void connectTo(String dbName) {
		db = new Database(URL + dbName);
	}

	public static Database getInstance() {
		if (db == null) {
			throw new DatabaseException("Must call connectTo() first");
		}

		return db;
	}

	private static String formatDBName(Evento evento) {
		return evento.getNome() + "__" + evento.getSenha();
	}

	private Connection conn = null;

	private Database(String url) {
		try {
			connect(url);
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public void connect(String url) throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		conn = DriverManager.getConnection(url, USER, PASSWORD);
	}

	public ResultSet execute(String sql) {
		try {

			Statement stmt = conn.createStatement();

			stmt.execute(sql);
			return stmt.getResultSet();

		} catch (SQLException e) {
			DatabaseException de = new DatabaseException(e.getMessage());

			de.setStackTrace(e.getStackTrace());

			throw de;
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
