package model.curso;

import java.time.LocalDateTime;

import model.local.Local;

public class Palestra extends Curso {

	public Palestra(String nome, LocalDateTime horario, Local local, int duracao) {
		super(nome, horario, local, duracao);
	}

}
