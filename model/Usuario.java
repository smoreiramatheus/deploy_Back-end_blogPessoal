package org.generation.blogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario" )
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo não pode ser vazio")
	@Size(min = 2, max =100, message = "O campo nome deve conter no mínimo 2 e no maximo 100 caracteres")
	private String nome;
	
	@NotBlank(message = "O campo não pode ser vazio")
	@Size(min = 5, max =100, message = "O campo usuario deve conter no mínimo 5 e no maximo 100 caracteres")
	private String usuario;
	
	@NotBlank(message = "O campo não pode ser vazio")
	@Size(min = 5, max =100, message = "O campo senha deve conter no mínimo 5 e no maximo 100 caracteres")
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	 
	
	

}
