# DSCommerce - Desafio DevSuperior

Este projeto foi desenvolvido como parte de um desafio do curso **DevSuperior**, com o objetivo de consolidar conhecimentos práticos na construção de APIs RESTful utilizando o ecossistema **Spring Boot**. 

O foco principal deste projeto é o estudo aplicado e o aprimoramento técnico em duas frentes fundamentais: o mapeamento objeto-relacional avançado com **JPA/Hibernate** e a implementação de um sistema robusto de segurança utilizando **Autenticação OAuth2**.

---

## 🏗️ Arquitetura e Estrutura do Projeto

O sistema foi estruturado com base em uma **Arquitetura em Camadas** (*Layered Architecture*), garantindo a separação clara de responsabilidades, facilitando a manutenção e a escalabilidade do código:

* **Controladores (Web/Controllers):** Responsáveis por expor os endpoints REST, lidar com o roteamento HTTP, realizar a paginação de recursos e validar os dados de entrada.
* **Serviços (Service):** Camada onde reside a lógica de negócio. Ela atua como a orquestradora entre os controladores e o acesso aos dados, garantindo a integridade das regras do domínio (como cálculo de totais de pedidos e validação de permissões de usuário).
* **Acesso a Dados (Repositories):** Interfaces do Spring Data JPA que abstraem a comunicação com o banco de dados.

---

## 🧩 Padrões Arquiteturais e Boas Práticas

* **DTO (Data Transfer Object):** Aplicação intensiva do padrão DTO (ex: `ProductDTO`, `UserDTO`, `OrderDTO`) para isolar as Entidades de Domínio (`Entities`) da camada Web. Isso evita problemas de serialização (como *LazyInitializationException*) e o risco de *Over-Posting*, garantindo que apenas os dados necessários sejam trafegados na API.
* **Global Exception Handling:** Tratamento centralizado de exceções utilizando `@ControllerAdvice` (`ControllerExceptionHandler`). Todas as respostas de erro da API são padronizadas em objetos específicos (como `CustomErrorDTO` e `ValidationErrorDTO`), cobrindo cenários como *404 Not Found*, *403 Forbidden*, *422 Unprocessable Entity* (para validações de formulário) e *400 Bad Request*.
* **Mapeamento JPA Avançado:** Implementação de relacionamentos complexos de banco de dados (One-to-Many, Many-to-One, Many-to-Many) e uso de chaves primárias compostas (`@EmbeddedId` e `@Embeddable` na classe `OrderItemPK`) para representar tabelas associativas com atributos extras.
* **Projections:** Utilização do Spring Data Projections (ex: `UserDetailsProjection`) para otimizar consultas específicas no banco de dados, buscando apenas as colunas essenciais quando a entidade completa não é necessária.

---

## 🔐 Segurança e Autenticação (OAuth2)

A segurança da aplicação é tratada de forma robusta, isolando as responsabilidades de autorização e autenticação:

* **Authorization & Resource Server:** Configuração de um servidor de autorização e um servidor de recursos próprios (`AuthorizationServerConfig` e `ResourceServerConfig`).
* **Autenticação JWT:** Geração e validação de tokens JWT (JSON Web Token) sem estado (*stateless*).
* **Custom Password Grant:** Adaptação das classes de autenticação (`CustomPasswordAuthenticationProvider`, `CustomUserAuthorities`) para suportar o fluxo de concessão de credenciais de senha do OAuth2 no Spring Security mais recente.
* **Controle de Acesso (RBAC):** Proteção de rotas baseada nos perfis dos usuários (`ROLE_CLIENT`, `ROLE_ADMIN`), garantindo que clientes só possam acessar seus próprios pedidos, enquanto administradores têm acesso gerencial completo.

---

## 🚀 Tecnologias Utilizadas

* **Java** * **Spring Boot** (Web, Data JPA, Security, Validation)
* **Spring Security OAuth2** / JWT
* **Maven** (Gerenciamento de dependências e build)
* **Banco de Dados Relacional** (H2 Database para testes e PostgreSQL para ambiente de produção)
* **Postman** (Para testes da API e simulação do fluxo OAuth2)

---
*Projeto desenvolvido com fins de estudo e aprimoramento técnico, aplicando desafios propostos no ecossistema de desenvolvimento back-end corporativo.*
