package br.com.benchmarkapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.benchmarkapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
