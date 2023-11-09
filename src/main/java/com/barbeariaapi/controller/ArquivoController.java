package com.barbeariaapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.barbeariaapi.config.AmazonClient;
import com.barbeariaapi.model.ArquivoEstabelecimento;
import com.barbeariaapi.model.ArquivoProduto;
import com.barbeariaapi.model.ArquivoServico;

@RestController
@RequestMapping(path = "/upload-arquivo")
public class ArquivoController {

	private AmazonClient amazonClient;
	
	public static final String ESTABELECIMENTO = "ESTABELECIMENTO";
	public static final String SERVICO = "SERVICO";
	public static final String PRODUTO = "PRODUTO";
	
	
	@Autowired
	ArquivoController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}
	
	@PostMapping("estabelecimento")
	public String uploadFileEstabelecimento(@RequestPart(value = "file") MultipartFile file, 
			@RequestPart(value = "body") ArquivoEstabelecimento body ) {
		return this.amazonClient.processaArquivoEstabelecimento(file, body);
	}
	
	@PostMapping("servico")
	public String uploadFileServico(@RequestPart(value = "file") MultipartFile file, 
			@RequestPart(value = "body") ArquivoServico body ) {
		return this.amazonClient.processaArquivoServico(file, body);
	}
	
	@PostMapping("produto")
	public String uploadFileProduto(@RequestPart(value = "file") MultipartFile file, 
			@RequestPart(value = "body") ArquivoProduto body ) {
		return this.amazonClient.processaArquivoProduto(file, body);
	}
}
