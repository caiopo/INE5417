package model.curso;

import java.util.ArrayList;
import java.util.List;

public class Evento {

	private String nome;
	private List<Curso> cursos = new ArrayList<>();

	public Evento(String nome) {
		this.nome = nome;
	}

	public void adicionar(Curso c) {
		cursos.add(c);
	}

	@Override
	public String toString() {
		return String.format("%s(nome=%s)", getClass().getName(), nome);
	}

}
