/**
 * 
 */
package br.com.sugestao.chef.webflux.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

import br.com.sugestao.chef.webflux.model.Saudacao;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author Thiago de Luca
 *
 */
class ChatGptServiceTest {
	
	@Mock
	private ChatGptService chatGptService;
	
	@Mock
	private OpenAiService service;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	void test_sugestao() {
		CompletionResult completionResult = new CompletionResult();
		CompletionChoice choice = new CompletionChoice();
		choice.setText("Teste de sugestao");
		completionResult.setChoices(List.of(choice));

		when(chatGptService.getSugestao(anyString())).thenReturn(Mono.just("Teste de sugestao"));
		
		StepVerifier.create(chatGptService.getSugestao(anyString()))
		.expectSubscription()
        .assertNext(text -> {
            assertEquals(text, choice.getText());
        })
        .verifyComplete();
	}

	@Test
	void test_saudacao() {
		Saudacao saudacao = new Saudacao("Teste", "Ola teste");
		
		when(chatGptService.getSaudacao(any())).thenReturn(Mono.just(saudacao));
		
		StepVerifier.create(chatGptService.getSaudacao(any()))
		.expectSubscription()
        .assertNext(text -> {
            assertEquals(text.saudacao(), saudacao.saudacao());
        })
        .verifyComplete();
	}

}
