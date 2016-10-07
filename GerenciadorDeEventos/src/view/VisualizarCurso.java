package view;

import java.awt.LayoutManager;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.curso.Curso;
import model.curso.Minicurso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorLocal;
import model.local.Auditorio;
import model.local.Laboratorio;
import model.local.Local;
import model.local.SalaDeAula;

public class VisualizarCurso {
	
public static Curso visualizar() {
		
		JPanel janela = new JPanel();
		List<Curso> listaCursos = MapeadorCurso.getAll();
		
		String[] opcaoCursos = new String[listaCursos.size()];
		
		int i = 0;
		for(Curso curso : listaCursos){
			opcaoCursos[i] = curso.getNome();
			i++;
		}
		
		JComboBox comboBox = new JComboBox(opcaoCursos);
		comboBox.setSelectedIndex(0);
		janela.add(comboBox);

		janela.setLayout((LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecioneo curso desejado",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (botaoOk == JOptionPane.OK_OPTION){
			return listaCursos.get(comboBox.getSelectedIndex());
		}
		return null;
	}
}
