package com.barbeariaapi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.repository.EstabelecimentoRepository;
import com.barbeariaapi.service.LoginService;

@Component("LoginController")
public class LoginService {

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public Estabelecimento loadUserByUsername(String username, String password) throws UsernameNotFoundException {
		Estabelecimento estabelecimento = estabelecimentoRepository.findByEmail(username);
		if(estabelecimento != null) {			
			if (estabelecimento.getEmail().equals(username) && estabelecimento.getSenha().equals(password) ) {
				return estabelecimento;
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
