package com.barbeariaapi.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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

import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelcimentoController {

	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	@PostMapping
	public ResponseEntity<Estabelecimento> cadastrarEstabelecimento(@Valid @RequestBody Estabelecimento estabelecimento) throws Exception{
		estabelecimentoService.cadastrarEstabelecimento(estabelecimento);
		return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
	}
	
	@PutMapping("/redefinicao")
	public ResponseEntity<String> redefinirSenha(@RequestBody Map<String, String> parametros){
		String status = estabelecimentoService.redefinirSenha(parametros);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@GetMapping("/recuperacao")
	public ResponseEntity<Map<String, String>> recuperarSenha(@RequestParam(name = "email") String email){
		return new ResponseEntity<>(estabelecimentoService.recuperarSenha(email), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Estabelecimento> buscarEstabelecimento(@RequestParam(name = "id") Long id){
		Optional<Estabelecimento> estabelecimento = estabelecimentoService.buscarEstabelecimentoPeloId(id);
		return new ResponseEntity(estabelecimento, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Estabelecimento> atualizarEstabelecimento(@Valid @RequestBody Estabelecimento estabelecimento) throws Exception{
		return new ResponseEntity<>(estabelecimentoService.atualizarEstabelecimento(estabelecimento), HttpStatus.OK);
	}
	
	@PutMapping("/finaliza-cadastro")
	public ResponseEntity<Estabelecimento> completarCadastroEstabelecimento(@Valid @RequestBody Map<String, String> params,
			@RequestParam(name="estabelecimento_ID") Long estabelecimentoID) throws Exception{
		return new ResponseEntity<>(estabelecimentoService.completarCadastroEstabelecimento(params, estabelecimentoID), HttpStatus.OK);
	}
}
