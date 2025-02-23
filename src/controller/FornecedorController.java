package controller;

import java.util.ArrayList;

import model.Fornecedor;

public class FornecedorController {
	
	private static FornecedorController instancia;
	
	public static FornecedorController getInstancia() {
		if (instancia == null) {
			instancia = new FornecedorController();
		}
		return instancia;
	}
	
	private ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
	
	public ArrayList<Fornecedor> getListaFornecedor () {
		return listaFornecedor;
	}
	
	public void cadastrarFornecedor(String nome, String cnpj, String endereco, String telefone) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEndereco(endereco);
		fornecedor.setTelefone(telefone);
		
		
		listaFornecedor.add(fornecedor);
	}
	
	public String listarFornecedor() {
		String listaEmTexto = "";
		if (listaFornecedor.isEmpty()) {
			return "Ainda não foi cadastrado nenhum fornecedor.";
		}
		
		for (Fornecedor fornecedor : listaFornecedor) {
			listaEmTexto += "- " + fornecedor.getCnpj() + " - " + fornecedor.getNome();
			listaEmTexto += "\n";
		}
		return listaEmTexto;
	}
	
	public boolean excluirFornecedor(String cnpj) {
		for (int i = 0; i < listaFornecedor.size(); i++) {
			Fornecedor fornecedor = listaFornecedor.get(i);
			if (cnpj == fornecedor.getNome()) {
				listaFornecedor.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Fornecedor buscarFornecedor(String cnpj) {
		for (Fornecedor fornecedor : listaFornecedor) {
			if (cnpj == fornecedor.getCnpj()) {
				return fornecedor;
			}
		}
		return null;
	}

}
