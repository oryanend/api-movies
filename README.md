# 📌 Movies API 🎬
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/oryanend/api-movies/blob/main/LICENSE)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?logo=intellij-idea&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff)](#)

# Sobre o projeto

Movies API é uma API RESTful CRUD desenvolvida para gerenciar um blog de filmes. Usuários podem criar, visualizar, atualizar e deletar registros de filmes, além de comentar e avaliar os títulos cadastrados.


# Diagrama de Classe
![ClassDiagram](https://github.com/oryanend/api-movies/blob/main/Assets/ClassDiagramMoviesApi.jpg)

Esse diagrama representa a estrutura do banco de dados da API Movies. Ele define as principais entidades e seus relacionamentos:
- **User**: Representa os usuários que podem fazer comentários sobre filmes.
- **Comment**: Armazena os comentários dos usuários nos filmes.
- **Movie**: São as informações dos filmes, incluindo título, data de lançamento, descrição e nota de avaliação.
- **Category**: Classifica os filmes em diferentes categorias (ação, comédia, terror, etc.).
- **Actor**: Representa os atores que participaram nos filmes.

## Passo a Passo para Rodar a Aplicação Localmente
A API já está funcionando no link acima, mas caso você queira testá-la localmente no seu computador, siga os passos abaixo:

*`Pré-requisitos: Java 17`*

**1. Clone a aplicação**

```bash
git clone https://github.com/oryanend/api-movies.git
cd api-movies
```

**2. Crie o Banco de Dados (PostgresSQL)**

```bash
create database springboot_movies
```
- Carregue o script no PostgreSQL: `src/main/resources/script.sql`


**3. Troque o username e a password**

O PostgreSQL requer que você defina um usuário e senha para acesso.

+ abra `src/main/resources/application-dev.properties`

+ Edite as seguintes linhas com suas credenciais do PostgreSQL:
```bash
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

**4. Troque o perfil da Aplicação**

+ abra `src/main/resources/application.properties`
+ Altere a linha 2 do arquivo para:
```bash
spring.profiles.active=dev
```

**5. Inicie a Aplicação**
Agora que tudo está configurado, basta iniciar a aplicação!
```bash
mvn spring-boot:run
```

A aplicação estará disponível em:
➡ http://localhost:8080

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- PostgreSQL

## Implantação em produção
- Backend: Railway

# Autor

Ryan de Almeida Oliveira

https://www.linkedin.com/in/oryanend
