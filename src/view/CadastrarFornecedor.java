package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.FornecedorController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarFornecedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCnpj;
	private JTextField textEndereco;
	private JTextField textTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFornecedor frame = new CadastrarFornecedor();
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
	public CadastrarFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCnpj = new JLabel("CNJP:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCnpj.setBounds(10, 60, 46, 14);
		contentPane.add(lblCnpj);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereo.setBounds(10, 110, 131, 19);
		contentPane.add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 165, 131, 19);
		contentPane.add(lblTelefone);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNome.setBounds(10, 30, 243, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCnpj = new JTextField();
		textCnpj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCnpj.setColumns(10);
		textCnpj.setBounds(10, 85, 243, 20);
		contentPane.add(textCnpj);
		
		textEndereco = new JTextField();
		textEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEndereco.setColumns(10);
		textEndereco.setBounds(10, 140, 243, 20);
		contentPane.add(textEndereco);
		
		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTelefone.setColumns(10);
		textTelefone.setBounds(10, 195, 243, 20);
		contentPane.add(textTelefone);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarFornecedor();
				MenuPrincipal tela = new MenuPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(172, 371, 81, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal tela = new MenuPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(81, 373, 81, 23);
		contentPane.add(btnVoltar);
	}
	
	private void cadastrarFornecedor() {
		String nome = textNome.getText();
		String cpf = textCnpj.getText();
		String endereco = textEndereco.getText();
		String telefone = textTelefone.getText();
		
		FornecedorController.getInstancia().cadastrarFornecedor(nome,cpf,endereco,telefone);
	}
}
