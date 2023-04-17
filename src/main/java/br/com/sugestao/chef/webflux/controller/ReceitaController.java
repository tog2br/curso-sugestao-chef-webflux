package br.com.sugestao.chef.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sugestao.chef.webflux.model.Receita;
import br.com.sugestao.chef.webflux.model.Saudacao;
import br.com.sugestao.chef.webflux.service.ChatGptService;
import br.com.sugestao.chef.webflux.service.ReceitaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Thiago de Luca
 *
 */
@RestController
@RequestMapping("/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@Autowired
	private ChatGptService chatGptService;
	
	@GetMapping("/all")
	public Flux<Receita> findAll() {
		return receitaService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Mono<Receita> findById(@PathVariable("id") Long id) {
		return receitaService.findById(id);
	}
	
	@PostMapping
	public Mono<Receita> save(@RequestBody Receita receita) {
		return receitaService.save(receita);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable("id") Long id) {
		return receitaService.delete(id);
	}
	
	@PostMapping("/sugestao")
	public Mono<Receita> sugestao(@RequestBody Receita receita) {
		return receitaService.sugestao(receita);
	}
	
	@PostMapping("/saudacao")
	public Mono<Saudacao> saudacao(@RequestBody Saudacao saudacao) {
		return chatGptService.getSaudacao(saudacao);
	}
}