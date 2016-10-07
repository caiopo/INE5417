package view;



import javax.swing.JButton;
import javax.swing.JFrame;
import model.curso.Curso;
import model.curso.Evento;

public class TelaInicial extends JFrame {
	public static int sizex = 300;
	public static int sizey = 370;

	public TelaInicial() {
		
		JButton btnAcompanharInscricao = new JButton("Acompanhe sua Inscrição");
		int sizeInscricaoX = 250;
		int sizeInscricaoY = 20;
		add(btnAcompanharInscricao);
		btnAcompanharInscricao.setBounds((sizex - sizeInscricaoX) / 2, sizey - 60, sizeInscricaoX, sizeInscricaoY);
		btnAcompanharInscricao.addActionListener((e) -> {
			VerificaInscricao.pegaIdentificador();
			
		});

		JButton btnCadastroCurso = new JButton("Cadastro de Curso");
		add(btnCadastroCurso);
		btnCadastroCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 200, sizeInscricaoX, sizeInscricaoY);
		btnCadastroCurso.addActionListener((e) -> {
			Curso c = CadastroCurso.selecionar();
			Evento.getInstance().adicionar(c);
		});
		
		JButton btnEditaCurso = new JButton("Edição de Curso");
		add(btnEditaCurso);
		btnEditaCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 160, sizeInscricaoX, sizeInscricaoY);

		JButton btnCadastroPessoa = new JButton("Cadastro de Pessoa");
		add(btnCadastroPessoa);
		btnCadastroPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 280, sizeInscricaoX, sizeInscricaoY);
		btnCadastroPessoa.addActionListener((e) -> {
			CadastroPessoa.selecionar();
		});
		
		JButton btnEditaPessoa = new JButton("Edição Pessoa");
		add(btnEditaPessoa);
		btnEditaPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 240, sizeInscricaoX, sizeInscricaoY);

		
		JButton btnCadastroLocal = new JButton("Cadastrar Local");
		add(btnCadastroLocal);
		btnCadastroLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 360, sizeInscricaoX, sizeInscricaoY);
		btnCadastroLocal.addActionListener((e) -> {
			CadastroLocal.selecionar();
		});
		
		JButton btnVisualizarLocal = new JButton("Visualizar Local");
		add(btnVisualizarLocal);
		btnVisualizarLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 320, sizeInscricaoX, sizeInscricaoY);
		btnVisualizarLocal.addActionListener((e) -> {
			VisualizarLocal.visualizar();
		});

		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("Gerenciador de Eventos");
		setSize(sizex, sizey);
		setVisible(true);
	}
}
