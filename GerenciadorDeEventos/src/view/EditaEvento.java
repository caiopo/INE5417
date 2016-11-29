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
	private static Evento escolheEvento(List<Evento> eventos) {
		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));

		JComboBox<String> comboBox = new JComboBox<>(
				eventos.stream().map(e -> e.getNome()).toArray(String[]::new));

		janela.add(comboBox);

		JOptionPane.showMessageDialog(null, janela, "Editar evento",
				JOptionPane.PLAIN_MESSAGE);

		String nome = (String) comboBox.getSelectedItem();

		for (Evento e : eventos) {
			if (e.getNome().equals(nome)) {
				return e;
			}
		}

		return null;
	}

	public static void renomearEvento() {
		List<Evento> eventos = MapeadorEvento.getAll();

		Evento oldEvent = escolheEvento(eventos);

		Evento newEvent = CadastroEvento.inputEvento();

		Database.renameDB(oldEvent, newEvent);
	}

}
