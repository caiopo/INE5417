package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.DatabaseException;

public class Database {

	static Database db = null;

	public static void init(String dbName) {
		db = new Database(URL);

		try {

			db.execute(SQLStrings.DB_CREATE + dbName);

		} catch (DatabaseException e) {

		}

		System.out.println(URL + dbName);

		db = new Database(URL + dbName);

		for (String sql : SQLStrings.TABLES_CREATE) {
			db.execute(sql);
		}
	}

	public static Database getInstance() {
		if (db == null) {
			throw new DatabaseException("Must call init() first");
		}

		return db;
	}

	static final String URL = "jdbc:postgresql://172.17.0.2:5432/";
	static final String DRIVER = "org.postgresql.Driver";

	static final String USER = "postgres";
	static final String PASSWORD = "postgres";

	private Connection conn = null;

	private Database(String URL) {
		try {
			connect(URL);
		} catch (SQLException e) {
			e.printStackTrace();
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
