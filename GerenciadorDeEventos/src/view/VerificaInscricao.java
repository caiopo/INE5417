package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerificaInscricao{
		
	public static String pegaIdentificador() {
		JPanel janela = new JPanel();
		JTextField id = new JTextField(15);
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Identificador:"));
		janela.add(id);
		
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Informe seu identificador",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (botaoOk == JOptionPane.OK_OPTION) {
			return id.getText();
		}
		return null;
		
	}
	
	
	
}
