package view;

import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.db.map.MapeadorPessoa;
import model.pessoa.Palestrante;
import model.pessoa.Participante;
import model.pessoa.Pessoa;

public class VisualizaPessoa {

	public static Pessoa visualizar() {

		return visualizar(MapeadorPessoa.getAll());

	}

	public static Participante visualizarParticipantes() {

		return (Participante) visualizar(MapeadorPessoa.getParticipantes());

	}

	public static Palestrante visualizarPalestrantes() {

		return (Palestrante) visualizar(MapeadorPessoa.getPalestrantes());

	}

	public static Pessoa visualizar(List<? extends Pessoa> listaPessoas) {

		JPanel janela = new JPanel();

		if (listaPessoas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma pessoa foi cadastrada",
					"Erro", JOptionPane.ERROR_MESSAGE);

			return null;
		}

		String[] opcaoPessoas = listaPessoas.stream()
				.map(local -> local.getNome()).toArray(String[]::new);

		JComboBox<String> comboBox = new JComboBox<String>(opcaoPessoas);

		comboBox.setSelectedIndex(0);
		janela.add(comboBox);

		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione a pessoa desejada", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			return listaPessoas.get(comboBox.getSelectedIndex());
		}

		return null;
	}
}
