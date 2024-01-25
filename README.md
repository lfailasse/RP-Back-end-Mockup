## Visão Geral

O RP-Back-end-Mockup é uma aplicação de back-end baseada em Java, desenvolvida como o componente de back-end de um projeto em duas partes. Esta aplicação gerencia as operações de back-end, incluindo a lógica de negócios, manipulação de dados e integração com banco de dados. Ela está configurada para interagir com o repositório RP-Front-end-Mockup, que representa o componente de front-end do projeto, responsável pela interface do usuário e interações com o cliente. O RP-Back-end-Mockup fornece as APIs e endpoints necessários para que o front-end possa requisitar e exibir dados de maneira eficiente e segura.

## Utilização

- Para funcionamento devido da API, em "application.properties", informe os atributos de conexão do banco de dados utilizado renomeando as informações abaixo:
   ```bash
      spring.datasource.url=jdbc:postgresql://url:port/dbname
      spring.datasource.username=username
      spring.datasource.password=password
   ```

<br>
   
- Para acesso aos endpoints é necessário um token JWT nas requisições, utilizando o seguinte endpoint com as informações "username" e "password", a resposta deverá conter: O nome de usuário, cargo e um token para utilização

   >http://url:8080/user/login

  ```bash
     body: {
              "username": "login"
              "password": "senha"
           }


  
     response: {
                   "token": "JWT.Token",
                   "name": "Username",
                   "role": "Role"
               }
  ```

<br>

- Ao receber o token, é possível utilizar quaisquer outros endpoints (Variando conforme o cargo).
  Informe o token utilizando o padrão Bearer para visualização dos mesmos

<br>

A aplicação possui Dockerfile integrado com as configurações necessárias para deploy em imagem, utilizando multistage

- Com o docker devidamente instalado, utilize:
   ```bash
   docker build -t nome-da-imagem .
