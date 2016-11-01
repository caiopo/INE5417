package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.curso.Evento;

public class CadastroEvento {

	public static Evento cadastroEvento() {
		JTextField nome = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome do evento:"));
		janela.add(nome);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Evento", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			return new Evento(nome.getText());
		}

		return null;
	}

	public static TipoLogin tipoLogin() {
		String[] ops = { "Logar", "Cadastrar", "Editar" };

		String resposta = (String) JOptionPane.showInputDialog(null,
				"Logar em evento existente, cadastrar novo evento ou editar evento existente",
				"Login", JOptionPane.PLAIN_MESSAGE, null, ops, ops[0]);

		for (int i = 0; i < ops.length; i++) {
			if (resposta.equals(ops[i])) {
				return TipoLogin.values()[i];
			}
		}

		return null;

	}

	public enum TipoLogin {
		LOGAR, CADASTRAR, EDITAR;
	}
}
