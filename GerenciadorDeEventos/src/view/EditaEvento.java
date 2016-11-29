package view;

import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.curso.Evento;
import model.db.Database;
import model.db.map.MapeadorEvento;

public class EditaEvento {
	private static String[] janelaRenomear(List<Evento> eventos) {
		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));

		JComboBox<String> comboBox = new JComboBox<>(
				eventos.stream().map(e -> e.getNome()).toArray(String[]::new));

		janela.add(comboBox);

		JOptionPane.showMessageDialog(null, janela, "Editar evento",
				JOptionPane.PLAIN_MESSAGE);

		String oldName = (String) comboBox.getSelectedItem();

		String newName = JOptionPane
				.showInputDialog("Digite o novo nome do evento");

		return new String[] { oldName, newName };

	}

	public static void renomearEvento() {
		List<Evento> eventos = MapeadorEvento.getAll();

		String[] nomes = janelaRenomear(eventos);

		Database.renameDB(nomes[0], nomes[1]);
	}

}
