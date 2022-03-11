package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Agendamento;
import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository <Reserva, Long> {
	
	List<Reserva> findAllByEstabelecimentoID(Long id);
	
	@Query(
			value = "SELECT * FROM reserva "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and dt_abertura >= ?2 and dt_abertura <= ?3 "
					+ " and status_reserva LIKE ?4", 
			  nativeQuery = true)
	List<Reserva> findAllFiltro(Long estabelecimentoID, String dtIncial, String dtFinal, String status);
	
	@Query(
			value = "SELECT * FROM reserva "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and dt_abertura >= ?2 and dt_abertura <= ?3 ", 
			  nativeQuery = true)
	List<Reserva> findAllByDtAtendimento(Long estabelecimentoID, String dtIncial, String dtFinal);
	
	@Query(
			value = "SELECT * FROM reserva "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and status_reserva = ?2", 
			  nativeQuery = true)
	List<Reserva> findAllByStatus(Long estabelecimentoID, String status);
	
}
