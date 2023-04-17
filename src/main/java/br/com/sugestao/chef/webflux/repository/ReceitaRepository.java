package br.com.sugestao.chef.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import br.com.sugestao.chef.webflux.model.Receita;

/**
 * 
 * @author Thiago de Luca
 *
 */
public interface ReceitaRepository extends ReactiveCrudRepository<Receita, Long> {
}