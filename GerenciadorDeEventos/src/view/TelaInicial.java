package view;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaInicial extends JFrame {
	public static int sizex = 300;
	public static int sizey = 310;

	public TelaInicial() {

		JButton btnAcompanharInscricao = new JButton("Acompanhe sua Inscrição");
		int sizeInscricaoX = 250;
		int sizeInscricaoY = 20;
		add(btnAcompanharInscricao);
		btnAcompanharInscricao.setBounds((sizex - sizeInscricaoX) / 2, sizey - 60, sizeInscricaoX, sizeInscricaoY);
		btnAcompanharInscricao.addActionListener((e) -> {
			
		});

		JButton btnCadastroCurso = new JButton("Cadastro de Curso");
		add(btnCadastroCurso);
		btnCadastroCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 140, sizeInscricaoX, sizeInscricaoY);
		btnCadastroCurso.addActionListener((e) -> {
			CadastroCurso.selecionar();
		});
		
		JButton btnEditaCurso = new JButton("Edição de Curso");
		add(btnEditaCurso);
		btnEditaCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 100, sizeInscricaoX, sizeInscricaoY);

		JButton btnCadastroPessoa = new JButton("Cadastro de Pessoa");
		add(btnCadastroPessoa);
		btnCadastroPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 220, sizeInscricaoX, sizeInscricaoY);
		btnCadastroPessoa.addActionListener((e) -> {
			CadastroPessoa.selecionar();
		});
		
		JButton btnEditaPessoa = new JButton("Edição Pessoa");
		add(btnEditaPessoa);
		btnEditaPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 180, sizeInscricaoX, sizeInscricaoY);

		
		JButton btnCadastroLocal = new JButton("Cadastrar Local");
		add(btnCadastroLocal);
		btnCadastroLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 300, sizeInscricaoX, sizeInscricaoY);
		btnCadastroLocal.addActionListener((e) -> {
			CadastroLocal.selecionar();
		});

		JButton btnEdicaoLocal = new JButton("Editar Local");
		add(btnEdicaoLocal);
		btnEdicaoLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 260, sizeInscricaoX, sizeInscricaoY);

		setLayout(null);
		setTitle("Gerenciador de Eventos");
		setSize(sizex, sizey);
		setVisible(true);
	}
}
