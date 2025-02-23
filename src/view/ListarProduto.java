package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.FornecedorController;
import controller.ProdutoController;
import model.Fornecedor;
import model.Produto;

import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableFornecedor;
	private JTable tableProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProduto frame = new ListarProduto();
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
	public ListarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 163);
		contentPane.add(scrollPane);
		
		tableFornecedor = new JTable();
		tableFornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome:", "CNPJ:"
			}
		));
		tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(tableFornecedor);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 237, 414, 163);
		contentPane.add(scrollPane_1);
		
		tableProduto = new JTable();
		tableProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do Produto:", "Preço do Produto:"
			}
		));
		scrollPane_1.setViewportView(tableProduto);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarProdutos();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(303, 195, 121, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal tela = new MenuPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(303, 411, 121, 23);
		contentPane.add(btnNewButton_1);
		carregarTabelaFornecedor();
	}
	
	private void carregarTabelaFornecedor() {
		ArrayList<Fornecedor> listaFornecedor = FornecedorController.getInstancia().getListaFornecedor();
		for (Fornecedor fornecedor : listaFornecedor) {
			Object [] linha = new String[2];
			linha[0] = fornecedor.getNome();
			linha[1] = fornecedor.getCnpj();
			
			DefaultTableModel model = (DefaultTableModel) tableFornecedor.getModel();
			model.addRow(linha);
		}
	}
	
	private void carregarProdutos() {
		int indice = tableFornecedor.getSelectedRow();
		if (indice > -1) {
			
			Fornecedor forncedor = FornecedorController.getInstancia().getListaFornecedor().get(indice);
			ArrayList<Produto> listaPrdouto = forncedor.getProdutos();
			
			
			if (listaPrdouto != null && !listaPrdouto.isEmpty()) {
				DefaultTableModel model = (DefaultTableModel) tableProduto.getModel();
				model.setRowCount(0);
				for (Produto produto : listaPrdouto) {
					Object[] linha = new Object[2];
					linha[0] = produto.getNome();
					linha[1] = produto.getPreco();
					
					model.addRow(linha);
				}
			}
		}
	}

}
