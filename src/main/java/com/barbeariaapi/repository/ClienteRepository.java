package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbeariaapi.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

	List<Cliente> findAllByAtivo(boolean ativo);
	
	@Query(value = "SELECT * FROM cliente WHERE INSTR(cpf , ?1) > 0"
			+ " OR INSTR(nome , ?1) > 0", 
			nativeQuery = true)
	List<Cliente> findAllByFiltro(String filtro);
}
