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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pessoa")
@Api(value = "Pessoa")
public class PessoaController {

	@Autowired
	private BenchmarkBuilders build;
	
	@GetMapping
	public ResponseEntity<String> test(){
		return build.hello();
	}
	
	@ApiOperation(value = "Retorna a lista de todas as pessoas da base de dados")
	@GetMapping("/listar")
	public ResponseEntity<?> carregar(){
		return build.listarPessoas();
	}

	@ApiOperation(value = "Cadastra uma lista de pessoas através de um JSON")
	@PostMapping("/lista")
	public ResponseEntity<?> salvarListaPessoas(@RequestBody List<Pessoa> lista){
		return build.saveListPessoa(lista);
	}
	
	@ApiOperation(value = "Calcula a n-Ésima posição da sequencia de fibonacci por parametro url")
	@GetMapping("/fibonacci/{sequencia}")
	public ResponseEntity<?> calcular(@PathVariable Integer sequencia) {
		return build.calcularFibboBySequencia(sequencia);
	}
	
	@ApiOperation(value = "Ordena um vetor de determinado tamanho por parametro url")
	@GetMapping("/sort/{tamanho}")
	public ResponseEntity<?> sort(@PathVariable Integer tamanho){
		return build.ordenarByInsertionSort(tamanho);
	}
	
}
