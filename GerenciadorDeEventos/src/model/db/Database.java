package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.DatabaseException;

public class Database {

	private static final String URL = "jdbc:postgresql://localhost:5432/";
	private static final String DRIVER = "org.postgresql.Driver";

	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";

	private static Database db = null;

	public static void createDB(String dbName) {
		Database database = new Database(URL);

		try {

			database.execute(SQLStrings.DB_CREATE + dbName);

		} catch (DatabaseException e) {

		}

		System.out.println(URL + dbName);

		database = new Database(URL + dbName);

		for (String sql : SQLStrings.TABLES_CREATE) {
			database.execute(sql);
		}
	}

	public static void renameDB(String oldName, String newName) {
		Database database = new Database(URL);

		database.execute(String.format(SQLStrings.DB_RENAME, oldName, newName));

	}

	public static void connectTo(String dbName) {
		db = new Database(URL + dbName);
	}

	public static Database getInstance() {
		if (db == null) {
			throw new DatabaseException("Must call init() first");
		}

		return db;
	}

	private Connection conn = null;

	private Database(String URL) {
		try {
			connect(URL);
		} catch (SQLException e) {
			// e.printStackTrace();
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
