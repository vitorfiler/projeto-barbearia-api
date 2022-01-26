package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariaapi.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

	List<Cliente> findAllByAtivo(boolean ativo);
}
