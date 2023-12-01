package com.barbeariaapi.dominadash;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParamCompilacaoRepository extends JpaRepository <ParametroCompilacao, Long> {
	
	@Query(
			  value = " SELECT * FROM param_compilacao pc "
			  		+ " WHERE pc.compilacao_id  = ?1 "
			  		+ " ORDER BY pc.ordem", 
			  nativeQuery = true)
	public Set<ParametroCompilacao> buscarOrdenado(Long compilacaoId);
}
