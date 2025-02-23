package controller;

import java.util.ArrayList;

import model.Fornecedor;
import model.Produto;

public class ProdutoController {
	
	private static ProdutoController instancia;
	
	public static ProdutoController getInstancia() {
		if (instancia == null) {
			FornecedorController fornecedorController = FornecedorController.getInstancia();
			instancia = new ProdutoController(fornecedorController);
		}
		return instancia;
	}
	
	private FornecedorController fornecedorController;
	
	public ProdutoController(FornecedorController fornecedorController) {
		this.fornecedorController = fornecedorController;
	}
	
	public void cadastrarProduto(String cnpj, String nome, double preco) {
		Produto produto = new Produto(nome, preco);
		Fornecedor fornecedor = fornecedorController.buscarFornecedor(cnpj);
		if (fornecedor != null) {
			if (fornecedor.getProdutos() == null) {
				fornecedor.setProdutos(new ArrayList<>());
			}
			fornecedor.getProdutos().add(produto);
		}
	}
	
	
	public String listarProduto(String cnpj, String nome, Double preco) {
		Fornecedor fornecedor = fornecedorController.buscarFornecedor(nome);
		if (fornecedor != null) {
			if (fornecedor.getProdutos() != null) {
				return mostrarProduto(fornecedor.getProdutos());
			} else {
				return "O Fornecedor não possui produtos cadastradas";
			}
		} else {
			return "O Fornecedor não foi encontrado";
		}
	}
	
	private String mostrarProduto(ArrayList<Produto> produtos) {
		String listaEmTexto = "";
		for (Produto produto : produtos) {
			listaEmTexto += "- " + produto.getNome() + " " + produto.getPreco();
			listaEmTexto += "\n";
		}
		return listaEmTexto;
	}

}
