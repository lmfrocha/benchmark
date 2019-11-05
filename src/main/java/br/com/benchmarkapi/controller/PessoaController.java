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

import br.com.benchmarkapi.model.Pessoa;
import br.com.benchmarkapi.service.BenchmarkBuilders;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private BenchmarkBuilders build;
	
	@GetMapping
	public ResponseEntity<String> test(){
		return build.hello();
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> carregar(){
		return build.listarPessoas();
	}

	@PostMapping("/lista")
	public ResponseEntity<?> salvarListaPessoas(@RequestBody List<Pessoa> lista){
		return build.saveListPessoa(lista);
	}
	
	@GetMapping("/fibonacci/{sequencia}")
	public ResponseEntity<?> calcular(@PathVariable Integer sequencia) {
		return build.calcularFibboBySequencia(sequencia);
	}
	
	@GetMapping("/sort/{tamanho}")
	public ResponseEntity<?> sort(@PathVariable Integer tamanho){
		return build.ordenarByInsertionSort(tamanho);
	}
	
}
