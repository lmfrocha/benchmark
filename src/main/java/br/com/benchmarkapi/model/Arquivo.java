package br.com.benchmarkapi.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Arquivo {
	
	@Value("${pasta.raiz}")
	private String raiz;
	
	@Value("${pasta.diretorio}")
	private String diretorio;

	@Transient
	private String tempoInicial;

	@Transient
	private String tempoFinal;
	
	@Transient
	private Long tamanho;
	
	@Transient
	private String nome;
	
	
	public void salvarArquivo(MultipartFile file) {
		this.salvar(this.diretorio, file);
	}

	public void setTempoInicial (String tempoInicial) {
		this.tempoInicial = tempoInicial;
	}
	public void setTempoFinal (String tempoFinal) {
		this.tempoFinal = tempoFinal;
	}
	
	public String getTempoInicial() {
		return this.tempoInicial;
	}
	
	public String getTempoFinal() {
		return this.tempoFinal;
	}
	
	public void setTamanho (Long tamanho) {
		this.tamanho = tamanho;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getTamanho() {
		return (this.tamanho/1024)/1024 + "MB";
	}
	
	private void salvar(String diretorio, MultipartFile file) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(file.getOriginalFilename()+Math.random());
		
		try {
			Files.createDirectories(diretorioPath);
			file.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Erro ao salvar Arquivo.");
		}
	}
	
}
