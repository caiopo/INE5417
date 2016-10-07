package model.pessoa;

import model.id.Identificador;

public abstract class Pessoa {
	private Integer oid = null;

	private String nome;
	private Identificador id;

	public Pessoa(String nome, Identificador id) {
		this.nome = nome;
		this.id = id;
	}

	public boolean equals(Pessoa outra) {
		// return nome.equals(outra.nome) && id.get().equals(outra.id.get());

		return getOID() != null && outra.getOID() != null
				&& getOID().equals(outra.getOID());
	}

	@Override
	public String toString() {
		return String.format("%s(nome=%s, ID=%s)", getClass().getName(), nome,
				id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Identificador getId() {
		return id;
	}

	public void setId(Identificador id) {
		this.id = id;
	}

	public Integer getOID() {
		return oid;
	}

	public void setOID(Integer oid) {
		this.oid = oid;
	}
}
