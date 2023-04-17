# Sugestão do Chef API

Projeto criado para aulas de Spring WebFlux com integração com o ChatGPT


# Descrição da API

O projeto tem como objetivo a criação de um CRUD simples utilizando o banco H2 e com integração com o ChatGPT.

A criação da tabela está no arquivo /curso-sugestao-chef-webflux/src/main/resources/schema/schema.sql

O usuário pode utilizar os endpoints da classe ReceitaController para inserir Receita com os ingredientes, buscar todas, buscar por Id e deletar.

Esses são os endpoints para explicação do CRUD.

Ao chamar o endpoint "/sugestao", passando os ingredientes, o sistema faz a comunicação com o ChatGPT e retorna uma receita sugerida pela inteligência artificial baseada nos ingredientes que foram passados e salva no banco de dados.

De bônus, temos o endpoint "/saudacao", onde ao ser chamado passando o body apenas com o nome, o sistema faz a comunicação com o ChatGPT e retorna uma saudação para o nome passado.


# Modo de Usar

Para utilizar o sistema com a integração com o ChatGpt, você deve criar uma chave na API do OpenAi e colocar a chave na constante TOKEN_OPENAI da classe br.com.sugestao.chef.webflux.service.ChatGptService.

Para gerar a chave, basta criar um usuário no site OpenAi e acessar o link abaixo:

- <a href="https://platform.openai.com/account/api-keys" target="_blank">https://platform.openai.com/account/api-keys</a>

Após adicionar a chave, basta rodar o projeto pela classe main: br.com.sugestao.chef.webflux.CursoSugestaoChefWebfluxApplication


# Collection

A Collection de exemplo do Postman e do Swagger está na pasta /curso-sugestao-chef-webflux/src/main/resources/docs/


### Autor
---

<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/3602083?v=4" width="100px;" alt=""/>
<sub><b>Thiago de Luca</b></sub></a>

[![Linkedin Badge](https://img.shields.io/badge/-Thiago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/thiago-goncalves-1b902521/)](https://www.linkedin.com/in/thiago-goncalves-1b902521/) 
[![Gmail Badge](https://img.shields.io/badge/-tog2br@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:tog2br@gmail.com)](mailto:tog2br@gmail.com)

