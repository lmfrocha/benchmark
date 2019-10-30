package br.com.benchmarkapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.benchmarkapi.dto.PessoaDTO;
import br.com.benchmarkapi.dto.Telemetria;
import br.com.benchmarkapi.model.Pessoa;
import br.com.benchmarkapi.repository.PessoaRepository;
import br.com.benchmarkapi.service.Algoritimos;

@RestController
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoa;
	
	private Telemetria telemetria = new Telemetria();
	
	private Date dataInicial;
	
	private Date dataFinal;
	
	private Long tempoCorrido;
	
	private DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@GetMapping
	public ResponseEntity<String> test(){
		String text = "API de benchmark tcc "
				+ " \nLucas Marcelino Ferreira Rocha - 516726"
				+ "	\nSistemas de Informação "
				+ " \nPuc Minas ";
		return ResponseEntity.status(HttpStatus.OK).body(text);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("fibonacci/{sequencia}")
	public ResponseEntity calcular(@PathVariable Double sequencia) {
		StringBuilder response = new StringBuilder();
		
		String tempo;
		Long tempoInicial = System.currentTimeMillis();
		this.dataInicial = new Date();
		tempo =  this.dateFormat.format(this.dataInicial);
		this.telemetria.setDataInicial(tempo);
		
		this.telemetria.setSequenciaFibonacci(Algoritimos.returnSequence(sequencia));
		
		this.dataFinal = new Date();
		tempo = (dateFormat.format(this.dataFinal));
		this.telemetria.setDataFinal(tempo);
		
		this.tempoCorrido = (this.dataFinal.getTime() - this.dataInicial.getTime())/60;
		this.telemetria.setTempoTotal(this.tempoCorrido.toString());
		Long tempoFinal = System.currentTimeMillis();
		
		response.append("TempoInicial: "+ this.telemetria.getDataInicial());
		response.append("\nTempoFinal: "+ this.telemetria.getDataFinal());
		response.append("\nSequencia: " + sequencia);
		response.append("Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.toString());
	}
	
	@GetMapping("sort/{tamanho}")
	public ResponseEntity<String> sort(@PathVariable Long tamanho){
		StringBuilder response = new StringBuilder();
		Long[] vetor = new Long[tamanho.intValue()];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (long) (Math.random() * tamanho);
		}
		
		String tempo;
		Long tempoInicial = System.currentTimeMillis();
		this.dataInicial = new Date();
		tempo =  this.dateFormat.format(this.dataInicial);
		this.telemetria.setDataInicial(tempo);
		
		Algoritimos.insertionSort(vetor);
		
		this.dataFinal = new Date();
		tempo = (dateFormat.format(this.dataFinal));
		this.telemetria.setDataFinal(tempo);
		
		this.tempoCorrido = (this.dataFinal.getTime() - this.dataInicial.getTime())/60;
		this.telemetria.setTempoTotal(this.tempoCorrido.toString());
		Long tempoFinal = System.currentTimeMillis();

		response.append("TempoInicial: "+ this.telemetria.getDataInicial());
		response.append("\nTempoFinal: "+ this.telemetria.getDataFinal());
		response.append("\nTamanho: " + tamanho);
		response.append("Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.toString());
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("lista")
	public ResponseEntity salvarListaPessoas(@RequestBody List<PessoaDTO> lista){
		StringBuilder response = new StringBuilder();
		String tempo;
		
		tempo =  this.dateFormat.format(this.dataInicial);
		this.telemetria.setDataInicial(tempo);
		Long tempoInicial = System.currentTimeMillis();
		
		List<Pessoa> pessoaList = new ArrayList<>();
		lista.forEach(x -> {
			Pessoa temp = new Pessoa();
			temp.setNome(x.getNome());
			temp.setSobreNome(x.getSobreNome());
			temp.setEmail(x.getEmail());
			pessoaList.add(temp);
		});
		pessoa.saveAll(pessoaList);
		
		this.dataFinal = new Date();
		tempo = (dateFormat.format(this.dataFinal));
		this.telemetria.setDataFinal(tempo);
		
		this.tempoCorrido = (this.dataFinal.getTime() - this.dataInicial.getTime())/60;
		this.telemetria.setTempoTotal(this.tempoCorrido.toString());
		Long tempoFinal = System.currentTimeMillis();
		
		response.append("TempoInicial: "+ this.telemetria.getDataInicial());
		response.append("\nTempoFinal: "+ this.telemetria.getDataFinal());
		response.append("\nQuantidade: " + pessoaList.size());
		response.append("Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		return ResponseEntity.status(HttpStatus.CREATED).body(response.toString());
	}
}
