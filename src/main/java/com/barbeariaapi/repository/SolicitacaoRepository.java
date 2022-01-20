package com.barbeariaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbeariaapi.model.Solicitacao;

public interface SolicitacaoRepository  extends JpaRepository <Solicitacao, Long> {

	List<Solicitacao> findAllByEstabelecimentoID(Long id);
}
