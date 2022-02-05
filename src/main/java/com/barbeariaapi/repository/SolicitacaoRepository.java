package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barbeariaapi.model.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository <Solicitacao, Long> {

	List<Solicitacao> findAllByEstabelecimentoID(Long id);
	
	@Query(
			value = "SELECT * FROM solicitacao "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and dt_atendimento >= ?2 and dt_atendimento <= ?3 "
					+ " and status LIKE ?4", 
			  nativeQuery = true)
	List<Solicitacao> findAllFiltro(Long estabelecimentoID, String dtIncial, String dtFinal, String status);
	
	@Query(
			value = "SELECT * FROM solicitacao "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and dt_atendimento >= ?2 and dt_atendimento <= ?3 ", 
			  nativeQuery = true)
	List<Solicitacao> findAllByDtAtendimento(Long estabelecimentoID, String dtIncial, String dtFinal);
	
	@Query(
			value = "SELECT * FROM solicitacao "
					+ " WHERE estabelecimento_ID = ?1"
					+ " and status = ?2", 
			  nativeQuery = true)
	List<Solicitacao> findAllByStatus(Long estabelecimentoID, String status);
	
}
