# 🏥 Agenda Clínica API

API REST desenvolvida com Spring Boot para gerenciamento de consultas médicas, incluindo cadastro de médicos, clientes e agendamento de consultas com regras de negócio.

---

## 🚀 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* JWT (JSON Web Token)
* PostgreSQL
* Swagger / OpenAPI
* Lombok

---

## 📌 Funcionalidades

✔ Cadastro de médicos
✔ Cadastro de clientes
✔ Agendamento de consultas
✔ Cancelamento de consultas
✔ Validações de regras de negócio
✔ Autenticação com JWT
✔ Documentação interativa com Swagger

---

## 🔐 Autenticação (JWT)

A API utiliza autenticação baseada em **JWT**.

### 🔑 Como funciona:

1. Faça login na rota:

```
POST /login
```

```json
{
  "login": "admin",
  "senha": "123456"
}
```

2. Você receberá um token:

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

3. Envie o token nas requisições protegidas:

```
Authorization: Bearer SEU_TOKEN_AQUI
```

---

## 📚 Documentação com Swagger

A documentação da API está disponível em:

```
http://localhost:8080/swagger-ui/index.html
```

### 🔓 Como autenticar no Swagger:

1. Clique em **Authorize 🔒**
2. Insira:

```
Bearer SEU_TOKEN
```

3. Agora você pode testar endpoints protegidos

---

## 🧠 Regras de negócio implementadas

* ❌ Não permite agendar consultas no passado
* ❌ Não permite conflito de horários (médico)
* ❌ Não permite paciente com duas consultas no mesmo horário
* ❌ Não permite consultas fora do horário da clínica
* ❌ Não permite agendar com médico inativo
* ❌ Não permite agendar com cliente inativo

---

## ⏰ Horário de funcionamento da clínica

* Segunda a Sábado
* 07:00 às 18:00

---

## 🗄️ Banco de dados

Utiliza PostgreSQL.

### Exemplo de configuração:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/agenda_clinica
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

---

## 🔑 Variável de ambiente JWT

A chave secreta do token deve ser definida como variável de ambiente:

### Windows (CMD):

```
setx JWT_SECRET "sua-chave-secreta"
```

### application.properties:

```properties
api.security.token.secret=${JWT_SECRET}
```

---

## ▶️ Como rodar o projeto

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/agenda-clinica-api.git
```

2. Configure o banco de dados

3. Execute a aplicação:

```
mvn spring-boot:run
```

---

## 🧪 Testes

Você pode testar a API usando:

* Swagger UI
* Postman

---

## 📁 Estrutura do projeto

```
controller/
service/
repository/
entity/
dto/
security/
validador/
```

---

## 👨‍💻 Autor

**Yago Rocha**
📧 [yagodsrocha@gmail.com](mailto:yagodsrocha@gmail.com)

---

## 📜 Licença

Este projeto está sob a licença Apache 2.0
