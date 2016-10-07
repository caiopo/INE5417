package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import model.db.map.MapeadorLocal;
import model.local.Auditorio;
import model.local.Laboratorio;
import model.local.Local;
import model.local.SalaDeAula;

public class VisualizarLocal {
	
	public static Local visualizar() {
		
		JPanel janela = new JPanel();
		JButton btnEditar = new JButton("Editar Local");
		List<Local> listaLocais = MapeadorLocal.getAll();
//		SalaDeAula l1 = new SalaDeAula("Sala203", 20);
//		Auditorio l2 = new Auditorio("AudiorioEPS", 12);
//		Laboratorio l3 = new Laboratorio("LabLIICT", 20, 20);
//		
//		List<Local> listaLocais = new ArrayList<>();
//		listaLocais.add(l1);
//		listaLocais.add(l2);
//		listaLocais.add(l3);
		
		String[] opcaoLocais = new String[listaLocais.size()];
		
		int i = 0;
		for(Local local : listaLocais){
			opcaoLocais[i] = local.getNome();
			i++;
		}
		
		JComboBox comboBox = new JComboBox(opcaoLocais);
		comboBox.setSelectedIndex(0);
		btnEditar.addActionListener((e) -> {
		if( listaLocais.get(comboBox.getSelectedIndex()) instanceof Auditorio) {
			EditaLocal.editarAuditorio((Auditorio) listaLocais.get(comboBox.getSelectedIndex()));
		} else if (listaLocais.get(comboBox.getSelectedIndex()) instanceof SalaDeAula) {
			EditaLocal.editarSalaDeAula((SalaDeAula) listaLocais.get(comboBox.getSelectedIndex()));
		} else {
			EditaLocal.editarLaboratorio((Laboratorio) listaLocais.get(comboBox.getSelectedIndex()));
		}

		});
		
		janela.add(comboBox);
		janela.add(btnEditar);
		janela.setLayout((LayoutManager) new BoxLayout(janela, BoxLayout.X_AXIS));
		int botaoOk = JOptionPane.showConfirmDialog(null, janela,
				"Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (botaoOk == JOptionPane.OK_OPTION){
		}
		return null;
	}

}
