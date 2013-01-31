package br.com.caelum.estoque.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.Movimentacao;

@Repository
@Primary
@Transactional
public class MovimentacaoHibernateDAO implements MovimentacaoDAO {

	private final SessionFactory factory;
	
	@Autowired
	public MovimentacaoHibernateDAO(SessionFactory factory) {
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
