package view;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import model.curso.Curso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorPessoa;
import model.pessoa.Participante;

public class Inscricao {

	private static boolean isInCurso(Participante participante, Curso curso) {
		return curso.getParticipantes().stream().anyMatch(p -> {

			System.out.println(p.getId().get());
			System.out.println(participante.getId().get());
			System.out.println("");

			return p.getId().get().equals(participante.getId().get());
		});
	}

	public static void inscricao() {
		String identificador = VerificaInscricao.pegaIdentificador();

		Participante[] pessoas = MapeadorPessoa.getParticipantes().stream()
				.filter(p -> p.getId().get().equals(identificador))
				.toArray(Participante[]::new);

		if (pessoas.length == 0) {
			JOptionPane.showMessageDialog(null, "Nenhuma pessoa foi encontrada",
					"Erro", JOptionPane.ERROR_MESSAGE);

			return;
		}

		Participante participante = pessoas[0];

		List<Curso> cursos = MapeadorCurso.getAll();

		cursos.forEach(c -> System.out.println(c.getNome()));

		// List<Curso> inscritos = cursos.stream()
		// .filter(c -> c.getParticipantes().contains(participante))
		// .collect(Collectors.toList());

		List<Curso> inscritos = MapeadorPessoa.getCursos(participante);

		String msgInscritos = "Inscrições:\n\n";

		if (inscritos.size() == 0) {
			msgInscritos = "Você não está inscrito em nenhum curso.";
		} else {
			for (Curso c : inscritos) {
				msgInscritos += c.getNome() + "\n";
			}
		}

		JOptionPane.showMessageDialog(null, msgInscritos);

		while (true) {
			JOptionPane.showMessageDialog(null,
					"Escolha um curso para de inscrever");

			Curso c = VisualizaCurso.visualizar();

			if (c == null) {
				break;
			}

			c.adicionaParticipante(participante);

			MapeadorCurso.put(c);
		}

		// cursos.stream().forEach(c -> MapeadorCurso.put(c));

	}

}
