# Caixa Eletrônico :heavy_check_mark:

Esta é uma aplicação back-end que simule uma movimentação de entrega de notas quando um cliente efetua um saque em um caixa eletrônico. As notas disponíveis são R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00. Este desafio esta foi proposta em [DojoPuzzles.com](http://dojopuzzles.com/problemas/exibe/caixa-eletronico/)


## Linguagens e libs utilizadas :books:

- Java EE
- Thorntail

A aplicação foi desenvolvida usando os componentes da especificação Java EE 7 tais como CDI, JAX-RS entre outros. Ela é executada em um servidor 100% compatível com a especificação Java EE 7 o Thorntail que um servidor voltado para micro serviços pois possibilita subir somente os componentes necessários para  aplicação rodar e não toda lista de componentes da especificação. Toda a cobertura de teste foi feita usando JUnit com testes unitários.

## Como rodar a aplicação com Thorntail: :arrow_forward:

### Pré-requisitos
- Java JDK 8
- Apache Maven 3.5.4 ou superior

### Rodando
Executar o arquivos run.sh apos o start do servidor a aplicação fica disponível em http://localhost:10000/caixa-eletronico/. 

## O que a aplicação é capaz de fazer :checkered_flag:

1. Gerar uma movimentação que não tem limite de notas.
    - http://localhost:10000/caixa-eletronico/api/movimentacoes/livres/{valor}/ [POST]
    - Caso o valor informado não for um múltiplo de 10 é apresenta uma resposta com status 422 informando o cliente desta regra
2. Gerar uma movimentação que tem limite de notas definido na aplicação.
    - http://localhost:10000/caixa-eletronico/api/movimentacoes/livres/{valor}/ [POST]
    - Caso o valor informado não for um múltiplo de 10 apresenta uma resposta com status 422 informando o cliente desta regra
    - Caso o valor informado ultrapasse o total disponível de cédulas é apresentada uma resposta com status 422 informando o cliente da indisponibilidade de cédulas
3. Lista as movimentações realizadas
    - http://localhost:10000/caixa-eletronico/api/extratos/ [GET]
4. Lista as movimentações realizadas paginadas 
    - http://localhost:10000/caixa-eletronico/api/extratos/paginadas?limit={}&offset={} [GET]
    - Caso não informado os valores a aplicação usa os padrões limit=10 e offset=0
    