package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbeariaapi.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository <Agendamento, Long> {

	List<Agendamento> findAllByEstabelecimentoID(Long id);
	
	@Query(
			value = "SELECT * FROM Agendamento "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and dt_atendimento >= ?2 and dt_atendimento <= ?3 "
					+ " and status LIKE ?4", 
			  nativeQuery = true)
	List<Agendamento> findAllFiltro(Long estabelecimentoID, String dtIncial, String dtFinal, String status);
	
	@Query(
			value = "SELECT * FROM Agendamento "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and dt_atendimento >= ?2 and dt_atendimento <= ?3 ", 
			  nativeQuery = true)
	List<Agendamento> findAllByDtAtendimento(Long estabelecimentoID, String dtIncial, String dtFinal);
	
	@Query(
			value = "SELECT * FROM Agendamento "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and status = ?2", 
			  nativeQuery = true)
	List<Agendamento> findAllByStatus(Long estabelecimentoID, String status);
	
	
	@Query(
			value = "SELECT * FROM Agendamento "
					+ " WHERE dt_atendimento LIKE %?1%"
					+ " and estabelecimento_ID = ?2", 
			  nativeQuery = true)
	List<Agendamento> findAllToday(String hoje, Long estabelecimentoId);
}
