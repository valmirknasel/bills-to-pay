# Sobre o Projeto

O presente projeto tem por objetivo o desenvolvimento de uma API para um sistema de controle de contas 
a pagar. 

São abordados no projeto o uso do Spring Security + Keycloak + OAuth2 para a concessão de autenticação 
e autorização, respectivamente.  

A branch "<b>bills-to-pay-dev</b>" é utilizada para o desenvolvimento das funcionalidades enquanto que a 
branch "<b>master</b>" representa a versão estável do sistema! Cada feature deve ser desenvolvida em uma 
nova branch e ao final do desenvolvimento, deve ser criado o merge request para implementar a feature
na branch "<b>master</b>". 

Cada nova necessidade de funcionalidade ou correção deverá ser cadastrada como uma nova Issue do projeto.

## Etapas para Execução do Projeto

1. Criar o banco <b>billstopay</b> ou outro nome qualquer e renomear a propriedade customizada <b>app.datasource.db</b>
   no arquivo <b>application-dev.yml</b> para corresponder com o nome do banco criado;

2. Configurar o <b>Host</b> e a <b>Porta</b> do Keycloak no arquivo application-dev.yml;

### 3. CONFIGURAÇÕES NO KEYCLOAK:

3.1 Criar o <b>Realm</b> no Keycloak e ajustar a propriedade <b>app.keycloak.realm</b> no arquivo
<b>applicaion-dev.yml</b> para corresponder com o Realm criado;

3.2 Criar o <b>Client</b> no Realm criado na etapa anterior. O "Client" representa uma aplicação cliente (Front End) que 
irá acessar a API informando o respectivo <b>Client Id</b> e <b>Client Secret</b> para obter o JWT Bearer Token;

3.3 Criar as <b>Roles</b> ("ADMIN", "BASIC_USER", "READ_ONLY", etc) no respectivo Client, Aba Roles, de modo a corresponder 
com o mapeamento de permissões da classe <b>SecurityConfig.java</b>;

3.4 Criar um <b>Mapper</b> no Client criado na etapa 3.2 e atribuir um nome qualquer a ele, alterando a propriedade 
"Token Claim Name = roles";

3.5 Criar os respectivos <b>Usuários</b> do Realm criado na etapa 3.1 e vincular as Roles aos respectivos usuários.

## TESTANDO A API NO POSTMAN

1. No Postman, é necessário informar, na Aba <b>Authorization</b>, o "Type" como "OAuth 2.0" e o "Grant Type" como
   "Password Credentials". Isso indica que o usuário vai autenticar no Keycloak com usuário e senha para
   poder pegar o token JWT;

2. Ainda na Aba Authorizatrion, informar o "Access Token URL" com o endereço do keycloak no formato
   "http://<b> nome-do-host-do-keycloak</b>:<b>porta</b>/auth/realms/<b>nome-do-realm</b>/protocol/openid-connect/token";

3. Ainda na mesma aba, informar o <b>Client Id</b> e o <b>Client Secret</b>, obtidos no Client do Keycloak,
   criado na etapa 3.2 do item "<b>ETAPAS PARA EXECUÇÃO DO PROJETO</b>", para poder obter o token JWT;

4. Informar o <b>Username</b> e <b>Password</b> de um dos usuários criados no Realm do Keycloak criado na etapa 3.1 do item
   "<b>ETAPAS PARA EXECUÇÃO DO PROJETO</b>" e que possua as respectivas Roles configuradas na etapa 3.3;

5. Realizar as requisições para a API com as informações de autenticação e testar a autorização do OAuth2 passada no token JWT.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web.security.oauth2.server)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#actuator)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web.security)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

