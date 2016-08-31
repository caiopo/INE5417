package model.curso;

import java.time.LocalDateTime;

import model.local.Local;

public class Minicurso extends Curso {

	public Minicurso(String nome, LocalDateTime horario, Local local, int duracao) {
		super(nome, horario, local, duracao);
	}

}
