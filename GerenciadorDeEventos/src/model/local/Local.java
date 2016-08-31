package model.local;

public abstract class Local {

	private String nome = null;
	private final int capacidade;

	public Local(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}

	public boolean equals(Local outro) {
		return nome.equals(outro.nome) && capacidade == outro.capacidade;
	}
}
