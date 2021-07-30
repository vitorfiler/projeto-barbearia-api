package com.barbeariaapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.barbeariaapi.Model.Estabelecimento;
import com.barbeariaapi.Service.EstabelecimentoService;

@Controller
public class EstabelcimentoController {

	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<Estabelecimento> cadastrarEstabelecimento(@RequestBody Estabelecimento estabelecimento){
		estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
		return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
	}
}
