package br.com.caelum.estoque.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.estoque.repository.Usuarios;

@Repository
@Transactional
@Primary
public class UsuariosHibernate implements Usuarios {

	private final SessionFactory factory;
	
	@Autowired
	public UsuariosHibernate(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		List<Usuarios> usuarios = factory.getCurrentSession()
				.createQuery("from Usuario where login = :login").setParameter("login", username).list();
		
		if (!usuarios.isEmpty()) {
			return (UserDetails) usuarios.get(0);
		} else {
			return null;
		}
		
		
	}

}
