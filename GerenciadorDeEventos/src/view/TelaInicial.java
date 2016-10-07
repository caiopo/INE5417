package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import model.curso.Curso;
import model.curso.Evento;
import model.db.map.MapeadorCurso;

public class TelaInicial extends JFrame {
	public static int sizex = 300;
	public static int sizey = 310;

	public TelaInicial() {

		JButton btnAcompanharInscricao = new JButton("Acompanhe sua Inscrição");
		int sizeInscricaoX = 250;
		int sizeInscricaoY = 20;
		add(btnAcompanharInscricao);
		btnAcompanharInscricao.setBounds((sizex - sizeInscricaoX) / 2,
				sizey - 60, sizeInscricaoX, sizeInscricaoY);
		btnAcompanharInscricao.addActionListener((e) -> {
			VerificaInscricao.pegaIdentificador();

		});

		JButton btnCadastroCurso = new JButton("Cadastro de Curso");
		add(btnCadastroCurso);
		btnCadastroCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 140,
				sizeInscricaoX, sizeInscricaoY);
		btnCadastroCurso.addActionListener((e) -> {
			Curso c = CadastroCurso.selecionar();

			MapeadorCurso.put(c);

			// Evento.getInstance().adicionar(c);
		});

		JButton btnEditaCurso = new JButton("Edição de Curso");
		add(btnEditaCurso);
		btnEditaCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 100,
				sizeInscricaoX, sizeInscricaoY);

		JButton btnCadastroPessoa = new JButton("Cadastro de Pessoa");
		add(btnCadastroPessoa);
		btnCadastroPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 220,
				sizeInscricaoX, sizeInscricaoY);
		btnCadastroPessoa.addActionListener((e) -> {
			CadastroPessoa.selecionar();
		});

		JButton btnEditaPessoa = new JButton("Edição Pessoa");
		add(btnEditaPessoa);
		btnEditaPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 180,
				sizeInscricaoX, sizeInscricaoY);

		JButton btnCadastroLocal = new JButton("Cadastrar Local");
		add(btnCadastroLocal);
		btnCadastroLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 300,
				sizeInscricaoX, sizeInscricaoY);
		btnCadastroLocal.addActionListener((e) -> {
			CadastroLocal.selecionar();
		});

		JButton btnEdicaoLocal = new JButton("Editar Local");
		add(btnEdicaoLocal);
		btnEdicaoLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 260,
				sizeInscricaoX, sizeInscricaoY);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Gerenciador de Eventos");
		setSize(sizex, sizey);
		setVisible(true);
	}
}
