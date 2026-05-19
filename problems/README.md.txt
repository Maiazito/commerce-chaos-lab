# Commerce Chaos Lab

Laboratório de falhas e resiliência para estudo de backend utilizando Java + Spring Boot.

O objetivo deste projeto NÃO é criar um ecommerce profissional.

A ideia é construir um sistema simples e utilizá-lo para estudar:

- falhas reais
- concorrência
- problemas de produção
- resiliência
- arquitetura backend
- escalabilidade
- consistência de dados
- recuperação de erros

---

# Objetivo do Projeto

Este projeto funciona como um ambiente de estudo para simular problemas reais encontrados em sistemas modernos de ecommerce.

A proposta é:

1. Criar um ecommerce extremamente simples
2. Quebrar o sistema propositalmente
3. Estudar os problemas gerados
4. Aplicar soluções reais usadas no mercado

---

# Stack Inicial

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database

---

# Funcionalidades Atuais

## Produto

- Cadastro de produtos
- Controle de estoque

## Pedido

- Criação de pedidos
- Atualização de estoque

## Compra

Endpoint responsável por:

- buscar produto
- verificar estoque
- reduzir estoque
- criar pedido

---

# Endpoint Atual

## Comprar Produto

```http
POST /comprar/{id}
```

Exemplo:

```http
POST /comprar/1
```

---

# Estrutura Atual

```txt
src/main/java/com/lab/commerce
│
├── controller
├── service
├── repository
├── entity
└── dto
```

---

# Fluxo Atual da Compra

```txt
Cliente
   ↓
Busca Produto
   ↓
Verifica Estoque
   ↓
Reduz Estoque
   ↓
Cria Pedido
   ↓
Salva no Banco
```

---

# Objetivo Principal do Laboratório

O sistema inicial foi criado de forma propositalmente simples.

Isso permite estudar problemas reais como:

- race condition
- estoque negativo
- concorrência
- falha de banco
- timeout
- pagamento duplicado
- cache inconsistente
- retry
- filas
- resiliência

---

# Próximos Problemas Planejados

## Concorrência

- estoque negativo
- múltiplas compras simultâneas

## Resiliência

- banco offline
- timeout externo
- retry

## Escalabilidade

- filas
- cache
- Redis
- processamento assíncrono

## Arquitetura

- microsserviços
- mensageria
- observabilidade

---

# Primeiro Cenário de Estudo

## Problema 01 — Estoque Negativo

### Cenário

Duas pessoas compram o último item ao mesmo tempo.

### Objetivo

Estudar:

- concorrência
- race condition
- transações
- locking

---

# Estrutura de Problemas

```txt
/problems
```

Cada problema possuirá:

- descrição
- cenário
- impacto
- solução simples
- solução profissional
- exemplos de código
- melhorias arquiteturais

---

# Objetivo Educacional

Este projeto foi criado para:

- aprendizado backend
- preparação para entrevistas
- estudo de arquitetura
- entendimento de sistemas reais
- documentação de soluções
- evolução técnica gradual

---

# Tecnologias Futuras

Planejadas para evolução do laboratório:

- PostgreSQL
- Redis
- RabbitMQ
- Kafka
- Docker
- Kubernetes
- Grafana
- Prometheus
- Resilience4j

---

# Status do Projeto

🚧 Em desenvolvimento

Fase atual:
- sistema base
- controle simples de estoque
- criação de pedidos

Próxima fase:
- simulação de concorrência
- quebra de estoque
- tratamento de inconsistência