package view;

import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.curso.Curso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorPessoa;
import model.pessoa.Participante;

public class Presenca {

	public static void presenca() {
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

		// List<Curso> inscritos = cursos.stream()
		// .filter(c -> c.getParticipantes().contains(participante))
		// .collect(Collectors.toList());

		List<Curso> inscritos = MapeadorPessoa.getCursos(participante);

		JOptionPane.showMessageDialog(null,
					"Escolha um curso para inserir a presença");

		JPanel janela = new JPanel();

		if (inscritos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Usuário não está inscrito em nenhum curso",
					"Erro", JOptionPane.ERROR_MESSAGE);

			return;
		}

		String[] opcaoCursos = inscritos.stream()
				.map(local -> local.getNome()).toArray(String[]::new);

		JComboBox<String> comboBox = new JComboBox<String>(opcaoCursos);
		comboBox.setSelectedIndex(0);
		janela.add(comboBox);

		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione o curso desejado para marcar presença", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			Curso c = inscritos.get(comboBox.getSelectedIndex());
			MapeadorCurso.putPresenca(c, participante);
		}
	}
	public static void visualizar() {
		Curso curso = VisualizaCurso.visualizar();
		VisualizaPessoa.visualizar((MapeadorCurso.getPresenca(curso)));
		
	}
}
