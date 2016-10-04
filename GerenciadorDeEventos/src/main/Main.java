package main;

import model.curso.Evento;
import view.CadastroEvento;
import view.TelaInicial;

public class Main {

	public static void main(String[] args) {

		Evento evento = CadastroEvento.cadastroEvento();
		
		Evento.setInstance(evento);

		new TelaInicial();
		// Scanner entrada = new Scanner(System.in);
		// int opcao;
		// boolean on = true;
		// Evento evento = CadastroEvento.cadastroEvento();
		//
		// while (on) {
		// System.out.println("Informe a opção desejada:");
		// System.out.println("1 - Cadastrar Participante");
		// System.out.println("2 - Cadastrar Palestrante");
		// System.out.println("3 - Cadastrar Minicurso");
		// System.out.println("4 - Cadastrar Palestra");
		// System.out.println("5 - Sair");
		// opcao = entrada.nextInt();
		//
		// switch (opcao) {
		// case 1:
		// Participante a = CadastroPessoa.cadastroParticipante();
		// System.out.println(a.toString());
		// EditaPessoa.editarParticipante(a);
		// System.out.println(a.toString());
		// break;
		// case 2:
		// Palestrante b = CadastroPessoa.cadastroPalestrante();
		// System.out.println(b.toString());
		// EditaPessoa.editarPalestrante(b);
		// System.out.println(b.toString());
		// break;
		// case 3:
		// Minicurso c = CadastroCurso.cadastroMinicurso();
		// System.out.println(c.toString());
		// EditaCurso.edita(c);
		// System.out.println(c.toString());
		// evento.adicionar(c);
		// break;
		// case 4:
		// Palestra d = CadastroCurso.cadastroPalestra();
		// System.out.println(d.toString());
		// EditaCurso.edita(d);
		// System.out.println(d.toString());
		// evento.adicionar(d);
		// break;
		// case 5:
		// on = false;
		// break;
		// default:
		// System.out.println("Opção inválida");
		// break;
		// }
		//
		// entrada.nextLine();
		// }
		//
		// entrada.close();
	}
}
