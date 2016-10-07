package view;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.curso.Curso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorPessoa;
import model.id.CPF;
import model.id.Identificador;
import model.id.Matricula;
import model.pessoa.Palestrante;
import model.pessoa.Participante;
import model.pessoa.Pessoa;

public class VisualizaPessoa {
	
	public static Pessoa visualizar() {
			
			JPanel janela = new JPanel();
			List<Pessoa> listaPessoas = MapeadorPessoa.getAll();
//			Palestrante l1 = new Palestrante("Bruno", new CPF("09132990901"));
//			Participante l2 = new Participante("Caio", new Matricula("132334456543"));
//
//			
//			List<Pessoa> listaPessoas = new ArrayList<>();
//			listaPessoas.add(l1);
//			listaPessoas.add(l2);
			String[] opcaoPessoas = new String[listaPessoas.size()];
			
			int i = 0;
			for(Pessoa pessoa: listaPessoas){
				opcaoPessoas[i] = pessoa.getNome();
				i++;
			}
			
			JComboBox comboBox = new JComboBox(opcaoPessoas);
			comboBox.setSelectedIndex(0);
			janela.add(comboBox);
	
			janela.setLayout((LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
			int botaoOk = JOptionPane.showConfirmDialog(null, janela,
					"Selecioneo curso desejado",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if (botaoOk == JOptionPane.OK_OPTION){
				return listaPessoas.get(comboBox.getSelectedIndex());
			}
			return null;
		}
}
