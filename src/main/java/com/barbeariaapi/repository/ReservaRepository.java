package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Long> {
	
	List<Reserva> findAllByEstabelecimentoID(Long id);
}
