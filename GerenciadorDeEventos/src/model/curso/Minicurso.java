package model.curso;

import java.time.LocalDateTime;

import model.local.Local;
import model.pessoa.Palestrante;

public class Minicurso extends Curso {

	public Minicurso(String nome, LocalDateTime horario, Local local,
			Palestrante palestrante, int duracao) {
		super(nome, horario, local, palestrante, duracao);
	}

	@Override
	public String toString() {
		return super.toString().replace("Curso", "Minicurso");
	}
}
