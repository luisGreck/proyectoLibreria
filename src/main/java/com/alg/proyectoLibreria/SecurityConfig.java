package com.alg.proyectoLibreria;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	@Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	//Definicion de roles y usuarios
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled"
            + " from users where username=?")
        .authoritiesByUsernameQuery("select username, authority "
            + "from authorities where username=?")
        .passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/","/login").permitAll()
		.antMatchers(HttpMethod.POST,"/venta").hasRole("VENTA")	// para vender debes ser rol de ventas
		.antMatchers("/libro/**").authenticated()				// para existencias solo necesita estar logeado			
		//.antMatchers("/**").authenticated() 						
		//.antMatchers("/contactos/**").authenticated()
		.and()
        .formLogin()
        .loginPage("/login")
        .successHandler(authenticationSuccessHandler)
         .failureUrl("/login?error=0")
         .and()
	        .exceptionHandling()
	          .accessDeniedPage("/access-denied");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    PasswordEncoder encoder = new BCryptPasswordEncoder();
	    return encoder;
	}
}
