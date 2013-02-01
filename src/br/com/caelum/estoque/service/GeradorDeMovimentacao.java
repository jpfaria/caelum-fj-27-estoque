package br.com.caelum.estoque.service;

import br.com.caelum.estoque.entity.Movimentacao;
import br.com.caelum.estoque.entity.Produto;

public interface GeradorDeMovimentacao {

	public abstract Movimentacao geraMovimentacao(Produto produto);

}