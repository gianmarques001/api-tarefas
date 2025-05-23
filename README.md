
# 📋 Task API: Gerenciamento de Tarefas e Subtarefas

Bem-vindo ao **Task API**, um projeto pessoal desenvolvido com **Spring Boot** para criar uma API RESTful robusta e intuitiva, focada no gerenciamento de tarefas e subtarefas. 
Este projeto foi utilizando **MongoDB** como banco de dados e padrões de projeto como **Composite** e **Command** para garantir uma arquitetura escalável e manutenível. Ele reflete minhas habilidades em desenvolvimento backend, design de APIs e aprendizado contínuo.


## 🚀 Tecnologias Utilizadas

Este projeto utiliza um stack moderno e amplamente adotado no mercado:

- **Java 17**: Linguagem principal, aproveitando recursos modernos como records.
- **Spring Boot 3.4**: Framework para criação de APIs RESTful com configuração simplificada.
  - **Spring Data MongoDB**: Integração com MongoDB para manipulação de dados.
  - **Bean Validation**: Validação robusta de entradas para dados consistentes.
  - **Lombok**: Redução de boilerplate code, aumentando a produtividade.
- **MongoDB**: Banco NoSQL para armazenamento flexível de tarefas e subtarefas.
- **Maven**: Gerenciamento de dependências e build do projeto.

---

## 🧩 Padrões de Projeto Aplicados

Para garantir uma arquitetura robusta e escalável, foram utilizados os seguintes padrões de projeto:

- **Composite**:
  - **Propósito**: Representar tarefas e subtarefas de forma hierárquica, permitindo que ambas sejam tratadas de maneira uniforme.
  - **Implementação**: Tarefas e subtarefas são modeladas como componentes de uma estrutura em árvore, facilitando operações como adição, remoção e atualização em qualquer nível da hierarquia.
  - **Aprendizado**: O padrão Composite me ensinou a projetar sistemas flexíveis para estruturas complexas, mantendo a consistência no tratamento de objetos compostos e individuais.

- **Command**:
  - **Propósito**: Encapsular operações como criação, atualização e exclusão de tarefas/subtarefas como objetos distintos.
  - **Implementação**: Cada operação (ex.: criar tarefa, excluir subtarefa) é representada por um comando, promovendo desacoplamento e facilitando a extensibilidade.
  - **Aprendizado**: O padrão Command me ajudou a entender como isolar a lógica de negócios, tornando o código mais modular e fácil de testar.

---

## 💾 Escolha do MongoDB

O **MongoDB** foi escolhido como banco de dados por suas vantagens específicas para este caso:

- **Armazenamento Hierárquico**: Tarefas e subtarefas são armazenadas como documentos aninhados, refletindo naturalmente a estrutura hierárquica do projeto.

- **Consultas Eficientes**: Suporta consultas e atualizações em estruturas aninhadas, otimizando operações como recuperar ou modificar subtarefas.

**Aprendizado com MongoDB**: Trabalhar com um banco NoSQL me ensinou a modelar dados de forma flexível, aproveitando a ausência de esquemas rígidos para acelerar o desenvolvimento e adaptação do projeto.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- **Java 21** instalado (JDK).
- **MongoDB** rodando localmente ou via Docker.
- Ferramenta para testes de API, como **Postman** ou **Insomnia**.

### Passos para Configuração

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/gianmarques001/api-tarefas.git
   ```

2. **Navegue até o diretório do projeto**:
   ```bash
   cd api-tarefas
   ```

3. **Execute o projeto**:
   - Abra o projeto em sua IDE favorita (ex.: IntelliJ, Eclipse).
   - Execute a classe principal `TarefasApiApplication.java`.

4. **Acesse a API**:
   - A API estará disponível em: [http://localhost:8080](http://localhost:8080).
   - Utilize ferramentas como Postman ou Insomnia para testar os attorney.

---

## 📍 Endpoints Principais

A API oferece endpoints claros e bem estruturados para gerenciar tarefas e subtarefas. Abaixo estão alguns exemplos:

| Método | Endpoint                                     | Descrição                              |
|--------|----------------------------------------------|----------------------------------------|
| `GET`  | `/api/v1/tarefas`                           | Lista todas as tarefas.                |
| `GET`  | `/api/v1/tarefas/{idTarefa}`                | Recupera uma tarefa por ID.            |
| `POST` | `/api/v1/tarefas`                           | Cria uma nova tarefa.                  |
| `PATCH`| `/api/v1/tarefas/{idTarefa}`                | Atualiza uma tarefa existente.         |
| `DELETE`| `/api/v1/tarefas/{idTarefa}`               | Remove uma tarefa.                     |
| `PATCH`| `/api/v1/tarefas/{idTarefa}/{idSubTarefa}` | Atualiza uma subtarefa de uma tarefa.  |
| `DELETE`| `/api/v1/tarefas/{idTarefa}/{idSubTarefa}`| Remove uma subtarefa de uma tarefa.    |


### Exemplo de Requisição (POST)
```json
POST /api/v1/tarefas
{
  "titulo": "Planejar evento",
  "subtarefas": [
    {
      "descricao": "Reservar local",
      "concluida": false
    }
  ]
}
```

---

## 🌟 Por que este projeto é especial?

- **Arquitetura bem planejada**: Utiliza padrões de projeto (Composite e Command) para criar um sistema modular e escalável.
- **Código limpo**: Segue boas práticas, como injeção de dependências e separação de camadas.
- **Aprendizado prático**: Reflete minha capacidade de aprender e aplicar conceitos avançados, como padrões de projeto e bancos NoSQL.
---

## 📬 Contribuições e Feedback

Este projeto foi criado com foco em aprendizado e prática. Fico feliz em receber sugestões, críticas ou ideias para melhorias!

---

## 📜 Licença

Distribuído sob a licença **MIT**. Veja mais detalhes em [LICENSE](https://choosealicense.com/licenses/mit/).

---


