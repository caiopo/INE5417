package model.utils;

import java.util.List;

import javax.swing.JOptionPane;

import model.curso.Curso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorPessoa;
import model.pessoa.Participante;
import view.VerificaInscricao;
import view.VisualizaCurso;

public class Inscricao {

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

//		List<Curso> cursos = MapeadorCurso.getAll();

//		cursos.forEach(c -> System.out.println(c.getNome()));

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

		
		JOptionPane.showMessageDialog(null,
				"Escolha um curso para de inscrever");

		Curso c = VisualizaCurso.visualizar();

		if (c == null) {
			return;
		}

		c.adicionaParticipante(participante);

		MapeadorCurso.put(c);
			

		// cursos.stream().forEach(c -> MapeadorCurso.put(c));

	}

}
