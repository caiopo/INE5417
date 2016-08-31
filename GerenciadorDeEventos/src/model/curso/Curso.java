package model.curso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.local.Local;
import model.pessoa.Palestrante;
import model.pessoa.Participante;

public abstract class Curso {

	private String nome;
	private LocalDateTime horario;
	private Local local;
	private int duracao;
	private Palestrante palestrante;

	private List<Participante> participantes = new ArrayList<>();

	public Curso(String nome, LocalDateTime horario, Local local,
			Palestrante palestrante, int duracao) {
		this.nome = nome;
		this.horario = horario;
		this.local = local;
		this.palestrante = palestrante;
		this.duracao = duracao;
	}

	public void adicionaParticipante(Participante p) {
		participantes.add(p);
	}

	@Override
	public String toString() {
		return String.format("Curso(nome=%s, duracao=%d)", nome, duracao);
	}
}
