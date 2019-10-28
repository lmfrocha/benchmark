package br.com.benchmarkapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.benchmarkapi.files.Arquivo;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private Arquivo arquivo;
	
	@PostMapping
	public ResponseEntity<Arquivo> upload (@RequestParam MultipartFile file) {
		Arquivo arqResponse = new Arquivo();
		
		String tempo = "";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dataIni = new Date();
		
		tempo = (dateFormat.format(dataIni));
		arqResponse.setTempoInicial(tempo);
		arquivo.salvarArquivo(file);
		
		Date dataFim = new Date();
		tempo = "";
		tempo = (dateFormat.format(dataFim));
		arqResponse.setTempoFinal(tempo);
		arqResponse.setNome(file.getOriginalFilename());
		arqResponse.setTamanho(file.getSize());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(arqResponse);
	}
	
}
