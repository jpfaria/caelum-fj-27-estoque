package br.com.caelum.estoque.repository;

import java.util.List;

import br.com.caelum.estoque.entity.Produto;

public interface Produtos {
	void salvar(Produto produuto);
	void alterar(Produto produto);
	List<Produto> listar();
	Produto buscarPorId(Long id);
	void remover(Produto produto);
	Integer estoqueAtual(Produto produto);
}
