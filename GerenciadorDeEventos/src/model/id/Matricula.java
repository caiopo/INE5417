package model.id;

public class Matricula extends Identificador {

	private String matricula;

	public Matricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String get() {
		return matricula;
	}

}
