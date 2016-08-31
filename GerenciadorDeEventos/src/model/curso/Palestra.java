package model.curso;

import java.time.LocalDateTime;

import model.local.Local;
import model.pessoa.Palestrante;

public class Palestra extends Curso {

	public Palestra(String nome, LocalDateTime horario, Local local,
			Palestrante palestrante, int duracao) {
		super(nome, horario, local, palestrante, duracao);
	}

}
