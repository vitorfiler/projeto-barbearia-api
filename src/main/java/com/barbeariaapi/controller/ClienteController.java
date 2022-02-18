package com.barbeariaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barbeariaapi.model.Cliente;
import com.barbeariaapi.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/ativos")
	public List<Cliente> buscarTodosClientesAtivos(){
		return clienteService.buscarTodosClientesAtivos();
	}
	
	@GetMapping("/todos")
	public List<Cliente> buscarTodosClientes(){
		return clienteService.buscarTodosClientes();
	}
	
	@GetMapping
	public Cliente buscarPeloId(@RequestParam(name="cliente_ID") Long clienteId){
		return clienteService.buscarPeloId(clienteId);
	}
	
	@PostMapping
	public Cliente cadastrar(@RequestBody Cliente cliente){
		return clienteService.cadastrar(cliente);
	}
	
	@PutMapping
	public Cliente alterar(@Valid @RequestBody Cliente cliente){
		return clienteService.alterar(cliente);
	}
	
	@DeleteMapping
	public void deletarPeloId(@RequestParam(name="cliente_ID") Long clienteId){
		clienteService.deletarPeloId(clienteId);
	}
	
	@GetMapping("/filtro")
	public List<Cliente> filtrar(@RequestParam(name="filtro") String filtro){
		return clienteService.filtrar(filtro);
	}
	
}
