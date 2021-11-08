package com.barbeariaapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.Model.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository <Estabelecimento, Long> {

	Estabelecimento findByEmail (String usuario);

}
