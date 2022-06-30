package com.barbeariaapi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.barbeariaapi.model.Endereco;
import com.barbeariaapi.model.Plano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EstabelecimentoDTO {
	
	private Long id;

	private String hashSenha;

	private String nomeProprietario;

	private String estabelecimento;
	
	private String email;
	
	private String cpf_cnpj;
	
	private String senha;
	
	private Boolean cadastroCompleto;

	private Long enderecoID;
	
	private byte[] imagemCapa;
	
	private String pathCapa;

	private byte[] imagemPerfil;

	private String pathPerfil;
	
	private Long planoID;

	private Endereco endereco;

	private Plano plano;
	

}
