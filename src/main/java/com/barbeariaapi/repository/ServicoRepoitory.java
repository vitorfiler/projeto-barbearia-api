package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Servico;
import com.barbeariaapi.model.Agendamento;

@Repository
public interface ServicoRepoitory extends JpaRepository <Servico, Long> {
	
	List<Servico> findAllByEstabelecimentoID(Long id);
	
	@Query(value = "select * from servico s where s.estabelecimento_ID = ?1 and s.promocional" , 
			nativeQuery = true)
	List<Servico> buscarServicosPromocionais(Long id);
}
