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

		while (true) {
			switch (CadastroEvento.tipoLogin()) {
			case EDITAR:

				try {
					EditaEvento.renomearEvento();
				} catch (DatabaseException e) {
					JOptionPane.showMessageDialog(null, "Erro");
				}

				break;

			case CADASTRAR:
				String nome = CadastroEvento.cadastroEvento().getNome();

				Database.createDB(nome);

				JOptionPane.showMessageDialog(null,
						"Evento \"" + nome + "\" criado");

				break;

			case LOGAR:
				Evento evento = CadastroEvento.cadastroEvento();

				try {
					Database.connectTo(evento.getNome());
				} catch (DatabaseException e) {
					JOptionPane.showMessageDialog(null, "Evento inexistente");
					evento = null;
				}

				if (evento != null) {
					TelaInicial ti = new TelaInicial(evento.getNome());

					while (ti.isVisible()) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {

						}
					}
				}

				break;
			}

		}

	}
}
