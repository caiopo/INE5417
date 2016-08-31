package model.local;

public abstract class Local {

	private String nome;
	private final int capacidade;

	public Local(String nome, int capacidade) {
		this.nome = nome;
		this.capacidade = capacidade;
	}

	public boolean equals(Local outro) {
		return nome.equals(outro.nome) && capacidade == outro.capacidade;
	}

	@Override
	public String toString() {
		return String.format("%s(nome=%d, capacidade=%d)", getClass().getName(),
				nome, capacidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
