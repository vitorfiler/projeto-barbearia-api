package com.barbeariaapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barbeariaapi.model.Cliente;
import com.barbeariaapi.repository.ClienteRepository;
import com.barbeariaapi.service.ClienteService;

@Component("ClienteController")
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> buscarTodosClientesAtivos(){
		return clienteRepository.findAllByAtivo(true);
	}
	
	public List<Cliente> buscarTodosClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente buscarPeloId(Long clienteId) {
		try {			
			Optional<Cliente> cliente = clienteRepository.findById(clienteId);
			if(cliente.isPresent()) {
				return cliente.get().isAtivo()? cliente.get() : null;
			}else {
				throw new IllegalArgumentException("Cliente não encontrado");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao buscar cliente ", e);
		}
		
	}
	
	public Cliente cadastrar(Cliente cliente) {
		try {			
			Optional<Cliente> resposta = clienteRepository.findById(cliente.getId() !=null? cliente.getId() : 0L);
			if(!resposta.isPresent()) {
				return clienteRepository.save(cliente);
			}
			else {
				throw new IllegalArgumentException("Cliente Já cadastrado");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao cadastrar cliente");
		}
	}
	
	public Cliente alterar(Cliente cliente) {
		try {
			Optional<Cliente> resposta = clienteRepository.findById(cliente.getId());
			if(resposta.isPresent()) {
				return clienteRepository.save(cliente);
			}
			else {
				throw new IllegalArgumentException("Cliente não encontrado");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao alterar cliente");
		}
	}
	
	public void deletarPeloId(Long clienteId) {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(clienteId);
			if(cliente.isPresent()) {
				cliente.get().setAtivo(false);
				clienteRepository.save(cliente.get());
			}
			else {
				throw new IllegalArgumentException("Cliente não encontrado");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao alterar cliente");
		}
	}
	
	public List<Cliente> filtrar(){
		return null;
	}
}
