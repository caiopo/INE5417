package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
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

public class CadastroUsuario extends JFrame {

	public CadastroUsuario() {
		
	}
	
	public Palestrante cadastroPalestrante() {
		JTextField nome = new JTextField(15);
		JTextField id = new JTextField(15);
		
		JRadioButton btnCpf = new JRadioButton("CPF:", false);
		JRadioButton btnMatricula = new JRadioButton("Matricula UFSC:", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnCpf);
		grupoId.add(btnMatricula);

		JPanel janela = new JPanel();
		janela.setLayout((LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
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
			if(btnCpf.isSelected()) {
				CPF _cpf = null;
				try {
					_cpf = new CPF(_id);
				} catch (BadCPFException e) {
					JOptionPane.showMessageDialog(null, "CPF Inválido");				}
				return new Palestrante(_nome, _cpf); 
			} else {
				return new Palestrante(_nome, new Matricula(_id));
			}
		} else {
			return null;
		}
	}
	
	public Participante cadastroParticipante() {
		JTextField nome = new JTextField(15);
		JTextField id = new JTextField(15);
		
		JRadioButton btnCpf = new JRadioButton("CPF:", false);
		JRadioButton btnMatricula = new JRadioButton("Matricula UFSC:", false);
		ButtonGroup grupoId = new ButtonGroup();
		grupoId.add(btnCpf);
		grupoId.add(btnMatricula);

		JPanel janela = new JPanel();
		janela.setLayout((LayoutManager) new BoxLayout(janela, BoxLayout.Y_AXIS));
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
			if(btnCpf.isSelected()) {
				CPF _cpf = null;
				try {
					_cpf = new CPF(_id);
				} catch (BadCPFException e) {
					JOptionPane.showMessageDialog(null, "CPF Inválido");
				}
				return new Participante(_nome, _cpf);
			} else {
				return new Participante(_nome, new Matricula(_id));
			}
		} else {
			return null;
		}
	}
}
