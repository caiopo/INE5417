package model.id;

public abstract class Identificador {

	public abstract String getID();

	public boolean equals(Identificador outro) {
		return getID().equals(outro.getID());
	}
}
