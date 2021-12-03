# pismo-test

Teste de avaliação criado por Alex Amaral

### Requisitos
    - Java 11 ou mais
    - Maven
    - Docker

### Contruir
Para facilitar a execução dos teste é nescessário fazer o pull das seguintes imagens do docker.

> docker pull postgres:postgres:12 

> docker pull testcontainersofficial/ryuk 

Para contruir a imagem do projeto execute o comando seguinte:

> mvn spring-boot:build-image

### Executar

Para subir a aplicação usando docker compose

> docker compose up

Para encerrar

> docker compose down

### Documentação da API

> http://localhost:9090/swagger-ui/index.html

