package br.com.caelum.estoque.service;

import br.com.caelum.estoque.Movimentacao;
import br.com.caelum.estoque.Produto;

public interface GeradorDeMovimentacao {

	public abstract Movimentacao geraMovimentacao(Produto produto);

}