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
import model.local.Local;
import model.pessoa.Palestrante;

public class CadastroCurso {

	public static Curso selecionar() {
		JRadioButton btnPalestra = new JRadioButton("Palestra", true);
		JRadioButton btnMinicurso = new JRadioButton("Minicurso", false);

		ButtonGroup grupoId = new ButtonGroup();

		grupoId.add(btnPalestra);
		grupoId.add(btnMinicurso);

		JPanel janela = new JPanel();

		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));

		janela.add(btnMinicurso);
		janela.add(btnPalestra);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnPalestra.isSelected()) {
				return cadastroPalestra();
			} else {
				return cadastroMinicurso();
			}
		}
		return null;
	}

	public static Minicurso cadastroMinicurso() {
		Minicurso minicurso = (Minicurso) cadastroComum(Minicurso.class);

		return minicurso;
	}

	public static Palestra cadastroPalestra() {
		Palestra palestra = (Palestra) cadastroComum(Palestra.class);

		return palestra;
	}

	private static Curso cadastroComum(Class<?> classe) {

		JTextField nome = new JTextField(15);
		JTextField horario = new JTextField(15);
		JTextField duracao = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(new JLabel("Horario (AAAA-MM-DD HH:MM):"));
		janela.add(horario);
		janela.add(new JLabel("Duração:"));
		janela.add(duracao);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Insira as informações", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		String _nome = nome.getText();

		String _horario = horario.getText();

		int _duracao = Integer.parseInt(duracao.getText());

		Palestrante palestrante = VisualizaPessoa.visualizarPalestrantes();

		if (palestrante == null) {
			return null;
		}

		Local local = VisualizaLocal.visualizar();

		if (local == null) {
			return null;
		}

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (classe == Palestra.class) {
				return new Palestra(_nome, _horario, local, palestrante,
						_duracao);
			} else {
				return new Minicurso(_nome, _horario, local, palestrante,
						_duracao);
			}
		} else {
			return null;
		}

	}

}
