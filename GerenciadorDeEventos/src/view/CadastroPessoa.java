package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import exceptions.BadCPFException;
import model.id.CPF;
import model.id.Matricula;
import model.pessoa.Palestrante;
import model.pessoa.Participante;
import model.pessoa.Pessoa;

public class CadastroPessoa {
	
	public static Pessoa selecionar() {
		// if(!Evento.getInstance().possuiCurso()) {
		// JOptionPane.showMessageDialog(null, "Não existem cursos nesse
		// evento");
		// return null;
		// }
		JRadioButton btnParticipante = new JRadioButton("Participante", true);
		JRadioButton btnPalestrante = new JRadioButton("Palestrante", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnPalestrante);
		grupoId.add(btnParticipante);
		JPanel janela = new JPanel();
		janela.add(btnParticipante);
		janela.add(btnPalestrante);
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnPalestrante.isSelected()) {
				return cadastroPalestrante();
			} else {
				return cadastroParticipante();
			}
		}
		return null;	
	}
	
	public static Palestrante cadastroPalestrante() {
		JTextField nome = new JTextField(15);
		JTextField id = new JTextField(15);

		JRadioButton btnCpf = new JRadioButton("CPF:", false);
		JRadioButton btnMatricula = new JRadioButton("Matricula UFSC:", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnCpf);
		grupoId.add(btnMatricula);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(btnCpf);
		janela.add(btnMatricula);
		janela.add(id);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Palestrante, favor insira seus dados.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome, _id;
		_nome = nome.getText();
		_id = id.getText();

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnCpf.isSelected()) {
				try {
					return new Palestrante(_nome, new CPF(_id));
				} catch (BadCPFException e) {
					JOptionPane.showMessageDialog(null, "CPF Inválido");
				}
				return null;
			} else {
				return new Palestrante(_nome, new Matricula(_id));
			}
		}

		return null;
	}

	public static Participante cadastroParticipante() {
		JTextField nome = new JTextField(15);
		JTextField id = new JTextField(15);

		JRadioButton btnCpf = new JRadioButton("CPF:", false);
		JRadioButton btnMatricula = new JRadioButton("Matricula UFSC:", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnCpf);
		grupoId.add(btnMatricula);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(btnCpf);
		janela.add(btnMatricula);
		janela.add(id);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Participante, favor insira seus dados.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome, _id;
		_nome = nome.getText();
		_id = id.getText();

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnCpf.isSelected()) {
				try {
					return new Participante(_nome, new CPF(_id));
				} catch (BadCPFException e) {
					JOptionPane.showMessageDialog(null, "CPF Inválido");
				}
				return null;

			} else {
				return new Participante(_nome, new Matricula(_id));
			}
		}

		return null;
	}
}
