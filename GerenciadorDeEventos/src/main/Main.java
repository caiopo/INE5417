package main;

import view.CadastroEvento;
import view.CadastroPessoa;

public class Main {

	public static void main(String[] args) {
		CadastroEvento.cadastroEvento();

		CadastroPessoa.cadastroPalestrante();
		CadastroPessoa.cadastroParticipante();
	}
}
