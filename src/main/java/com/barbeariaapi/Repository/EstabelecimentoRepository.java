package com.barbeariaapi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.Model.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends JpaRepository <Estabelecimento, Long> {

	Optional<Estabelecimento> findByEmail (String usuario);

}
