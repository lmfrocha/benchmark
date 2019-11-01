package br.com.benchmarkapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.benchmarkapi.dto.PessoaDTO;
import br.com.benchmarkapi.service.BenchmarkBuilders;

@RestController
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private BenchmarkBuilders build;
	
	@GetMapping
	public ResponseEntity<String> test(){
		return build.hello();
	}
	
	@GetMapping("fibonacci/{sequencia}")
	public ResponseEntity<?> calcular(@PathVariable Integer sequencia) {
		return build.calcularFibboBySequencia(sequencia);
	}
	
	@GetMapping("sort/{tamanho}")
	public ResponseEntity<String> sort(@PathVariable Long tamanho){
		return build.ordenarByInsertionSort(tamanho);
	}
	
	@PostMapping("lista")
	public ResponseEntity<?> salvarListaPessoas(@RequestBody List<PessoaDTO> lista){
		return build.saveListPessoa(lista);
	}

	
}
