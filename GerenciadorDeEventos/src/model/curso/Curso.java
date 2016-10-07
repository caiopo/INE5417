package model.curso;

import java.util.ArrayList;
import java.util.List;

import model.local.Local;
import model.pessoa.Palestrante;
import model.pessoa.Participante;

public abstract class Curso {

	private Integer oid = null;

	private String nome;
	private String horario;
	private Local local;
	private int duracao;
	private Palestrante palestrante;

	private List<Participante> participantes = new ArrayList<>();

	public Curso(String nome, String horario, Local local,
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
		return String.format("%s(nome=%s, duracao=%d)", getClass().getName(),
				nome, duracao);
	}

	public String getNome() {
		return nome;
	}

	public String getHorario() {
		return horario;
	}

	public Local getLocal() {
		return local;
	}

	public int getDuracao() {
		return duracao;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Integer getOID() {
		return oid;
	}

	public void setOID(Integer oid) {
		this.oid = oid;
	}
}
