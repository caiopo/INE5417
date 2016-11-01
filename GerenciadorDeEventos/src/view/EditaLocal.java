package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.local.Auditorio;
import model.local.Laboratorio;
import model.local.Local;
import model.local.SalaDeAula;

public class EditaLocal {

	public static void editar(Local local) {
		if (local instanceof Auditorio) {
			EditaLocal.editarAuditorio((Auditorio) local);
		} else if (local instanceof SalaDeAula) {
			EditaLocal.editarSalaDeAula((SalaDeAula) local);
		} else {
			EditaLocal.editarLaboratorio((Laboratorio) local);
		}
	}

	public static void editarAuditorio(Auditorio auditorio) {

		JTextField fieldNome = new JTextField(15);
		JTextField fieldCapacidade = new JTextField(15);

		fieldNome.setText(auditorio.getNome());
		fieldCapacidade.setText(Integer.toString(auditorio.getCapacidade()));

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(new JLabel("Capacidade:"));
		janela.add(fieldCapacidade);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Editar Local", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {

			auditorio.setNome(fieldNome.getText());
			auditorio
					.setCapacidade(Integer.parseInt(fieldCapacidade.getText()));
		}

	}

	public static void editarSalaDeAula(SalaDeAula salaDeAula) {

		JTextField fieldNome = new JTextField(15);
		JTextField fieldCapacidade = new JTextField(15);

		fieldNome.setText(salaDeAula.getNome());
		fieldCapacidade.setText(Integer.toString(salaDeAula.getCapacidade()));

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(new JLabel("Capacidade:"));
		janela.add(fieldCapacidade);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Editar Local", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {

			salaDeAula.setNome(fieldNome.getText());
			salaDeAula
					.setCapacidade(Integer.parseInt(fieldCapacidade.getText()));
		}

	}

	public static void editarLaboratorio(Laboratorio laboratorio) {

		JTextField fieldNome = new JTextField(15);
		JTextField fieldCapacidade = new JTextField(15);
		JTextField fieldNComp = new JTextField(15);

		fieldNome.setText(laboratorio.getNome());
		fieldCapacidade.setText(Integer.toString(laboratorio.getCapacidade()));
		fieldNComp.setText(
				Integer.toString(laboratorio.getNumeroDeComputadores()));

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(new JLabel("Capacidade:"));
		janela.add(fieldCapacidade);
		janela.add(new JLabel("Número de Computadores:"));
		janela.add(fieldNComp);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Editar Local", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {

			laboratorio.setNome(fieldNome.getText());
			laboratorio
					.setCapacidade(Integer.parseInt(fieldCapacidade.getText()));

			laboratorio.setNumeroDeComputadores(
					Integer.parseInt(fieldNComp.getText()));
		}

	}
}