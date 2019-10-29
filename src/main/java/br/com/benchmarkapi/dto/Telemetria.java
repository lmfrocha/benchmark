package br.com.benchmarkapi.dto;

import java.io.Serializable;

public class Telemetria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String dataInicial;
	private String dataFinal;
	private String tempoTotal;
	private String sequenciaFibonacci;
	private String quantidadeDePessoas;
	
	public Telemetria() {}
	
	public String getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public String getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public String getTempoTotal() {
		return tempoTotal;
	}
	
	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	
	public String getSequenciaFibonacci() {
		return sequenciaFibonacci;
	}
	
	public void setSequenciaFibonacci(String sequenciaFibonacci) {
		this.sequenciaFibonacci = sequenciaFibonacci;
	}
	
	public String getQuantidadeDePessoas() {
		return quantidadeDePessoas;
	}
	
	public void setQuantidadeDePessoas(String quantidadeDePessoas) {
		this.quantidadeDePessoas = quantidadeDePessoas;
	}
}
