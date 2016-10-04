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
import model.local.Auditorio;
import model.local.Laboratorio;
import model.local.Local;
import model.local.SalaDeAula;
import model.pessoa.Palestrante;

public class CadastroLocal {
	
	public static Local selecionar() {
		JRadioButton btnAuditorio = new JRadioButton("Auditório", true);
		JRadioButton btnLaboratorio = new JRadioButton("Laboratório", false);
		JRadioButton btnSalaDeAula = new JRadioButton("Sala de Aula", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnAuditorio);
		grupoId.add(btnLaboratorio);
		grupoId.add(btnSalaDeAula);
		JPanel janela = new JPanel();
		janela.add(btnAuditorio);
		janela.add(btnLaboratorio);
		janela.add(btnSalaDeAula);
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (botaoOk == JOptionPane.OK_OPTION) {
			if (btnAuditorio.isSelected()) {
				return cadastroAuditorio();
			} else if(btnLaboratorio.isSelected()) {
				return cadastroLaboratorio();
			} else {
				return cadastroSalaDeAula();
			}
		}
		return null;
	}
	
	public static Auditorio cadastroAuditorio() {
		JTextField nome = new JTextField(15);
		JTextField capacidade = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(new JLabel("Capacidade"));
		janela.add(capacidade);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Insira as informações do local.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome;
		int _capacidade;
		_nome = nome.getText();
		_capacidade = Integer.parseInt(capacidade.getText());

		if (botaoOk == JOptionPane.OK_OPTION) {
			return new Auditorio(_nome, _capacidade);
		} else {
			return null;
		}
	}

	public static Laboratorio cadastroLaboratorio() {
		JTextField nome = new JTextField(15);
		JTextField capacidade = new JTextField(15);
		JTextField nComp = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(new JLabel("Capacidade"));
		janela.add(capacidade);
		janela.add(new JLabel("Número de Computadores"));
		janela.add(nComp);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Insira as informações do local.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome;
		int _capacidade, _nComp;
		_nome = nome.getText();
		_capacidade = Integer.parseInt(capacidade.getText());
		_nComp = Integer.parseInt(nComp.getText());

		if (botaoOk == JOptionPane.OK_OPTION) {
			return new Laboratorio(_nome, _capacidade, _nComp);
		} else {
			return null;
		}
	}
	
	public static SalaDeAula cadastroSalaDeAula() {
		JTextField nome = new JTextField(15);
		JTextField capacidade = new JTextField(15);

		JPanel janela = new JPanel();
		janela.setLayout(
				(LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
		janela.add(new JLabel("Nome:"));
		janela.add(nome);
		janela.add(new JLabel("Capacidade"));
		janela.add(capacidade);

		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Insira as informações do local.",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		String _nome;
		int _capacidade;
		_nome = nome.getText();
		_capacidade = Integer.parseInt(capacidade.getText());


		if (botaoOk == JOptionPane.OK_OPTION) {
			return new SalaDeAula(_nome, _capacidade);
		} else {
			return null;
		}
	}
}
