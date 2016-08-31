package model.id;

public abstract class Identificador {

	public abstract String get();

	public boolean equals(Identificador outro) {
		return get().equals(outro.get());
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", getClass().getName(), get());
	}
}
