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
		try {

			Evento evento = null;

			while (true) {
				switch (CadastroEvento.tipoLogin()) {
				case EDITAR:

					try {
						EditaEvento.renomearEvento();
					} catch (DatabaseException e) {
						JOptionPane.showMessageDialog(null, "Erro");
					} catch (RuntimeException e) {

					}

					break;

				case CADASTRAR:
					try {
						evento = CadastroEvento.inputEvento();
					} catch (Exception e) {
						break;
					}

					Database.createDB(evento);

					JOptionPane.showMessageDialog(null,
							"Evento \"" + evento.getNome() + "\" criado");

					break;

				case LOGAR:
					try {
						evento = CadastroEvento.inputEvento();
					} catch (RuntimeException e) {

					}

					try {
						Database.connectTo(evento);
					} catch (DatabaseException e) {
						JOptionPane.showMessageDialog(null,
								"Não foi possível logar.");
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

				case CANCELAR:
					System.exit(0);
				}

			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}
}
