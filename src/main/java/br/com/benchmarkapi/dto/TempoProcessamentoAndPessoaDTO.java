package br.com.benchmarkapi.dto;

import java.io.Serializable;

public class TempoProcessamentoAndPessoaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String tempoInicial;
	private String tempoFinal;
	private int quantidade;
	
	public TempoProcessamentoAndPessoaDTO() {}
	
	public TempoProcessamentoAndPessoaDTO(String tempoInicial, String TempoFinal, int quantidade) {
		this.tempoInicial = tempoInicial;
		this.tempoFinal = TempoFinal;
		this.quantidade = quantidade;
	}

	public String getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(String tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public String getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(String tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
