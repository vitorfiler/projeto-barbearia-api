package com.barbeariaapi.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.barbeariaapi.exceptions.BadRequestException;
import com.barbeariaapi.model.ArquivoEstabelecimento;
import com.barbeariaapi.model.ArquivoProduto;
import com.barbeariaapi.model.ArquivoServico;
import com.barbeariaapi.model.Estabelecimento;
import com.barbeariaapi.model.Produto;
import com.barbeariaapi.model.Servico;
import com.barbeariaapi.repository.ArquivoEstabelecimentoRepository;
import com.barbeariaapi.repository.ArquivoProdutoRepository;
import com.barbeariaapi.repository.ArquivoServicoRepository;
import com.barbeariaapi.repository.EstabelecimentoRepository;
import com.barbeariaapi.repository.ProdutoRepository;
import com.barbeariaapi.repository.ServicoRepository;

@Service
public class AmazonClient {

	private AmazonS3 s3client;

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	@Autowired
	ArquivoEstabelecimentoRepository arquivoEstabelecimentoRepository;

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	ArquivoProdutoRepository arquivoProdutoRepository;

	@Autowired
	ServicoRepository servicoRepository;
	@Autowired
	ArquivoServicoRepository arquivoServicoRepository;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	private void uploadFileTos3bucket(String fileName, File file) {
		s3client.putObject(
				new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
	}

	public Map<String, String> uploadFile(MultipartFile multipartFile) throws IOException {
		String fileUrl = "";
		File file = convertMultiPartToFile(multipartFile);
		String fileName = generateFileName(multipartFile);
		fileUrl = endpointUrl + "/" + fileName;
		uploadFileTos3bucket(fileName, file);
		file.delete();
		Map<String, String> dadosArquivo = Map.of("fileUrl", fileUrl, "fileName", fileName);
		return dadosArquivo;
	}

	public String processaArquivoEstabelecimento(MultipartFile multipartFile, ArquivoEstabelecimento body) {
		String fileUrl = "";
		try {
			Map<String, String> dadosArquivo = uploadFile(multipartFile);
			fileUrl = dadosArquivo.get("fileUrl");
			body.setNome(dadosArquivo.get("fileName"));
			body.setPathS3(dadosArquivo.get("fileUrl"));
			persistirArquivoEstabelecimento(body, fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}

	public void persistirArquivoEstabelecimento(ArquivoEstabelecimento arquivo, String fileUrl) {
		try {
			Estabelecimento estabelecimento = estabelecimentoRepository.findById(arquivo.getEstabelecimento().getId())
					.get();
			if (estabelecimento != null) {
				estabelecimento.setFotoS3Aws(fileUrl);
				arquivoEstabelecimentoRepository.save(arquivo);
				estabelecimentoRepository.save(estabelecimento);
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao Adicionar imagem");
		}
	}

	public String processaArquivoProduto(MultipartFile multipartFile, ArquivoProduto body) {
		String fileUrl = "";
		try {
			Map<String, String> dadosArquivo = uploadFile(multipartFile);
			fileUrl = dadosArquivo.get("fileUrl");
			body.setNome(dadosArquivo.get("fileName"));
			body.setPathS3(dadosArquivo.get("fileUrl"));
			persistirArquivoProduto(body, fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;

	}

	public void persistirArquivoProduto(ArquivoProduto arquivo, String fileUrl) {
		try {
			Produto produto = produtoRepository.findById(arquivo.getProduto().getId()).get();
			if (produto != null) {
				produto.setFotoS3Aws(fileUrl);
				arquivoProdutoRepository.save(arquivo);
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao Adicionar imagem");
		}
	}

	public String processaArquivoServico(MultipartFile multipartFile, ArquivoServico body) {
		String fileUrl = "";
		try {
			Map<String, String> dadosArquivo = uploadFile(multipartFile);
			fileUrl = dadosArquivo.get("fileUrl");
			body.setNome(dadosArquivo.get("fileName"));
			body.setPathS3(dadosArquivo.get("fileUrl"));
			persistirArquivoServico(body, fileUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}

	public void persistirArquivoServico(ArquivoServico arquivo, String fileUrl) {
		try {
			Servico servico = servicoRepository.findById(arquivo.getServico().getId()).get();
			if (servico != null) {
				servico.setFotoS3Aws(fileUrl);
				arquivoServicoRepository.save(arquivo);
			}
		} catch (Exception e) {
			throw new BadRequestException("Falha ao Adicionar imagem");
		}
	}

//	private void deleteFileFromS3Bucket(String fileName, File file) {
//		s3client.deleteObject(
//				new DeleteObjectRequest(bucketName, fileName));
//	}
}