package model.curso;

public class Evento {

	private String nome;

	public Evento(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("%s(nome=%s)", getClass().getName(), nome);
	}

	public String getNome() {
		return nome;
	}

}
