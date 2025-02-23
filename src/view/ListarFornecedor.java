package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.util.ArrayList;
import controller.FornecedorController;
import model.Fornecedor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarFornecedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFornecedor frame = new ListarFornecedor();
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
	public ListarFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 414, 239);
		contentPane.add(scrollPane);
		
		tableFornecedor = new JTable();
		tableFornecedor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome:", "CNPJ:"
			}
		));
		tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tableFornecedor);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal tela = new MenuPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(349, 272, 75, 23);
		contentPane.add(btnSair);
		
		JButton btnExcluirFornecedor = new JButton("Excluir Fornecedor");
		btnExcluirFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnExcluirFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = tableFornecedor.getSelectedRow();
				if (indice > -1) {
					FornecedorController.getInstancia().getListaFornecedor().remove(indice);
					
					DefaultTableModel model = (DefaultTableModel) tableFornecedor.getModel();
					model.removeRow(indice);
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum registro selecionado.");
				}
				
			}
		});
		btnExcluirFornecedor.setBounds(221, 272, 118, 23);
		contentPane.add(btnExcluirFornecedor);
		carregarTabela();
	}

	
	private void carregarTabela() {
		ArrayList<Fornecedor> listaFornecedor = FornecedorController.getInstancia().getListaFornecedor();
		for (Fornecedor fornecedor : listaFornecedor) {
			Object [] linha = new String[3];
			linha[0] = fornecedor.getNome();
			linha[1] = fornecedor.getCnpj();
			linha[2] = fornecedor.getTelefone();
			
			DefaultTableModel model = (DefaultTableModel) tableFornecedor.getModel();
			model.addRow(linha);
		}
	}
	
}

