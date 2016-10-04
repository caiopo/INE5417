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

		JButton acompanharInscricao = new JButton("Acompanhe sua Inscrição");
		int sizeInscricaoX = 250;
		int sizeInscricaoY = 20;
		add(acompanharInscricao);
		acompanharInscricao.setBounds((sizex - sizeInscricaoX) / 2, sizey - 60, sizeInscricaoX, sizeInscricaoY);

		JButton btnCadastroCurso = new JButton("Cadastro de Curso");
		add(btnCadastroCurso);
		btnCadastroCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 140, sizeInscricaoX, sizeInscricaoY);

		JButton btnEditaCurso = new JButton("Edição de Curso");
		add(btnEditaCurso);
		btnEditaCurso.setBounds((sizex - sizeInscricaoX) / 2, sizey - 100, sizeInscricaoX, sizeInscricaoY);

		JButton btnCadastroPessoa = new JButton("Cadastro de Pessoa");
		add(btnCadastroPessoa);
		btnCadastroPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 220, sizeInscricaoX, sizeInscricaoY);

		JButton btnEditaPessoa = new JButton("Edição Pessoa");
		add(btnEditaPessoa);
		btnEditaPessoa.setBounds((sizex - sizeInscricaoX) / 2, sizey - 180, sizeInscricaoX, sizeInscricaoY);
		btnCadastroPessoa.addActionListener((e) -> {
			CadastroPessoa.selecionar();
		});
		
		JButton btnCadastroLocal = new JButton("Cadastro Local");
		add(btnCadastroLocal);
		btnCadastroLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 260, sizeInscricaoX, sizeInscricaoY);

		JButton btnEdicaoLocal = new JButton("Editar Local");
		add(btnEdicaoLocal);
		btnEdicaoLocal.setBounds((sizex - sizeInscricaoX) / 2, sizey - 300, sizeInscricaoX, sizeInscricaoY);

		setLayout(null);
		setTitle("Gerenciador de Eventos");
		setSize(sizex, sizey);
		setVisible(true);
	}
}
