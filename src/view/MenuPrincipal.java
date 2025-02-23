package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 202, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Fornecedor");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFornecedor tela = new CadastrarFornecedor();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCadastrarAluno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrarAluno.setBounds(10, 11, 163, 23);
		contentPane.add(btnCadastrarAluno);
		
		JButton btnListarAluno = new JButton("Listar Fornecedor");
		btnListarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarFornecedor tela = new ListarFornecedor();
				tela.setVisible(true);
				dispose();
			}
		});
		btnListarAluno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListarAluno.setBounds(10, 45, 163, 23);
		contentPane.add(btnListarAluno);
		
		JButton btnCadastraAvaliacao = new JButton("Cadastrar Produto");
		btnCadastraAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto tela = new CadastrarProduto();
				tela.setVisible(true);
				dispose();
				
			}
		});
		btnCadastraAvaliacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastraAvaliacao.setBounds(10, 79, 163, 23);
		contentPane.add(btnCadastraAvaliacao);
		
		JButton btnListarAvaliacao = new JButton("Listar Produto");
		btnListarAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProduto tela = new ListarProduto();
				tela.setVisible(true);
				dispose();
			}
		});
		btnListarAvaliacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListarAvaliacao.setBounds(10, 113, 163, 23);
		contentPane.add(btnListarAvaliacao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSair.setBounds(103, 209, 70, 23);
		contentPane.add(btnSair);
	}

}
