package main;

import javax.swing.JOptionPane;

import exceptions.DatabaseException;
import model.curso.Evento;
import model.db.Database;
import view.CadastroEvento;
import view.EditaEvento;
import view.TelaInicial;

public class Main {

	public static void main(String[] args) {

		Evento evento = null;

		switch (CadastroEvento.tipoLogin()) {
		case EDITAR:
			String[] dbs = EditaEvento.renomearEvento();

			try {
				Database.renameDB(dbs[0], dbs[1]);
			} catch (DatabaseException e) {
				JOptionPane.showMessageDialog(null, "Evento inexistente");
				System.exit(1);
			}

			break;

		case CADASTRAR:
			evento = CadastroEvento.cadastroEvento();

			Database.createDB(evento.getNome());
			Database.connectTo(evento.getNome());

			break;

		case LOGAR:
			evento = CadastroEvento.cadastroEvento();

			try {
				Database.connectTo(evento.getNome());
			} catch (DatabaseException e) {
				JOptionPane.showMessageDialog(null, "Evento inexistente");
				System.exit(1);
			}

			break;

		}

		if (evento != null) {
			new TelaInicial(evento.getNome());
		}
	}
}
