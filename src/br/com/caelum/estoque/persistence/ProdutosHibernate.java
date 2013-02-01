package br.com.caelum.estoque.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.entity.Produto;
import br.com.caelum.estoque.repository.Produtos;

@Repository
@Primary
// define implementacao padrao no spring
@Transactional
public class ProdutosHibernate implements Produtos {

	private SessionFactory factory;

	@Autowired
	public ProdutosHibernate(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void salvar(Produto produto) {
		factory.getCurrentSession().save(produto);
	}

	@Override
	public void remover(Produto produto) {
		factory.getCurrentSession().delete(produto);
	}

	@Override
	public void alterar(Produto produto) {
		factory.getCurrentSession().update(produto);
	}

	@Override
	public List<Produto> listar() {
		@SuppressWarnings("unchecked")
		List<Produto> produtos = factory.getCurrentSession()
				.createQuery("from Produto").list();
		return produtos;
	}

	@Override
	public Produto buscarPorId(Long id) {
		return (Produto) factory.getCurrentSession().get(Produto.class,
				id);
	}

	@Override
	public Integer estoqueAtual(Produto produto) {
		Query query = factory.getCurrentSession()
				.createQuery("select quantidade from Produto where id = :pid");
		query.setParameter("pid", produto.getId());
		return (Integer) query.uniqueResult();
	}

}
