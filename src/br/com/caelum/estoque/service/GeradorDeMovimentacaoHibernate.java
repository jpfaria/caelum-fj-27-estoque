package br.com.caelum.estoque.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.Movimentacao;
import br.com.caelum.estoque.Produto;
import br.com.caelum.estoque.TipoDeMovimento;
import br.com.caelum.estoque.dao.ProdutoDAO;

@Service
@Transactional
@Primary
public class GeradorDeMovimentacaoHibernate implements GeradorDeMovimentacao {

	private final ProdutoDAO produtoDAO;

	@Autowired
	public GeradorDeMovimentacaoHibernate(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	/* (non-Javadoc)
	 * @see br.com.caelum.estoque.service.GeradorDeMovimentacao#geraMovimentacao(br.com.caelum.estoque.Produto)
	 */
	@Override
	public Movimentacao geraMovimentacao(Produto produto) {
		
		Movimentacao mov = new Movimentacao();
		mov.setData(Calendar.getInstance());
		mov.setProduto(produto);

		Integer quantidadeAtual = produtoDAO.estoqueAtual(produto);
		if (produto.getQuantidade() > quantidadeAtual) {
			mov.setTipo(TipoDeMovimento.ENTRADA);
		} else {
			mov.setTipo(TipoDeMovimento.SAIDA);
		}

		mov.setQuantidade(Math.abs(produto.getQuantidade() - quantidadeAtual));
		return mov;

	}

}
