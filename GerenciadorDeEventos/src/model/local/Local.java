package model.local;

public abstract class Local {

	private String nome = null;
	private final int capacidade;

	public Local(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}
}
