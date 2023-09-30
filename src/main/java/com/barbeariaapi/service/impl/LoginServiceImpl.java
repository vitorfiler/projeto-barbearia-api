package com.barbeariaapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.repository.EstabelecimentoRepository;
import com.barbeariaapi.service.EstabelecimentoService;
import com.barbeariaapi.service.LoginService;

@Component("LoginController")
public class LoginServiceImpl implements LoginService{

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	public Estabelecimento loadUserByUsername(String username, String password) throws Exception {
		Estabelecimento estabelecimento = estabelecimentoRepository.findByEmail(username);
		if(estabelecimento != null) {			
			if (estabelecimento.getEmail().equals(username) && estabelecimento.getSenha().equals(password) ) {
				if(estabelecimento.getPrimeiroLogin()) {
					estabelecimento.setPrimeiroLogin(false);
					estabelecimentoRepository.save(estabelecimento);
					estabelecimento.setPrimeiroLogin(true);
				}
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
