package br.com.benchmarkapi.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.benchmarkapi.dto.PessoaResponseDTO;
import br.com.benchmarkapi.dto.Telemetria;
import br.com.benchmarkapi.files.Arquivo;
import br.com.benchmarkapi.model.Pessoa;
import br.com.benchmarkapi.repository.PessoaRepository;

@Service
public class BenchmarkBuilders {

	@Autowired
	private PessoaRepository pessoa;
	
	@Autowired
	private Arquivo arquivo;
	
	private Telemetria telemetria = new Telemetria();
	
	private Date dataInicial;
	
	private Date dataFinal;
	
	private Long tempoCorrido;
	
	private DateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public ResponseEntity<String> hello() {
		String text = "API de benchmark tcc "
				+ " \nLucas Marcelino Ferreira Rocha - 516726"
				+ "	\nSistemas de Informação "
				+ " \nPuc Minas ";
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(text);
	}
	
	public ResponseEntity<?> calcularFibboBySequencia(Integer sequencia) {
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
		response.append(" TempoFinal: "+ this.telemetria.getDataFinal());
		response.append(" Sequencia: " + sequencia);
		response.append(" Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		response.append(" Calculados: " + this.telemetria.getSequenciaFibonacci());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.toString());
	}
	
	public ResponseEntity<String> ordenarByInsertionSort(Integer tamanho) {
		StringBuilder response = new StringBuilder();
		String tempo;
		Long tempoInicial = System.currentTimeMillis();
		this.dataInicial = new Date();
		tempo =  this.dateFormat.format(this.dataInicial);
		this.telemetria.setDataInicial(tempo);
		Algoritimos.insertionSort(tamanho);
		this.dataFinal = new Date();
		tempo = (dateFormat.format(this.dataFinal));
		this.telemetria.setDataFinal(tempo);
		this.tempoCorrido = (this.dataFinal.getTime() - this.dataInicial.getTime())/60;
		this.telemetria.setTempoTotal(this.tempoCorrido.toString());
		Long tempoFinal = System.currentTimeMillis();
		response.append("TempoInicial: "+ this.telemetria.getDataInicial());
		response.append(" TempoFinal: "+ this.telemetria.getDataFinal());
		response.append(" Tamanho: " + tamanho);
		response.append(" Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.toString());
	}
	
	public ResponseEntity<?> saveListPessoa(List<Pessoa> lista) {
		StringBuilder response = new StringBuilder();
		String tempo;
		Long tempoInicial = System.currentTimeMillis();
		this.dataInicial = new Date();
		tempo =  this.dateFormat.format(this.dataInicial);
		this.telemetria.setDataInicial(tempo);
		pessoa.saveAll(lista);
		this.dataFinal = new Date();
		tempo = (dateFormat.format(this.dataFinal));
		this.telemetria.setDataFinal(tempo);
		this.tempoCorrido = (this.dataFinal.getTime() - this.dataInicial.getTime())/60;
		this.telemetria.setTempoTotal(this.tempoCorrido.toString());
		Long tempoFinal = System.currentTimeMillis();
		response.append("TempoInicial: "+ this.telemetria.getDataInicial());
		response.append(" TempoFinal: "+ this.telemetria.getDataFinal());
		response.append(" Quantidade: " + lista.size());
		response.append(" Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response.toString());
	}

	@Transactional
	public ResponseEntity<?> listarPessoas() {
		StringBuilder response = new StringBuilder();
		String tempo;
		Long tempoInicial = System.currentTimeMillis();
		this.dataInicial = new Date();
		tempo =  this.dateFormat.format(this.dataInicial);
		this.telemetria.setDataInicial(tempo);
		List<Pessoa> pessoas = pessoa.findAll();
		this.dataFinal = new Date();
		tempo = (dateFormat.format(this.dataFinal));
		this.telemetria.setDataFinal(tempo);
		this.tempoCorrido = (this.dataFinal.getTime() - this.dataInicial.getTime())/60;
		this.telemetria.setTempoTotal(this.tempoCorrido.toString());
		Long tempoFinal = System.currentTimeMillis();
		response.append("TempoInicial: "+ this.telemetria.getDataInicial());
		response.append(" TempoFinal: "+ this.telemetria.getDataFinal());
		response.append(" Quantidade Retornada: " + pessoas.size());
		response.append(" Executado em: " + (tempoFinal - tempoInicial)/1000 + " segundos");
		PessoaResponseDTO pDTO = new PessoaResponseDTO();
		pDTO.setPessoa(pessoas);
		pDTO.setResponse(response.toString());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pDTO);
	}
	
	public ResponseEntity<Arquivo> uploadFile(MultipartFile file) {
		Arquivo arqResponse = new Arquivo();
		String tempo = "";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dataIni = new Date();
		tempo = (dateFormat.format(dataIni));
		arqResponse.setTempoInicial(tempo);
		try {
			arquivo.salvarArquivo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Date dataFim = new Date();
		tempo = "";
		tempo = (dateFormat.format(dataFim));
		arqResponse.setTempoFinal(tempo);
		arqResponse.setNome(file.getOriginalFilename());
		arqResponse.setTamanho(file.getSize());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(arqResponse);
	}
	
}
