package model.db;

public class SQLStrings {

	// public static final String DB_NAME = "gerenciadoreventos";

	public static final String DB_CREATE = "CREATE DATABASE ";

	// public static final String DB_DROP = "DROP DATABASE ";

	public static final String[] TABLES_CREATE = {
			"CREATE TABLE IF NOT EXISTS PESSOAS (ID SERIAL NOT NULL PRIMARY KEY, IDENTIFICADOR VARCHAR(11), "
					+ "NOME VARCHAR(100), TIPO INTEGER);",

			"CREATE TABLE IF NOT EXISTS LOCAIS (ID SERIAL NOT NULL PRIMARY KEY, "
					+ "NOME VARCHAR(100), CAPACIDADE INTEGER, TIPO INTEGER, NUM_COMP INTEGER);",

			"CREATE TABLE IF NOT EXISTS CURSOS (ID SERIAL NOT NULL PRIMARY KEY, "
					+ "NOME VARCHAR(100), HORARIO VARCHAR(100), DURACAO INTEGER, TIPO INTEGER, PALESTRANTE INTEGER REFERENCES PESSOAS(ID));",

			"CREATE TABLE IF NOT EXISTS PARTICIPANTES_CURSO (ID SERIAL NOT NULL, CURSO INTEGER NOT NULL REFERENCES CURSOS(ID), "
					+ "PARTICIPANTE INTEGER NOT NULL REFERENCES PESSOAS(ID));"

	};

	public static final String INSERT_PESSOA = "INSERT INTO PESSOAS (IDENTIFICADOR, NOME, TIPO) "
			+ "VALUES ('%s', '%s', %d) RETURNING ID;";

	public static final String INSERT_LOCAL = "INSERT INTO LOCAIS (NOME, CAPACIDADE, TIPO, NUM_COMP) "
			+ "VALUES ('%s', %d, %d, %d) RETURNING ID;";

	public static final String INSERT_CURSO = "INSERT INTO CURSOS (NOME, HORARIO, DURACAO, TIPO, PALESTRANTE) "
			+ "VALUES ('%s', '%s', %d, %d, %d) RETURNING ID;";

	public static final String INSERT_PART_CURSO = "INSERT INTO PARTICIPANTES_CURSO (CURSO, PARTICIPANTE) "
			+ "VALUES (%d, %d) RETURNING ID;";

	public static final String UPDATE_PESSOA = "UPDATE PESSOAS SET IDENTIFICADOR = '%s', NOME = '%s' WHERE ID = %d";

	public static final String UPDATE_LOCAL = "UPDATE LOCAIS SET NOME = '%s', CAPACIDADE = %d, NUM_COMP = %d WHERE ID = %d";

	public static final String UPDATE_CURSO = "UPDATE CURSOS SET NOME = '%s', HORARIO = '%s', DURACAO = %d, PALESTRANTE = %d WHERE ID = %d";

	// public static final String UPDATE_PART_CURSO = "UPDATE
	// PARTICIPANTES_CURSO SET %s WHERE ID=%d";

	public static final String SELECT_PESSOA = "SELECT * FROM PESSOAS WHERE ID = %d";

	public static final String SELECT_LOCAL = "SELECT * FROM LOCAIS WHERE ID = %d";

	public static final String SELECT_CURSO = "SELECT * FROM CURSOS WHERE ID = %d";

	public static final String SELECT_PART_CURSO = "SELECT * FROM PARTICIPANTES_CURSO WHERE CURSO = %d";

	public static final String SELECT_ALL_LOCAL = "SELECT * FROM LOCAIS";

	public static final String SELECT_ALL_ID_CURSO = "SELECT ID FROM CURSOS";

	public static final String SELECT_ALL_ID_PESSOA = "SELECT ID FROM PESSOAS";

	// **Tabela Pessoa:**
	// identificador: char(11), primary key
	// nome: char(100)
	// tipo: int

	// **Tabela Local:**
	// id: int, primary key
	// nome: char(50)
	// capacidade: int
	// tipo: int
	// numeroDeComputadores: int

	// **Tabela Curso:**
	// id: int, primary key
	// nome: char(100)
	// horario: date
	// duracao: int
	// tipo: int
	// palestrante: foreign key Pessoa.indentificador
	// local: foreign key Local.id

	// **Tabela CursoParticipantes:**
	// id: int, primary key
	// curso: foreign key Curso.id
	// participante: foreign key Pessoa.identificador

}
