package view;

import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.db.map.MapeadorLocal;
import model.local.Local;

public class VisualizarLocal {

	public static Local visualizar() {

		JPanel janela = new JPanel();
		JButton btnEditar = new JButton("Editar Local");

		List<Local> listaLocais = MapeadorLocal.getAll();
		System.out.println(listaLocais.size());

		if (listaLocais.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhum local foi cadastrado",
					"Erro", JOptionPane.ERROR_MESSAGE);

			return null;
		}

		String[] opcaoLocais = listaLocais.stream()
				.map(local -> local.getNome())
				.toArray(size -> new String[size]);

		JComboBox<String> comboBox = new JComboBox<String>(opcaoLocais);

		comboBox.setSelectedIndex(0);
		btnEditar.addActionListener((e) -> {
			Local selecionado = listaLocais.get(comboBox.getSelectedIndex());

			EditaLocal.editar(selecionado);

			MapeadorLocal.put(selecionado);

		});

		janela.add(comboBox);
		janela.add(btnEditar);
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
		JOptionPane.showMessageDialog(null, janela,
				"Selecione a opção desejada", JOptionPane.QUESTION_MESSAGE);

		return listaLocais.get(comboBox.getSelectedIndex());
	}
}
