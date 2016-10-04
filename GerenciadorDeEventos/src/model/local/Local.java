package model.local;

public abstract class Local {

	private Integer oid = null;

	private String nome;
	private int capacidade;

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

	public Integer getOID() {
		return oid;
	}

	public void setOID(Integer oid) {
		this.oid = oid;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getNumeroDeComputadores() {
		return 0;
	}
}
