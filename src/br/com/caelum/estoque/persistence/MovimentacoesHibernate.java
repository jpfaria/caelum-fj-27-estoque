package br.com.caelum.estoque.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.entity.Movimentacao;
import br.com.caelum.estoque.repository.Movimentacoes;

@Repository
@Primary
@Transactional
public class MovimentacoesHibernate implements Movimentacoes {

	private final SessionFactory factory;
	
	@Autowired
	public MovimentacoesHibernate(SessionFactory factory) {
		this.factory = factory;
	}
	
	/* (non-Javadoc)
	 * @see br.com.caelum.estoque.dao.MovimentacaoDAO#salvar(br.com.caelum.estoque.Movimentacao)
	 */
	@Override
	public void salvar(Movimentacao movimentacao) {
		factory.getCurrentSession().save(movimentacao);
	}
	
	
}
