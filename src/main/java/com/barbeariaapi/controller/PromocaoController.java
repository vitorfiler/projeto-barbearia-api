package com.barbeariaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Promocao;
import com.barbeariaapi.service.PromocaoService;

@RestController
@RequestMapping("/promocoes")
public class PromocaoController {

	@Autowired
	PromocaoService promocaoService;
	
	@GetMapping
	public Promocao obterPromocoes(@RequestParam(name="estabelecimento_ID") Long estabelecimentoId) {
		return promocaoService.obterPromocao(estabelecimentoId);
	}
}
