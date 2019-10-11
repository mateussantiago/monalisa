# Monalisa

Uma plataforma de monitoria online.

#### Autores

1. Maria Rayane Alves (mrayalves05@gmail.com)
2. Mateus Santiago (mateus.santiago01@gmail.com)
3. Paulo Augusto (pauloaugusto99@ufrn.edu.br)

#### Tecnologias

1. Java
2. Spring
3. PostgreSQL
4. Thymeleaf

#### Informações gerais

O **Monalisa** é uma plataforma que permite a contribuição e compartilhamento entre alunos universitários sobre assuntos 
vistos em componentes curriculares; permitindo ao aluno tanto **expôr sua dúvida, quanto ajudar a outros alunos na 
resolução de suas dúvidas**.

A proposta do sistema é justamente **permitir que alunos que provém do conhecimento em determinado conteúdo possam ajudar 
outros** que estão estudando-o, seja respondendo dúvidas postadas, compartilhando materiais de estudo ou links para vídeos 
aulas, ou explicando como funciona a didática ou método avaliativo dos professores que ministrou sua turma. 

#### Arquitetura do projeto

A organização da arquitetura do projeto foi pensada em uma arquitetura em camadas com os seguintes componentes:

* `Model`: contém as classes de domínio do projeto mapeadas como entidades no banco de dados;

* `Repository`: interfaces de repositório que manipulam as modificações dos registros das entidades no banco de dados; 

* `Service`: classes que manipulam as regras de negócio do projeto;

* `Controller`: classes de controle que recebe as requisições, enviam para processamento nos services e retornam as 
respectivas respostas.

Os arquivos HTML que compõem o front-end do projeto se encontram na pasta `src/main/resources/templates`.

#### Executando o projeto

Para executar o projeto, primeiramente clone esse repositório em sua máquina.

Posteriormente, abra o repositório na sua IDE de preferência. 
Nós desenvolvedores desse projeto preferimos O **Intellij IDEA**, mas você pode usar a que você achar melhor de acordo 
com sua experiência.

Em seguida, crie um banco de dados Postgres chamado `monalisa` e execute a query de criação das tabelas no schema que se 
encontra em `src/main/resources/database` chamada `monalisa.sql`; e a query de inserção de dados de testes do 
arquivo `inserts.sql`.

Depois, abra o arquivo `application.properties` em `src/main/resources` e configure as variáveis de ambiente de acordo
com as seguintes descrições:

1. `${DATABASE_URL}`: O HOST do seu banco de dados. Por exemplo: localhost ou 127.0.0.1;
2. `${DATABASE_NAME}`: O nome do seu banco de dados. Nesse caso, monalisa, que você criou logo acima.
3. `${DATABASE_USERNAME}`: O usuário do seu banco de dados postgres. 
4. `${DATABASE_PASSWORD}`: A senha do seu banco de dados postgres. 

Caso não você não saiba como configurar varáveis de ambiente na sua IDE, substitua essas linhas para as seguintes 
configurações: 

> `spring.datasource.driver-class-name = org.postgresql.Driver`
>
> `spring.datasource.url= jdbc:postgresql://[Host do seu banco]:5432/monalisa`
>
> `spring.datasource.username=[Usuário do seu banco]`
>
> `spring.datasource.password=[Senha do seu banco]`

Feito isso, execute o arquivo `MonalisaApplication` como um projeto java e pronto!

Acesse o link **localhost:8080**  no seu navegador e aproveite a Monalisa.
