package com.barbeariaapi.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.Model.Estabelecimento;
import com.barbeariaapi.Service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelcimentoController {

	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Estabelecimento> cadastrarEstabelecimento(@RequestBody Estabelecimento estabelecimento){
		estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
		return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
	}
	
	@GetMapping("/senha")
	public ResponseEntity<String> recuperarSenha(@RequestParam(name = "email") String email){
		return new ResponseEntity<>(estabelecimentoService.recuperarSenha(email), HttpStatus.OK);
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Estabelecimento> buscarEstabelecimento(@RequestParam(name = "id") Long id){
		Optional<Estabelecimento> estabelecimento = estabelecimentoService.buscarEstabelecimentoPeloId(id);
		return new ResponseEntity(estabelecimento, HttpStatus.OK);
	}
}
