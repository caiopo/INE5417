package view;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.curso.Curso;
import model.db.map.MapeadorCurso;
import model.db.map.MapeadorLocal;
import model.db.map.MapeadorPessoa;
import model.local.Local;
import model.pessoa.Pessoa;
import model.utils.Inscricao;
import model.utils.Presenca;

public class TelaInicial extends JFrame {
	private static final int SIZE_X = 350;
	private static final int SIZE_Y = 500;

	private static final int BUTTON_WIDTH = 330;
	private static final int BUTTON_HEIGHT = 30;

	public TelaInicial(String title) {

		JButton btnAcompanharInscricao = new JButton("Acompanhe sua Inscrição");
		add(btnAcompanharInscricao);
		btnAcompanharInscricao.setBounds((SIZE_X - BUTTON_WIDTH) / 2,
				SIZE_Y - 80, BUTTON_WIDTH, BUTTON_HEIGHT);
		btnAcompanharInscricao.addActionListener((e) -> {
			Inscricao.inscricao();
		});

		JButton btnCadastroCurso = new JButton("Cadastro de Curso");
		add(btnCadastroCurso);
		btnCadastroCurso.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 200,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnCadastroCurso.addActionListener((e) -> {
			Curso curso = CadastroCurso.selecionar();

			if (curso != null)
				MapeadorCurso.put(curso);
		});

		JButton btnEditaCurso = new JButton("Edição de Curso");
		add(btnEditaCurso);
		btnEditaCurso.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 160,
				BUTTON_WIDTH, BUTTON_HEIGHT);

		JButton btnCadastroPessoa = new JButton("Cadastro de Pessoa");
		add(btnCadastroPessoa);
		btnCadastroPessoa.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 280,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnCadastroPessoa.addActionListener((e) -> {
			Pessoa pessoa = CadastroPessoa.selecionar();

			if (pessoa != null)
				MapeadorPessoa.put(pessoa);
		});

		JButton btnEditaPessoa = new JButton("Edição Pessoa");
		add(btnEditaPessoa);
		btnEditaPessoa.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 240,
				BUTTON_WIDTH, BUTTON_HEIGHT);

		JButton btnCadastroLocal = new JButton("Cadastrar Local");
		add(btnCadastroLocal);
		btnCadastroLocal.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 360,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnCadastroLocal.addActionListener((e) -> {
			Local local = CadastroLocal.selecionar();

			if (local != null)
				MapeadorLocal.put(local);
		});

		JButton btnVisualizarLocal = new JButton("Editar/Visualizar Local");
		add(btnVisualizarLocal);
		btnVisualizarLocal.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 320,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnVisualizarLocal.addActionListener((e) -> {
			VisualizaLocal.visualizar();
		});

		JButton btnVisualizarCurso = new JButton("Visualizar Curso");
		add(btnVisualizarCurso);
		btnVisualizarCurso.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 120,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnVisualizarCurso.addActionListener((e) -> {
			VisualizaCurso.visualizar();
		});

		JButton btnVisualizarPessoa = new JButton("Visualizar Pessoa");
		add(btnVisualizarPessoa);
		btnVisualizarPessoa.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 400,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnVisualizarPessoa.addActionListener((e) -> {
			VisualizaPessoa.visualizar();
		});

		JButton btnMarcarPresenca = new JButton("Registrar presença");
		add(btnMarcarPresenca);
		btnMarcarPresenca.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 440,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnMarcarPresenca.addActionListener((e) -> {
			Presenca.registrar();
		});

		JButton btnVerPresenca = new JButton("Ver presença");
		add(btnVerPresenca);
		btnVerPresenca.setBounds((SIZE_X - BUTTON_WIDTH) / 2, SIZE_Y - 480,
				BUTTON_WIDTH, BUTTON_HEIGHT);
		btnVerPresenca.addActionListener((e) -> {
			Presenca.visualizar();
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setTitle("Gerenciador de Eventos: " + title);
		setSize(SIZE_X, SIZE_Y);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
