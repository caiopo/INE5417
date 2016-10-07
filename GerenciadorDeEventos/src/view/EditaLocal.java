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
		fieldCapacidade.setText("" + auditorio.getCapacidade());

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
			// chama o update
		}

	}

	public static void editarSalaDeAula(SalaDeAula salaDeAula) {

		JTextField fieldNome = new JTextField(15);
		JTextField fieldCapacidade = new JTextField(15);

		fieldNome.setText(salaDeAula.getNome());
		fieldCapacidade.setText("" + salaDeAula.getCapacidade());

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
			// chama o update
		}

	}

	public static void editarLaboratorio(Laboratorio laboratorio) {

		JTextField fieldNome = new JTextField(15);
		JTextField fieldCapacidade = new JTextField(15);
		JTextField fieldNcomp = new JTextField(15);

		fieldNome.setText(laboratorio.getNome());
		fieldCapacidade.setText("" + laboratorio.getCapacidade());
		fieldNcomp.setText("" + laboratorio.getNumeroDeComputadores());

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(fieldNome);
		janela.add(new JLabel("Capacidade:"));
		janela.add(fieldCapacidade);
		janela.add(new JLabel("Número de Computadores:"));
		janela.add(fieldNcomp);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Editar Local", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (botaoOk == JOptionPane.OK_OPTION) {
			// chama o update
		}

	}
}