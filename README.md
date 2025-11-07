# 💼 Agregado Investimentos

**Status:** 🚧 *Em desenvolvimento (Work in Progress)*  
**Autor:** [@joaoneto-hub](https://github.com/joaoneto-hub)

---

## 🧩 Visão Geral

O **Agregado Investimentos** é um sistema em desenvolvimento, criado em **Java com Spring Boot**, voltado para o **gerenciamento e acompanhamento de investimentos**.

A proposta é fornecer uma API REST que permita cadastrar investimentos, registrar aplicações e acompanhar rentabilidades — servindo como base de estudos e evolução de um projeto financeiro real.

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3**
- **Spring Web** — Criação de endpoints REST
- **Spring Data JPA** — Persistência de dados
- **Lombok** — Redução de boilerplate
- **H2 Database** (ambiente de desenvolvimento)
- **Maven** — Build e dependências
- **Docker / Docker Compose** — Containerização da aplicação e banco

---

## 🗂️ Estrutura do Projeto

```
Agregado-investimentos/
├── .mvn/
├── mvnw / mvnw.cmd
├── pom.xml
├── docker-compose.yml
├── src/
│   ├── main/java/com/agregado/investimentos/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── service/
│   │   └── AgregadoInvestimentosApplication.java
│   └── main/resources/
│       └── application.yml
└── .gitignore
```

---

## 🚀 Como Executar

### ✅ Pré-requisitos
- Java 17 ou superior
- Maven instalado (ou usar o wrapper `./mvnw`)
- Docker (opcional)

### ▶️ Rodando localmente
```bash
# Clonar o repositório
git clone https://github.com/joaoneto-hub/Agregado-investimentos.git

# Entrar no diretório
cd Agregado-investimentos

# Executar com Maven
./mvnw spring-boot:run
```

A aplicação iniciará em:
```
http://localhost:8080
```

### 🐳 Usando Docker
```bash
docker-compose up
```

Isso criará os containers da aplicação e do banco de dados (caso configurado no `docker-compose.yml`).

---

## ⚙️ Configuração do Banco

O arquivo `src/main/resources/application.yml` define o banco de dados padrão.  
Por enquanto, está configurado para **H2 (em memória)** — ideal para ambiente de desenvolvimento.

Para produção, é possível ajustar para **PostgreSQL** ou outro banco compatível, alterando:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/agregado
    username: postgres
    password: admin
```

---

## 🧠 Próximos Passos

- [ ] Adicionar autenticação JWT  
- [ ] Criar dashboard com dados financeiros  
- [ ] Configurar testes automatizados  
- [ ] Documentar a API (Swagger / OpenAPI)

---

## 📜 Licença

Este projeto está sob a licença [MIT](LICENSE).

---

### 💬 Observação

Este é um projeto **experimental e em aprendizado**, criado para estudos sobre **Spring Boot**, **arquitetura em camadas** e **boas práticas no ecossistema Java**.

---

> ✨ *Agregado Investimentos — aprendendo, evoluindo e construindo valor digital.*
