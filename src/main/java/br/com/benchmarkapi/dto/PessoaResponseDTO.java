package br.com.benchmarkapi.dto;

import java.io.Serializable;
import java.util.List;

import br.com.benchmarkapi.model.Pessoa;

public class PessoaResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas;
	
	private String response;
	
	public PessoaResponseDTO() {}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoa(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
