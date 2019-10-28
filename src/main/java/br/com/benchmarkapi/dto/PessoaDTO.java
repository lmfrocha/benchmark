package br.com.benchmarkapi.dto;

import java.io.Serializable;

public class PessoaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobreNome;
	private String email;
	
	public PessoaDTO(String nome, String sobreNome, String email) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
	}
	
	public PessoaDTO() {}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
