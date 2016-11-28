package view;

import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.curso.Curso;
import model.db.map.MapeadorCurso;

public class VisualizaCurso {

	public static Curso visualizar() {

		return visualizar(MapeadorCurso.getAll());
	}
	
	public static Curso visualizar(List<? extends Curso> listaCursos) {

		JPanel janela = new JPanel();

		if (listaCursos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum curso foi cadastrado",
					"Erro", JOptionPane.ERROR_MESSAGE);

			return null;
		}

		String[] opcaoCursos = listaCursos.stream()
				.map(local -> local.getNome()).toArray(String[]::new);

		JComboBox<String> comboBox = new JComboBox<String>(opcaoCursos);

		comboBox.setSelectedIndex(0);
		janela.add(comboBox);

		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione o curso desejado", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			return listaCursos.get(comboBox.getSelectedIndex());
		}

		return null;
	}
}
