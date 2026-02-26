# 🎓 Sistema de Gestão de Vagas de Estágio

> Aplicação Full Stack para gerenciamento de empresas, estudantes, vagas e inscrições de estágio.

## 📖 Sobre o Projeto
Este sistema permite a conexão entre empresas que ofertam vagas e estudantes interessados. O projeto foi desenvolvido com uma arquitetura **REST API** no backend e uma interface web responsiva no frontend.

O sistema gerencia relacionamentos complexos, como áreas de interesse mútuas entre vagas e estudantes, e permite o fluxo completo de inscrição.

## 🚀 Tecnologias Utilizadas

### Backend (API)
* **Java 21**
* **Spring Boot 3.5.7**
* **Spring Data JPA**
* **H2 Database** (Banco de dados em arquivo/memória)
* **Maven**

### Frontend (Web)
* **HTML5 & CSS3** (Design responsivo e Tema Escuro)
* **JavaScript (Vanilla)** (Manipulação de DOM e consumo de API via Fetch)

## ✨ Funcionalidades

* **CRUD Completo:** Gerenciamento de Empresas, Estudantes e Vagas.
* **Sistema de Inscrição:** Vincula um estudante a uma vaga com status e mensagem de apresentação.
* **Relacionamentos:** * Empresas possuem múltiplas vagas.
    * Vagas e Estudantes possuem áreas de interesse (Many-to-Many).
* **Interface Dinâmica:** O frontend é uma SPA (Single Page Application) simples, navegando entre abas sem recarregar a página.
