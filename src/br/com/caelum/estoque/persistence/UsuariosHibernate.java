package br.com.caelum.estoque.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.caelum.estoque.repository.Usuarios;

public class UsuariosHibernate implements Usuarios {

private final SessionFactory factory;
	
	@Autowired
	public UsuariosHibernate(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Query query = factory.getCurrentSession()
				.createQuery("from Usuario where login = :login");
		
		query.setParameter("login", username);
		
		return (UserDetails) query.list();
	}

}
