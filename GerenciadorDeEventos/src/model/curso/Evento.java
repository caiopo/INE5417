package model.curso;

public class Evento {

	private String nome;
	private String senha;

	public Evento(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return String.format("%s(nome=%s, senha=%s)", getClass().getName(),
				nome, senha);
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}
}
