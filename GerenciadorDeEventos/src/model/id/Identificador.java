package model.id;

public abstract class Identificador {

	public abstract String get();

	public boolean equals(Identificador outro) {
		return get().equals(outro.get());
	}
}
