package model.utils;

import javax.swing.JOptionPane;
import model.curso.Curso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorPessoa;
import model.pessoa.Participante;
import view.VerificaInscricao;
import view.VisualizaCurso;
import view.VisualizaPessoa;

public class Presenca {

	public static void registrar() {
		String identificador = VerificaInscricao.pegaIdentificador();

		Participante[] pessoas = MapeadorPessoa.getParticipantes().stream()
				.filter(p -> p.getId().get().equals(identificador)).toArray(Participante[]::new);

		if (pessoas.length == 0) {
			JOptionPane.showMessageDialog(null, "Nenhuma pessoa foi encontrada", "Erro", JOptionPane.ERROR_MESSAGE);

			return;
		}

		Participante participante = pessoas[0];

		// List<Curso> inscritos = cursos.stream()
		// .filter(c -> c.getParticipantes().contains(participante))
		// .collect(Collectors.toList());

		Curso c = VisualizaCurso.visualizar(MapeadorPessoa.getCursos(participante));
		if (c == null) {
			return;
		}
		MapeadorCurso.putPresenca(c, participante);

	}

	public static void visualizar() {
		Curso curso = VisualizaCurso.visualizar();
		VisualizaPessoa.visualizar((MapeadorCurso.getPresenca(curso)));

	}
}
