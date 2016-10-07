package model.curso;

import model.local.Local;
import model.pessoa.Palestrante;

public class Minicurso extends Curso {

	public Minicurso(String nome, String horario, Local local,
			Palestrante palestrante, int duracao) {
		super(nome, horario, local, palestrante, duracao);
	}

}
