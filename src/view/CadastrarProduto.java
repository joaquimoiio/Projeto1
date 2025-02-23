package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FornecedorController;
import controller.ProdutoController;
import model.Fornecedor;
import model.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastrarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProduto;
	private JTextField textNomeProduto;
	private JTextField textPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProduto frame = new CadastrarProduto();
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
	public CadastrarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 33, 400, 230);
		contentPane.add(scrollPane);
		
		tableProduto = new JTable();
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome:", "CNPJ:"
			}
		));
		scrollPane.setViewportView(tableProduto);
		
		JLabel lblNewLabel = new JLabel("Nome do produto");
		lblNewLabel.setBounds(10, 280, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPreoDoProduto = new JLabel("Preço do produto");
		lblPreoDoProduto.setBounds(10, 310, 100, 20);
		contentPane.add(lblPreoDoProduto);
		
		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(120, 280, 130, 20);
		contentPane.add(textNomeProduto);
		textNomeProduto.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(120, 310, 130, 20);
		contentPane.add(textPreco);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal tela = new MenuPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(210, 352, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarProduto();
				MenuPrincipal tela = new MenuPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnSalvar.setBounds(309, 352, 89, 23);
		contentPane.add(btnSalvar);
		carregarTabela();
	}
	
	private void carregarTabela() {
		ArrayList<Fornecedor> listaFornecedor = FornecedorController.getInstancia().getListaFornecedor();
		for (Fornecedor fornecedor : listaFornecedor) {
			Object [] linha = new Object[2];
			linha [0] = fornecedor.getNome();
			linha [1] = fornecedor.getCnpj();
			
			DefaultTableModel model = (DefaultTableModel) tableProduto.getModel();
			model.addRow(linha);
		}
	}
	
	private void cadastrarProduto() {
		String NomeProduto = textNomeProduto.getText();
		String precoTexto = textPreco.getText();
		double preco = Double.parseDouble(precoTexto);
		
		int indice = tableProduto.getSelectedRow();
		if (indice > -1) {
			Fornecedor fornecedor = FornecedorController.getInstancia().getListaFornecedor().get(indice);
			ProdutoController.getInstancia().cadastrarProduto(fornecedor.getCnpj(),NomeProduto,preco);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum Fornecedor Selecionado");
		}
	}
}
