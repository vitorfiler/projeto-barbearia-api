package com.barbeariaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Beneficio;
import com.barbeariaapi.model.Plano;
import com.barbeariaapi.service.BeneficioService;

@RestController
@RequestMapping("/beneficios")

public class BeneficioController {
	
	@Autowired
	BeneficioService beneficioService;
	
	@PostMapping ("/novo")
	public Beneficio cadastrar(@RequestBody Beneficio beneficio, Plano planoID) {
		return beneficioService.cadastrarBeneficio(beneficio, planoID);
		
	}

}
