/**
 * 
 */
package br.com.sugestao.chef.webflux.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.sugestao.chef.webflux.model.Receita;
import br.com.sugestao.chef.webflux.repository.ReceitaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author Thiago de Luca
 *
 */
class ReceitaServiceTest {
	
	@Mock
	private ReceitaService receitaService;
	
	@Mock
	private ReceitaRepository repository;
	
	private Receita receita;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		receita = new Receita(1l, "salmao, alcaparras", "Salmao grelhado com alcaparras");
	}

	/**
	 * Test method for {@link br.com.sugestao.chef.webflux.service.ReceitaService#findAll()}.
	 */
	@Test
	void testFindAll() {
		when(repository.findAll()).thenReturn(Flux.just(receita));
		when(receitaService.findAll()).thenReturn(Flux.just(receita));
		
		StepVerifier.create(receitaService.findAll())
		.expectSubscription()
        .assertNext(receitaResponse -> {
            assertEquals(receitaResponse.id(), receita.id());
        })
        .verifyComplete();
        		
	}

	/**
	 * Test method for {@link br.com.sugestao.chef.webflux.service.ReceitaService#findById(java.lang.Long)}.
	 */
	@Test
	void testFindById() {
		when(repository.findById(receita.id())).thenReturn(Mono.just(receita));
		when(receitaService.findById(receita.id())).thenReturn(Mono.just(receita));
		
		StepVerifier.create(receitaService.findById(receita.id()))
		.expectSubscription()
        .assertNext(receitaResponse -> {
            assertEquals(receitaResponse.id(), receita.id());
        })
        .verifyComplete();
	}

	/**
	 * Test method for {@link br.com.sugestao.chef.webflux.service.ReceitaService#save(br.com.sugestao.chef.webflux.model.Receita)}.
	 */
	@Test
	void testSave() {
		when(repository.save(receita)).thenReturn(Mono.just(receita));
		when(receitaService.save(receita)).thenReturn(Mono.just(receita));
		
		StepVerifier.create(receitaService.save(receita))
		.expectSubscription()
        .assertNext(receitaResponse -> {
            assertEquals(receitaResponse.id(), receita.id());
        })
        .verifyComplete();
	}

	/**
	 * Test method for {@link br.com.sugestao.chef.webflux.service.ReceitaService#delete(java.lang.Long)}.
	 */
	@Test
	void testDelete() {
		when(repository.findById(receita.id())).thenReturn(Mono.just(receita));
		when(repository.delete(receita)).thenReturn(Mono.empty());
		when(receitaService.delete(receita.id())).thenReturn(Mono.empty());
		
		StepVerifier.create(receitaService.delete(receita.id()))
		.expectSubscription()
        .verifyComplete();
	}

	/**
	 * Test method for {@link br.com.sugestao.chef.webflux.service.ReceitaService#sugestao(br.com.sugestao.chef.webflux.model.Receita)}.
	 */
	@Test
	void testSugestao() {		
		when(repository.save(receita)).thenReturn(Mono.just(receita));
		when(receitaService.save(receita)).thenReturn(Mono.just(receita));
		when(receitaService.sugestao(receita)).thenReturn(Mono.just(receita));
		
		StepVerifier.create(receitaService.sugestao(receita))
		.expectSubscription()
        .assertNext(receitaResponse -> {
            assertEquals(receitaResponse.id(), receita.id());
        })
        .verifyComplete();
	}

}
