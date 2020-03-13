package br.com.benchmarkapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.benchmarkapi.model.Arquivo;
import br.com.benchmarkapi.service.AlgoritimoService;

@RestController
@RequestMapping("/")
public class ArquivoController {

	@Autowired
	private AlgoritimoService build;
	
	@PostMapping("file")
	public ResponseEntity<Arquivo> upload(@RequestParam MultipartFile file) {
		return build.uploadFile(file);
	}
	
}
