package com.barbeariaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barbeariaapi.model.Cliente;

@Service
public interface ClienteService {

	public List<Cliente> buscarTodosClientes();
	
	public List<Cliente> buscarTodosClientesAtivos();
	
	public Cliente buscarPeloId(Long clienteId);
	
	public Cliente cadastrar(Cliente cliente);
	
	public Cliente alterar(Cliente cliente);
	
	public void deletarPeloId(Long clienteID);
	
	public List<Cliente> filtrar(String filtro);
}
