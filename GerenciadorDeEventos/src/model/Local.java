package model;

public abstract class Local {

	private String nome;
	private final int capacidade;

	public Local(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}
}
