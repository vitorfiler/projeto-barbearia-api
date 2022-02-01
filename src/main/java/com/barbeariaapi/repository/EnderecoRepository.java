package com.barbeariaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barbeariaapi.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {


}
