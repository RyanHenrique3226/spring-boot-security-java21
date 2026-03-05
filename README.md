# Spring Boot Security – Role Based Authentication (Java 21)

Projeto de estudo desenvolvido durante um **bootcamp**, utilizando **Spring Boot 3.x** e **Spring Security 6**, com autenticação via formulário e controle de acesso baseado em **roles**.

Embora o conteúdo original do curso utilizasse versões antigas do Spring (Spring Boot 2.x) e Java 8, este projeto foi **refatorado e adaptado** para funcionar corretamente com **Java 21** e a **configuração moderna do Spring Security**, evitando APIs legadas.

---

##  Tecnologias Utilizadas

* Java 21
* Spring Boot 3.5.x
* Spring Security 6
* Gradle
* BCrypt Password Encoder

---

##  Funcionalidades

* Autenticação via **formLogin** (padrão do Spring Security)
* Usuários em memória (`InMemoryUserDetailsManager`)
* Senhas criptografadas com **BCrypt**
* Autorização baseada em **roles**
* Proteção de métodos com `@PreAuthorize`
* Redirecionamento automático após login conforme a role do usuário
* Configuração baseada em `SecurityFilterChain` (padrão atual)

---

##  Usuários de Teste

| Usuário  | Senha       | Role    |
| -------- | ----------- | ------- |
| User1    | password123 | USER    |
| Manager1 | manager123  | MANAGER |

> ⚠️ Credenciais utilizadas apenas para fins de estudo.

---

##  Rotas da Aplicação

| Rota       | Acesso                       |
| ---------- | ---------------------------- |
| `/login`   | Página de login              |
| `/users`   | USER e MANAGER               |
| `/manager` | Apenas MANAGER               |
| `/`        | Qualquer usuário autenticado |

---

##  Fluxo de Autenticação

1. Usuário tenta acessar uma rota protegida
2. Spring Security redireciona para `/login`
3. Usuário realiza o login
4. Após autenticação:

   * Usuário com role **USER** → redirecionado para `/users`
   * Usuário com role **MANAGER** → redirecionado para `/manager`
5. O acesso aos endpoints é validado também via `@PreAuthorize`

---

##  Como Executar o Projeto

### 1️. Clone o repositório

```bash
git clone <https://github.com/RyanHenrique3226/spring-boot-security-java21>
```

### 2️. Execute a aplicação

```bash
./gradlew bootRun
```

### 3️. Acesse no navegador

```text
http://localhost:8080/login
```

---

##  Observações Importantes

* O projeto utiliza **Spring Security moderno**, compatível com Spring Boot 3.x
* Não utiliza `WebSecurityConfigurerAdapter` (API legada)
* A autenticação é configurada via `SecurityFilterChain`
* Usuários são mantidos apenas em memória (ideal para estudos)
* Projeto estruturado para facilitar futuras evoluções

---

##  Contexto do Projeto

Este projeto foi desenvolvido a partir de um **bootcamp**, no qual os materiais utilizavam versões antigas do Spring e Java.

Como exercício prático e aprofundamento, o código foi:

* Reescrito para **Spring Boot 3.x**
* Atualizado para **Java 21**
* Adaptado para o **novo modelo de configuração do Spring Security**
* Ajustado para remover APIs depreciadas ou obsoletas

Esse processo ajudou a consolidar o entendimento das **mudanças entre versões** e das **boas práticas atuais** do ecossistema Spring.

---

##  Próximos Passos (Evoluções Possíveis)

* Persistência de usuários com JPA
* Autenticação baseada em JWT
* Página de login customizada
* Tratamento personalizado de erros 401 e 403
* Testes automatizados de segurança

---

##  Autor

Projeto desenvolvido para fins de estudo e portfólio, com foco em práticas modernas do ecossistema Spring e adaptação de código legado para versões atuais.
