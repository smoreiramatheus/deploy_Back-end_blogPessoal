package org.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //habilita a classe p ser uma classe de segurança, utiliza os recurso
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(service);
		auth.inMemoryAuthentication()
		.withUser("blackmamba")
		.password(passwordEncoder().encode("blackmamba"))
		.authorities("ROLE_USER");
	}
	
	@Bean //objeto será instanciado, passar um método para cadastrar
	public PasswordEncoder/*metodo */  passwordEncoder() { //criptorafia da senha
		return new BCryptPasswordEncoder();
	}
	
	
			
			//essa configuração irá liberar alguns endpointers , alguns caminhos 
			//dentro da camada controller para que seja acessível sem a necessidade de
			//chave tokken
	@Override									//Thrrows Exception é uma tratativa de erro
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/usuarios/logar").permitAll()
		.antMatchers(HttpMethod.POST,"/usuarios/cadastrar").permitAll()
		.anyRequest().authenticated()		//todas as requisições deverão ser autenticadas
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)		//controlará a sessão sem cair a págin "SessionCreationPolicy.STATELESS "....   e indicará qual o tipo de sessão que será inicializada
		.and().cors() // especificar dentro da aplicação informar para onavegador a troca de rota
		.and().csrf().disable(); //tipo de ataque desabilitando o erro
		
	}

}
