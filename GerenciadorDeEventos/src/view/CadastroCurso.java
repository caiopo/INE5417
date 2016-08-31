package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.curso.Curso;
import model.curso.Minicurso;
import model.curso.Palestra;

public class CadastroCurso {

	public static Curso cadastroCurso() {
		JTextField fieldNome = new JTextField(15);
		JTextField fieldDuracao = new JTextField(15);
		JTextField fieldPalestrante = new JTextField(15);

		JRadioButton btnMinicurso = new JRadioButton("Minicurso", false);
		JRadioButton btnPalestra = new JRadioButton("Palestra", false);
		ButtonGroup tipoGrupo = new ButtonGroup();
		tipoGrupo.add(btnMinicurso);
		tipoGrupo.add(btnPalestra);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));

		janela.add(new JLabel("Nome do Curso:"));
		janela.add(fieldNome);
		janela.add(new JLabel("Duração (em minutos):"));
		janela.add(fieldDuracao);
		janela.add(new JLabel("Matricula/CPF do Palestrante:"));
		janela.add(fieldPalestrante);

		janela.add(new JLabel("Tipo:"));
		janela.add(btnMinicurso);
		janela.add(btnPalestra);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Cadastro de Curso", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnMinicurso.isSelected()) {
				return new Minicurso(fieldNome.getText(), null, null, null,
						Integer.parseInt(fieldDuracao.getText()));
			} else if (btnPalestra.isSelected()) {
				return new Palestra(fieldNome.getText(), null, null, null,
						Integer.parseInt(fieldDuracao.getText()));

			}
		}

		return null;
	}
}
