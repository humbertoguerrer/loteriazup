# Desafio Orange Talents

Este projeto foi desenvolvido como desafio do programa de recrutamento Orange Talents da empresa Zup.

## Objetivo

Implementar uma API REST que simula um sistema de apostas e tem 2 endpoints.

O primeiro endpoint irá cadastrar um jogador e irá gerar números aletórios com os quais ele irá concorrer, não podendo cadastrar jogadores com e-mails repetidos.
Já o segundo endpont irá listar as apostas o jogador através do e-mail, em ordem de criação.

## Tecnologias

- Java 11
- Spring Boot (Data JPA e Spring Web)
- MySQL
- Spring Tool Suite

## Hospedagem

A API REST foi hospedada no Heroku, é possível obter alguns retornos já cadastrados acessando os seguintes endereços:

Obs: como a aplicação no Heroku fica dormente após determinado tempo inativa, pode ser necessário esperar um pouco :)

<https://loteria-zup.herokuapp.com/jogador/maria@gmail.com>

<https://loteria-zup.herokuapp.com/jogador/joao@gmail.com>

<https://loteria-zup.herokuapp.com/jogador/fernando@gmail.com>


## Utilização dos endpoints

- Cadastrando jogador e gerando apostas:

Enviar uma requisição POST para <https://loteria-zup.herokuapp.com/jogador/>

O corpo do Json deverá ser passado como abaixo:
```
{
    "nome": "alcides",
    "email": "alcides@gmail.com",
    "qtdAposta": 3
}
```
Retorno:

```
{
    "email": "alcides@gmail.com",
    "apostas": [
        240,
        699,
        909
    ]
}
```

GET - chamar a URL com o e-mail cadastrado inicialmente: <https://loteria-zup.herokuapp.com/jogador/alcides@gmail.com>

Retorno
```
{
    "email": "alcides@gmail.com",
    "apostas": [
        240,
        699,
        909
    ]
}
```
