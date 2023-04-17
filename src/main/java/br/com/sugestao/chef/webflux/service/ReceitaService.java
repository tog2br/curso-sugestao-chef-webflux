package br.com.sugestao.chef.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sugestao.chef.webflux.model.Receita;
import br.com.sugestao.chef.webflux.repository.ReceitaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Thiago de Luca
 *
 */
@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ChatGptService chatGptService;
	
	public Flux<Receita> findAll() {
		return receitaRepository.findAll();
	}
	
	public Mono<Receita> findById(Long id) {
		return receitaRepository.findById(id);
	}
	
	public Mono<Receita> save(Receita receita) {
		return receitaRepository.save(receita);
	}
	
	public Mono<Void> delete(Long id) {
		return this.findById(id)
				.flatMap(receitaRepository::delete);
	}
	
	public Mono<Receita> sugestao(Receita receita) {
		return chatGptService.getSugestao(receita.ingredientes())
				.flatMap(sugestao -> {
					return this.save(new Receita(null, receita.ingredientes(), sugestao));
				});				
	}

}