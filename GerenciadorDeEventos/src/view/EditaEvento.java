package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditaEvento {
	public static String[] renomearEvento() {
		JTextField fieldOldName = new JTextField(15);
		JTextField fieldNewName = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));

		janela.add(new JLabel("Antigo nome do evento:"));
		janela.add(fieldOldName);

		janela.add(new JLabel("Novo nome do evento:"));
		janela.add(fieldNewName);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Cadastro de Evento", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			return new String[] { fieldOldName.getText(),
					fieldNewName.getText() };

		}

		return null;
	}

}
