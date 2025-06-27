# 🏛️ Agora – Sistema de Gestão de Associações

Sistema de gestão voltado para associações comunitárias, com foco na organização de associados, projetos, diretoria, controle financeiro e relatórios administrativos.

## 🎯 Objetivo

O objetivo do **Agora** é proporcionar uma plataforma digital organizada e acessível para que associações possam:

- Cadastrar e manter os dados de seus associados
- Registrar e acompanhar projetos ativos e concluídos
- Relacionar associados aos projetos dos quais participam
- Registrar gestões de diretoria ao longo do tempo
- Controlar receitas e despesas (módulo financeiro)
- Emitir relatórios gerenciais e administrativos

---

## 🧩 Módulos do Sistema

| Módulo                        | Status       |
|------------------------------|--------------|
| 📇 Cadastro de Associados     | [x] Concluído |
| 🗂️ Cadastro de Projetos       | [x] Em desenvolvimento |
| 👥 Associados em Projetos     | ⬜ Em desenvolvimento |
| 🧑‍💼 Cadastro de Diretoria     | ⬜ Em planejamento |
| 💰 Módulo Financeiro          | ⬜ Em planejamento |
| 📈 Relatórios Gerais          | ⬜ Em planejamento |
| 🌐 Front-end (React/Vue/etc.) | ⬜ Futuro     |

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Web, Spring Data JPA
- ModelMapper
- Swagger (OpenAPI 3)
- Banco de dados relacional (MySQL / PostgreSQL)
- Lombok
- [Futuro] React ou Vue.js para o front-end

---

## 📌 Roadmap Técnico (Back-end)

### 🧱 Etapa 1 – Estrutura Base

- [x] Criação das entidades (`Associado`, `Projeto`, `Diretoria`, `Participacao`)
- [x] DTOs e Records para transporte de dados
- [x] Repositórios JPA
- [x] Configuração Swagger

---

### 📋 Etapa 2 – Módulo de Cadastros

- [x] Associado (CRUD + Validações)
- [ ] Projeto (CRUD + Ativação/Inativação)
- [ ] Diretoria (CRUD + Histórico de gestão)
- [ ] Participação de Associado em Projeto

---

### 💼 Etapa 3 – Módulo Financeiro

- [ ] Definição da estrutura de dados (entradas/saídas)
- [ ] Cadastro de lançamentos financeiros
- [ ] Filtros por período e tipo
- [ ] Resumo financeiro

---

### 📊 Etapa 4 – Relatórios

- [ ] Associados cadastrados
- [ ] Projetos por período
- [ ] Projetos por associado
- [ ] Diretoria atual e passadas
- [ ] Fluxo financeiro

---

### 🌐 Etapa 5 – Front-end (Futuro)

- [ ] Escolha da stack (React ou Vue)
- [ ] Integração com API
- [ ] Interface responsiva e amigável
- [ ] Painel de controle (dashboard)

---

## 📊 Estrutura das Entidades (Tabelas)

### 🧍‍♂️ Associado

| Campo         | Tipo      | Descrição                           |
|---------------|-----------|-------------------------------------|
| `id`          | Long      | Identificador único                 |
| `nome`        | String    | Nome completo                       |
| `cpf`         | String    | Cadastro de Pessoa Física (único)  |
| `email`       | String    | E-mail de contato                   |
| `telefone`    | String    | Telefone                            |
| `dataEntrada` | LocalDate | Data de entrada na associação       |

---

### 📁 Projeto

| Campo         | Tipo      | Descrição                           |
|---------------|-----------|-------------------------------------|
| `id`          | Long      | Identificador único                 |
| `nome`        | String    | Nome do projeto                     |
| `descricao`   | String    | Descrição resumida                  |
| `dataInicio`  | LocalDate | Início do projeto                   |
| `dataFim`     | LocalDate | Fim do projeto (opcional)           |
| `ativo`       | Boolean   | Se o projeto está ativo             |

---

### 👥 Participacao (Relaciona Associado ↔ Projeto)

| Campo         | Tipo      | Descrição                                 |
|---------------|-----------|-------------------------------------------|
| `id`          | Long      | Identificador único                       |
| `associadoId` | Long (FK) | FK para `Associado`                       |
| `projetoId`   | Long (FK) | FK para `Projeto`                         |
| `dataEntrada` | LocalDate | Data de início da participação            |
| `dataSaida`   | LocalDate | Data de saída da participação (opcional)  |

---

### 🧑‍💼 Diretoria

| Campo         | Tipo      | Descrição                                 |
|---------------|-----------|-------------------------------------------|
| `id`          | Long      | Identificador único                       |
| `cargo`       | String    | Cargo ocupado (Presidente, Tesoureiro...) |
| `associadoId` | Long (FK) | FK para `Associado`                       |
| `gestaoInicio`| LocalDate | Início da gestão                          |
| `gestaoFim`   | LocalDate | Fim da gestão (opcional)                  |

---

### 💰 LancamentoFinanceiro *(planejado)*

| Campo      | Tipo        | Descrição                                  |
|------------|-------------|--------------------------------------------|
| `id`       | Long        | Identificador único                        |
| `tipo`     | Enum        | ENTRADA ou SAÍDA                           |
| `descricao`| String      | Descrição do lançamento                    |
| `valor`    | BigDecimal  | Valor monetário                            |
| `data`     | LocalDate   | Data do lançamento                         |
| `categoria`| String      | Categoria (ex: contribuição, evento, etc.) |

