# API de Tarefas: desafio Spring Boot

Desafio criado com IA para testar conhecimentos de nível estágio/júnior: criação de endpoints, modelagem do banco com PostgreSQL, camada de services para a lógica de negócio e DTOs para validar os campos obrigatórios da requisição.

> Nesta versão, a lógica de negócio ficou no controller.

Teste seu conhecimento também! :) Abaixo estão as especificações e o PDF gerado pela IA com o desafio completo.

## Tecnologias

- Java 25
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL

## Funcionalidades

- Cadastrar, consultar, atualizar e deletar (CRUD SIMPLES)
- Alterar o status da tarefa para "Em progresso" ou "Concluído"

## Endpoints

| Metodo | Rota | Descrição |
| --- | ---  | --- |
| POST| `/tasks` | Criar tarefa|
| POST| `/tasks/{id}/conclued`| Atualizar status da tarefa para "Concluido"|
| POST   | `/tasks/{id}/inProgress` | Atualizar status da tarefa para "Em progresso"|
| GET  | `/tasks`| Lista as tarefas|
| GET| `/tasks/{id}`| Busca uma tarefa por ID|
| DEL| `/tasks/{id}`| Deleta uma Tarefa por ID|

## Como rodar

1. Clone o repositório:

```bash
git clone https://github.com/freitasscaio/challenge-task.git
cd challenge-task
```

2. Configure o PostgreSQL em `src/main/resources/application.properties`.

3. Rode a aplicação:

```bash
./mvnw spring-boot:run
```

## Material

O desafio completo está no PDF abaixo, na **Parte 2 – Spring Boot: API de Tarefas (páginas 10 a 13)**.

[📄 Ver PDF do desafio](docs/desafio.pdf)