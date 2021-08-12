package org.generation.blogPessoal.repository;

import java.util.Optional;


import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Fará a comunicação entre a API e o BANCO DE DADOS
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String usuario); 

}
