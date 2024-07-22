# Bus Card Manager

## Descrição

O projeto Bus Card Manager é uma aplicação completa que permite o gerenciamento de usuários e seus cartões de ônibus. O sistema permite o cadastro de usuários, adição de cartões aos usuários, e a gestão desses cartões, incluindo a ativação e desativação. A aplicação é composta por um backend desenvolvido em Java com Spring Boot e um frontend desenvolvido em Angular.

## Backend

### Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.1
- JPA/Hibernate
- PostgreSQL
- Maven

### Funcionalidades

- Cadastro de Usuários
- Consulta de Usuários
- Alteração de Usuários
- Remoção de Usuários
- Adição e Remoção de Cartões aos Usuários
- Consulta de Cartões
- Ativação/Inativação de Cartões

### Instruções para Executar

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/bus-card-manager.git
    ```
2. Navegue até o diretório do backend:
    ```bash
    cd bus-card-manager/backend
    ```
3. Configure o banco de dados PostgreSQL no `application.properties`.
4. Execute o projeto:
    ```bash
    mvn spring-boot:run
    ```

### Endpoints

- `GET /api/users/get`: Lista todos os usuários
- `GET /api/users/get/{userId}`: Obtém os detalhes de um usuário específico
- `POST /api/users/add`: Adiciona um novo usuário
- `PUT /api/users/update`: Atualiza um usuário existente
- `DELETE /api/users/delete/{userId}`: Remove um usuário
- `POST /api/users/{userId}/cards/add`: Adiciona um cartão a um usuário
- `DELETE /api/users/{userId}/cards/remove/{cardId}`: Remove um cartão de um usuário
- `GET /api/users/{userId}/cards/get`: Lista todos os cartões de um usuário
- `POST /api/users/{userId}/cards/status/{cardId}`: Ativa/Inativa um cartão

## Frontend

### Tecnologias Utilizadas

- Angular 16
- Angular Material 16.2.14
- Ng Icons

### Funcionalidades

- Visualização de Usuários
- Adição de Usuários
- Remoção de Usuários
- Gerenciamento de Cartões dos Usuários

### Instruções para Executar

1. Navegue até o diretório do frontend:
    ```bash
    cd bus-card-manager/frontend
    ```
2. Instale as dependências:
    ```bash
    npm install
    ```
3. Execute o projeto:
    ```bash
    ng serve
    ```
4. Acesse a aplicação em `http://localhost:4200`.