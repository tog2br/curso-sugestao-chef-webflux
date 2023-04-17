package br.com.sugestao.chef.webflux.service;

import java.time.Duration;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import br.com.sugestao.chef.webflux.model.Saudacao;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Thiago de Luca
 *
 */
@Service
public class ChatGptService {

	private final String TOKEN_OPENAI = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	
	public Mono<String> getSugestao(String ingredientes) {
		OpenAiService service = new OpenAiService(TOKEN_OPENAI, Duration.ofSeconds(60));

		CompletionRequest completionRequest = CompletionRequest.builder()
		        .prompt("Sugira uma receita com os seguintes ingredientes: " + ingredientes)
		        .model("text-davinci-003")
		        .temperature(0.7)
		        .maxTokens(512)
		        .topP(1.0)
		        .frequencyPenalty(0.0)
		        .presencePenalty(0.0)
		        .bestOf(1)
		        .echo(false)
		        .build();
		String str = service.createCompletion(completionRequest).getChoices().stream().map(n -> String.valueOf(n.getText())).collect(Collectors.joining());
		System.out.println(str);
		return Mono.just(str);
	}
	
	public Mono<Saudacao> getSaudacao(Saudacao saudacao) {
		OpenAiService service = new OpenAiService(TOKEN_OPENAI, Duration.ofSeconds(60));

		CompletionRequest completionRequest = CompletionRequest.builder()
		        .prompt("dê uma saudação para " + saudacao.nome() + " que está aprendendo o curso do Thiago de Luca")
		        .model("text-davinci-003")
		        .temperature(0.7)
		        .maxTokens(128)
		        .topP(1.0)
		        .frequencyPenalty(0.0)
		        .presencePenalty(0.0)
		        .bestOf(1)
		        .echo(false)
		        .build();
		String str = service.createCompletion(completionRequest).getChoices().stream().map(n -> String.valueOf(n.getText())).collect(Collectors.joining());
		return Mono.just(new Saudacao(saudacao.nome(), str));
	}
}