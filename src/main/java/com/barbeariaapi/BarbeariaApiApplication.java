package com.barbeariaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.barbeariaapi.config.JWTAuthorizationFilter;

@SpringBootApplication
public class BarbeariaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaApiApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers("*", "/estabelecimento/*").permitAll()
				
				//João Pedro
				.antMatchers(HttpMethod.GET, "/planos").permitAll()
				.antMatchers(HttpMethod.POST, "/planos").permitAll()
				
				//Geanderson
				.antMatchers(HttpMethod.POST, "/servicos").permitAll()
				.antMatchers(HttpMethod.GET, "/servicos/*").permitAll()
				
				//Bruno
				.antMatchers(HttpMethod.POST, "/produtos").permitAll()
				.antMatchers(HttpMethod.GET, "/produtos/*").permitAll()
				
				//Victor
				.antMatchers(HttpMethod.POST, "/agendamentos").permitAll()
				.antMatchers(HttpMethod.GET, "/agendamentos/*").permitAll()
				

				.antMatchers(HttpMethod.GET, "/promocoes").permitAll()
				
				.antMatchers(HttpMethod.GET, "/health-check").permitAll()
				.anyRequest().authenticated();
		}
	}
}
