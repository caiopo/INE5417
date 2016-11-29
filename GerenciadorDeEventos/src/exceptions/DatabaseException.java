package exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = -3046489910681922204L;

	public DatabaseException(String message) {
		super(message);
	}

}
