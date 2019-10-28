package br.com.benchmarkapi.controller;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.benchmarkapi.dto.PessoaDTO;
import br.com.benchmarkapi.dto.TempoProcessamentoAndPessoaDTO;
import br.com.benchmarkapi.model.Pessoa;
import br.com.benchmarkapi.repository.PessoaRepository;

@RestController
@RequestMapping("/")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoa;
	
	/**
	 * Scripr de criação
	 * CREATE TABLE pessoa (
    id int NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    sobre_nome varchar(100) NOT NULL,
    email varchar(150) NOT NULL,
    PRIMARY KEY (id)
		); 
	 * 
	 * */
	@GetMapping
	public ResponseEntity<String> test(){
		String text = "API de benchmark tcc "
				+ " \nLucas Marcelino Ferreira Rocha - 516726"
				+ "	\nSistemas de Informação "
				+ " \nPuc Minas ";
		return ResponseEntity.status(HttpStatus.OK).body(text);
	}
	
	@PostMapping("pessoa")
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa ps = this.pessoa.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
			.buildAndExpand(ps.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(ps);
	}
	
	@PostMapping("lista")
	public ResponseEntity<TempoProcessamentoAndPessoaDTO> salvarListaPessoas(@RequestBody List<PessoaDTO> lista){
		TempoProcessamentoAndPessoaDTO tpDTO = new TempoProcessamentoAndPessoaDTO();
		
		String tempo;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dataIni = new Date();
		tempo = (dateFormat.format(dataIni));
		tpDTO.setTempoInicial(tempo);
		
		List<Pessoa> pessoaList = new ArrayList<>();
		lista.forEach(x -> {
			Pessoa temp = new Pessoa();
			temp.setNome(x.getNome());
			temp.setSobreNome(x.getSobreNome());
			temp.setEmail(x.getEmail());
			pessoaList.add(temp);
		});
		
		pessoa.saveAll(pessoaList);

		Date dataFim = new Date();
		tempo = "";
		tempo = (dateFormat.format(dataFim));
		tpDTO.setTempoFinal(tempo);
		tpDTO.setQuantidade(pessoaList.size());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tpDTO);
	}
}
