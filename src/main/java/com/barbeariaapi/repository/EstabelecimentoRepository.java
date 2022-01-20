package com.barbeariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository <Estabelecimento, Long> {

	Estabelecimento findByEmail (String usuario);

}
