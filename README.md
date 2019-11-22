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
