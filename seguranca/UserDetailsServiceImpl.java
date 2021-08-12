package org.generation.blogPessoal.seguranca;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
		@Autowired
		private UsuarioRepository repository;
		
		
		@Override
		public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
			Optional<Usuario> user = repository.findByUsuario(usuario);
			
			if (user.isPresent()) {
				return new UserDetailsImpl(user.get());
			} else {
				throw new UsernameNotFoundException(usuario + " not found." );
			}
			
		}
	

}
