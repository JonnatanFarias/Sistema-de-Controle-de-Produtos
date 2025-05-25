SISTEMA DE CONTROLE DE PRODUTOS
================================

Este é um projeto simples de API RESTful para controle de produtos em estoque, desenvolvido com Spring Boot, Spring Data JPA e banco de dados relacional. A aplicação permite operações básicas de CRUD (Create, Read, Update, Delete) para produtos.

TECNOLOGIAS UTILIZADAS
----------------------
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Banco de dados relacional (ex: H2, MySQL ou PostgreSQL)
- Lombok

ESTRUTURA DO PROJETO
---------------------
```
com.estoque.app.produto
├── Produto.java           # Entidade JPA que representa o produto
├── ProdutoController.java # Controlador REST com os endpoints da API
├── ProdutoService.java    # Classe de serviço que implementa a lógica de negócio
├── ProdutoRepository.java # Interface de repositório JPA
```
COMO EXECUTAR
-------------
1. Clone o projeto:
   ```
   git clone https://github.com/JonnatanFarias/Sistema-de-Controle-de-Produtos.git
   ```
2. cd estoque-app

3. Configure o application.properties ou application.yml com os dados do seu banco. Exemplo com H2:
```
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```
4. Execute a aplicação:
   - Via IDE: Rode a classe principal com @SpringBootApplication
   - Via terminal:
     ./mvnw spring-boot:run

ENDPOINTS DA API
----------------
| Método | Endpoint         | Descrição                          |
|--------|------------------|------------------------------------|
| GET    | /produtos        | Lista todos os produtos            |
| GET    | /produtos/{id}   | Retorna produto por ID             |
| POST   | /produtos        | Cria um novo produto               |
| DELETE | /produtos/{id}   | Deleta um produto por ID           |
| PATCH  | /produtos/{id}   | Atualiza parcialmente um produto   |

EXEMPLO DE JSON PARA CRIAÇÃO DE PRODUTO
---------------------------------------
```json
{
  "nome": "Caneta Azul",
  "quantidade": 50,
  "descricao": "Caneta esferográfica azul."
}
```
EXEMPLO DE JSON PARA ATUALIZAÇÃO PARCIAL (PATCH)
------------------------------------------------
```json
{
  "quantidade": 60
}
```

ANOTAÇÕES IMPORTANTES
----------------------
- A anotação @Entity define a classe Produto como uma entidade JPA.
- O Lombok é utilizado para reduzir a verbosidade com anotações como @Data, @NoArgsConstructor e @AllArgsConstructor.
- O ProdutoRepository estende JpaRepository, fornecendo métodos prontos para operações com o banco de dados.
- A atualização parcial com PATCH foi implementada para permitir modificações específicas nos campos do produto.

FUNCIONALIDADES FUTURAS (SUGESTÕES)
-----------------------------------
- Paginação e ordenação
- Autenticação e autorização com Spring Security
- Integração com Swagger para documentação da API


