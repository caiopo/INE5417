package main;

import java.util.Scanner;

import model.curso.Curso;
import model.curso.Evento;
import model.pessoa.Pessoa;
import view.CadastroCurso;
import view.CadastroEvento;
import view.CadastroPessoa;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		boolean on = true;
		Evento evento = new CadastroEvento().cadastroEvento();
		CadastroCurso cadastroCurso = new CadastroCurso();
		
		while(on) {
	        System.out.println("Informe a opção desejada:");
	        System.out.println("1 - Cadastrar Participante");
	        System.out.println("2 - Cadastrar Palestrante");
	        System.out.println("3 - Cadastrar Minicurso");
	        System.out.println("4 - Cadastrar Palestra");
	        System.out.println("5 - Sair");
	        opcao = entrada.nextInt();
	        
			switch (opcao) {
				case 1:
					Pessoa a = new CadastroPessoa().cadastroParticipante();
					System.out.println(a.toString());
					break;
				case 2:
					Pessoa b = new CadastroPessoa().cadastroPalestrante();
					System.out.println(b.toString());
					break;
				case 3:
					Curso c = cadastroCurso.cadastroMinicurso();
					System.out.println(c.toString());
					evento.adicionar(c);
					break;
				case 4:
					Curso d = cadastroCurso.cadastroPalestra();
					System.out.println(d.toString());
					evento.adicionar(d);
					break;
				case 5:
					on = false;
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
			entrada.nextLine();
		}
	}
}
