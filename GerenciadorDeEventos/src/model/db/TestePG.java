package model.db;

import java.util.List;

import model.curso.Curso;
import model.curso.Minicurso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorPessoa;
import model.id.Matricula;
import model.pessoa.Palestrante;
import model.pessoa.Participante;
import model.pessoa.Pessoa;

public class TestePG {

	public static void main(String[] args) {
		// System.out.println(SQLStrings.DB_DROP);

		Database.init("seccom");

		Database db = Database.getInstance();

		Palestrante p = new Palestrante("testepalestrante",
				new Matricula("11111111"));

		Curso c = new Minicurso("teste", null, null, p, 20);

		for (int i = 0; i < 10; i++) {
			c.adicionaParticipante(new Participante("hello",
					new Matricula(Integer.toString(i))));
		}

		System.out.println(c.getOID());

		System.out.println("putting");
		MapeadorCurso.put(c);

		System.out.println(c.getOID());

		List<Pessoa> lp = MapeadorPessoa.getAll();

		lp.stream().forEach(pess -> {
			System.out.println(pess.getOID());
		});

	}

}
