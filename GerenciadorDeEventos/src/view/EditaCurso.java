package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.curso.Curso;

public class EditaCurso {

	public static void edita(Curso curso) {
		JTextField fieldNome = new JTextField(15);
		JTextField fieldHorario = new JTextField(15);
		JTextField fieldLocal = new JTextField(15);
		JTextField fieldDuracao = new JTextField(15);
		JTextField fieldPalestrante = new JTextField(15);

		fieldNome.setText(curso.getNome());
		fieldHorario.setText(curso.getHorario());
		fieldLocal.setText(curso.getLocal().getNome());
		fieldDuracao.setText(Integer.toString(curso.getDuracao()));
		fieldPalestrante.setText(curso.getPalestrante().getNome());

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(new JLabel("Horario (AAAA-MM-DD HH:MM):"));
		janela.add(fieldHorario);
		janela.add(new JLabel("Local:"));
		janela.add(fieldLocal);
		janela.add(new JLabel("Duração (em minutos):"));
		janela.add(fieldDuracao);
		janela.add(new JLabel("Palestrante"));
		janela.add(fieldPalestrante);
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Edita " + curso.getClass().getSimpleName(),
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			curso.setNome(fieldNome.getText());
			curso.setHorario(fieldHorario.getText());
			curso.getLocal().setNome(fieldLocal.getText());
			curso.setDuracao(Integer.parseInt(fieldDuracao.getText()));
			curso.getPalestrante().setNome(fieldPalestrante.getText());

		}
	}

}
