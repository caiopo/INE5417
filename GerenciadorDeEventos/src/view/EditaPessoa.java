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

public class EditaPessoa {
	
	
	public static void editarPalestrante(Palestrante palestrante) {
		JTextField fieldNome = new JTextField(15);
		JTextField fieldId = new JTextField(15);

		JRadioButton btnCpf = new JRadioButton("CPF:", false);
		JRadioButton btnMatricula = new JRadioButton("Matricula UFSC:", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnCpf);
		grupoId.add(btnMatricula);

		fieldNome.setText(palestrante.getNome());
		fieldId.setText(palestrante.getId().get());

		if (palestrante.getId() instanceof CPF) {
			btnCpf.setSelected(true);
		} else {
			btnMatricula.setSelected(true);
		}

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(btnCpf);
		janela.add(btnMatricula);
		janela.add(fieldId);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Editar Palestrante", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnCpf.isSelected()) {
				try {
					palestrante.setId(new CPF(fieldId.getText()));
				} catch (BadCPFException e) {
					JOptionPane.showMessageDialog(null, "CPF Inválido");
				}
			} else if (btnMatricula.isSelected()) {
				palestrante.setId(new Matricula(fieldId.getText()));
			}

			palestrante.setNome(fieldNome.getText());
		}
	}

	public static void editarParticipante(Participante participante) {
		JTextField fieldNome = new JTextField(15);
		JTextField fieldId = new JTextField(15);

		JRadioButton btnCpf = new JRadioButton("CPF:", false);
		JRadioButton btnMatricula = new JRadioButton("Matricula UFSC:", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnCpf);
		grupoId.add(btnMatricula);

		fieldNome.setText(participante.getNome());
		fieldId.setText(participante.getId().get());

		if (participante.getId() instanceof CPF) {
			btnCpf.setSelected(true);
		} else {
			btnMatricula.setSelected(true);
		}

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(btnCpf);
		janela.add(btnMatricula);
		janela.add(fieldId);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Editar Participante", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnCpf.isSelected()) {
				try {
					participante.setId(new CPF(fieldId.getText()));
				} catch (BadCPFException e) {
					JOptionPane.showMessageDialog(null, "CPF Inválido");
				}
			} else if (btnMatricula.isSelected()) {
				participante.setId(new Matricula(fieldId.getText()));
			}

			participante.setNome(fieldNome.getText());
		}
	}

}
