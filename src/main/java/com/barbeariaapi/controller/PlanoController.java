package com.barbeariaapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Plano;
import com.barbeariaapi.service.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

	@Autowired
	PlanoService planoService;
	
	@GetMapping
	public List<Plano> buscarTodos(){
		return planoService.buscarTodos();
	}
	
	@PostMapping
	public void contratar(@RequestBody Map<String, String> parametros) throws Exception {
		Long estabelecimentoID = Long.parseLong(parametros.get("estabelecimento_ID"));
		Long planoID = Long.parseLong(parametros.get("plano_ID"));
		planoService.contratar(estabelecimentoID, planoID);
	}
	
	@PostMapping ("/novo")
	public Plano cadastrar(@RequestBody Plano plano) {
		return planoService.criarPlano(plano);
	}
	
}
