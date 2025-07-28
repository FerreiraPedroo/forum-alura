# 📚 Fórum Alura API

API REST desenvolvida em Java com Spring Boot para gerenciamento de tópicos e respostas de um fórum educacional. O projeto é parte de um estudo prático envolvendo autenticação, JPA, segurança com JWT e boas práticas em arquitetura de software.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT (JSON Web Token)
- Maven

---

## 📦 Funcionalidades

- Cadastro de usuários
- Login com autenticação JWT
- Criação e listagem de tópicos
- Atualização e exclusão de tópicos
- Validação de dados

---

## 🗂 Estrutura do Projeto

```bash
forum-alura/
├── controller/          # Camada de exposição da API (REST Controllers)
├── dto/                 # Objetos de transferência de dados (entrada e saída)
├── model/               # Entidades JPA mapeadas para o banco
├── repository/          # Interfaces de acesso ao banco de dados
├── service/             # Serviços da aplicação
├── config/              # Configurações (segurança, CORS, etc.)
└── main/                # Classe principal da aplicação Spring Boot
```

## ⚙️ Configuração

1. Clone o repositório:
git clone https://github.com/FerreiraPedroo/forum-alura.git
cd forum-alura

2. Configure o banco de dados em `src/main/resources/application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/forum_alura <br/>
spring.datasource.username= seu usuario <br/>
spring.datasource.password= sua senha <br/>
spring.jpa.hibernate.ddl-auto=update <br/>

4. Execute a aplicação:
./mvnw spring-boot:run

---

## 🔐 Segurança e Autenticação

- A autenticação é baseada em JWT.
- Após o login, um token é retornado.
- Inclua o token no cabeçalho das requisições protegidas: Authorization: Bearer <seu_token>


---

## 📌 Exemplos de Endpoints

| Método | Endpoint         | Descrição               | Autenticação |
|--------|------------------|-------------------------|--------------|
| POST   | `/login`         | Login e geração de JWT  | ❌           |
| GET    | `/topicos`       | Listar tópicos          | ✅           |
| POST   | `/topicos`       | Criar tópico            | ✅           |
| PUT    | `/topicos/{id}`  | Atualizar tópico        | ✅           |
| DELETE | `/topicos/{id}`  | Remover tópico          | ✅           |
| POST   | `/respostas`     | Criar resposta          | ✅           |

---

## ✅ Requisitos

- Java 17 ou superior
- Maven 3.8+
- MySQL 8+
- IDE compatível (IntelliJ, VSCode, Eclipse)

---

## 🧑‍💻 Autor

**Pedro Henrique Ferreira**  
GitHub: [@FerreiraPedroo](https://github.com/FerreiraPedroo)

---

## 📃 Licença

Distribuído sob a licença MIT.  
Veja mais em [`LICENSE`](LICENSE).







