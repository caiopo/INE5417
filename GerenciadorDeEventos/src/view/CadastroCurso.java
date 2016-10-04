package view;

import java.awt.LayoutManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import model.local.Laboratorio;
import model.pessoa.Palestrante;

public class CadastroCurso {
	private static final DateTimeFormatter formatador = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm");
	
	public static Curso selecionar() {
		JRadioButton btnPalestra = new JRadioButton("Palestra", true);
		JRadioButton btnMinicurso = new JRadioButton("Minicurso", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnPalestra);
		grupoId.add(btnMinicurso);
		JPanel janela = new JPanel();
		janela.add(btnMinicurso);
		janela.add(btnPalestra);
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
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
		JTextField nome = new JTextField(15);
		JTextField horario = new JTextField(15);
		JTextField local = new JTextField(15);
		JTextField duracao = new JTextField(15);
		JTextField palestrante = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(new JLabel("Horario (AAAA-MM-DD HH:MM):"));
		janela.add(horario);
		janela.add(new JLabel("Local:"));
		janela.add(local);
		janela.add(new JLabel("Duração (em minutos):"));
		janela.add(duracao);
		janela.add(new JLabel("Palestrante:"));
		janela.add(palestrante);
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Insira as informações do minicurso.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome, _horario, _local, _palestrante;
		int _duracao;
		_nome = nome.getText();
		_palestrante = palestrante.getText();

		_horario = horario.getText();

		LocalDateTime _dateTime = LocalDateTime.parse(_horario, formatador);

		_local = local.getText();
		_duracao = Integer.parseInt(duracao.getText());

		if (botaoOk == JOptionPane.OK_OPTION) {
			return new Minicurso(_nome, _dateTime,
					new Laboratorio(_local, 50, 50),
					new Palestrante(_palestrante, null), _duracao);
		} else {
			return null;
		}
	}

	public static Palestra cadastroPalestra() {
		JTextField nome = new JTextField(15);
		JTextField horario = new JTextField(15);
		JTextField local = new JTextField(15);
		JTextField duracao = new JTextField(15);
		JTextField palestrante = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(new JLabel("Horario (AAAA-MM-DD HH:MM):"));
		janela.add(horario);
		janela.add(new JLabel("Local:"));
		janela.add(local);
		janela.add(new JLabel("Duração:"));
		janela.add(duracao);
		janela.add(new JLabel("Palestrante:	s"));
		janela.add(palestrante);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Insira as informações da palestra.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome, _horario, _local, _palestrante;
		int _duracao;
		_nome = nome.getText();
		_palestrante = palestrante.getText();

		_horario = horario.getText();
		LocalDateTime _dateTime = LocalDateTime.parse(_horario, formatador);

		_local = local.getText();
		_duracao = Integer.parseInt(duracao.getText());

		if (botaoOk == JOptionPane.OK_OPTION) {
			return new Palestra(_nome, _dateTime,
					new Laboratorio(_local, 50, 50),
					new Palestrante(_palestrante, null), _duracao);
		} else {
			return null;
		}
	}
}
