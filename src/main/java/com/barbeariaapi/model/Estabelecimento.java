package com.barbeariaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Entity(name="estabelecimento")
public class Estabelecimento {
	
	public Estabelecimento(int i, String string, String string2, String string3, String string4, String string5,
			String string6, boolean b, int j, int k) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="hash_senha")
	@Size(min = 3, max = 500)
	private String hashSenha;
	
	@Column(name="nome")
	@NotNull
	@Size(min = 3, max = 100)
	private String nomeProprietario;
	
	@Column(name="estabelecimento")
	@NotNull
	@Size(min = 3, max = 100)
	private String estabelecimento;
	
	@Column(name="email")
	@NotNull
	@Size(min = 3, max = 100)
	private String email;
	
	@Column(name="CPF_CNPJ")
	@NotNull
	@Size(min = 3, max = 100)
	private String cpf_cnpj;
	
	@Column(name="senha")
	@NotNull
	@Size(min = 3, max = 100)
//	@JsonIgnore
	private String senha;
	
	@Column(name="cadastro_completo")
	@NotNull
	private Boolean cadastroCompleto;

	@Column(name="endereco_ID")
	private Long enderecoID;
	
	@Lob
	@Column(name="imagem_capa")
	private byte[] imagemCapa;
	
	@Lob
	@Column(name="imagem_perfil")
	private byte[] imagemPerfil;
	
	@Column(name="plano_ID")
	private Long planoID;
	
	@Transient
	private Endereco endereco;
	
	@Transient
	private Plano plano;
	

}
