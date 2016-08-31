package main;

import model.curso.Curso;
import model.curso.Evento;
import view.CadastroCurso;
import view.CadastroEvento;
import view.CadastroPessoa;

public class Main {

	public static void main(String[] args) {
		Evento evento = CadastroEvento.cadastroEvento();

		for (int i = 0; i < 3; i++) {
			Curso c = CadastroCurso.cadastroCurso();
			System.out.println(c.toString());
			evento.adicionar(c);
		}

		CadastroPessoa.cadastroPalestrante();
		CadastroPessoa.cadastroParticipante();
	}
}
