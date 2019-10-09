------------------------------------------------------------
--DROP SEQUENCE public.seq_id_usuario;
CREATE SEQUENCE public.seq_id_usuario
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Drop table
--DROP TABLE public.usuario;
CREATE TABLE public.usuario (
	id_usuario int4 NOT NULL,
	nome varchar(250) NOT NULL,
	login varchar(50) NOT NULL,
	email varchar(250) NOT NULL,
	senha varchar(60) NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);

------------------------------------------------------------
--DROP SEQUENCE public.seq_id_tag;
CREATE SEQUENCE public.seq_id_tag
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
--DROP TABLE public.tag;
CREATE TABLE public.tag (
	id_tag int4 NOT NULL,
	nome varchar(250) NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_tag PRIMARY KEY (id_tag)
);

------------------------------------------------------------
--DROP SEQUENCE public.seq_id_turma;
CREATE SEQUENCE public.seq_id_turma
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
--DROP TABLE public.turma;
CREATE TABLE public.turma (
	id_turma int4 NOT NULL,
	nome varchar(250) NOT NULL,
	descricao varchar(1024) NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_turma PRIMARY KEY (id_turma)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_tag_turma;
CREATE SEQUENCE public.seq_id_tag_turma
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Drop table
-- DROP TABLE public.tag_turma;
CREATE TABLE public.tag_turma (
	id_tag_turma int4 NOT NULL,
	id_tag int4 NOT NULL,
	id_turma int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_tagturma PRIMARY KEY (id_tag_turma),
	CONSTRAINT fk_tag FOREIGN KEY (id_tag) REFERENCES tag(id_tag),
	CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
);


------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_turma_usuario;
CREATE SEQUENCE public.seq_id_turma_usuario
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
-- DROP TABLE public.turma_usuario;
CREATE TABLE public.turma_usuario (
	id_turma_usuario int4 NOT NULL,
	id_turma int4 NOT NULL,
	id_usuario int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_turma_usuario PRIMARY KEY (id_turma_usuario, id_turma, id_usuario),
	CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_assunto;
CREATE SEQUENCE public.seq_id_assunto
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
-- DROP TABLE public.assunto;
CREATE TABLE public.assunto (
	id_assunto int4 NOT NULL,
	nome varchar(250) NOT NULL,
	descricao varchar(1000) NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_assunto PRIMARY KEY (id_assunto)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_assunto_turma;
CREATE SEQUENCE public.seq_id_assunto_turma
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
-- DROP TABLE public.assunto_turma;
CREATE TABLE public.assunto_turma (
	id_assunto_turma int4 NOT NULL,
	id_assunto int4 NOT NULL,
	id_turma int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_assunto_turma PRIMARY KEY (id_assunto_turma),
	CONSTRAINT fk_assunto FOREIGN KEY (id_assunto) REFERENCES assunto(id_assunto),
	CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES turma(id_turma)
);

------------------------------------------------------------
--DROP SEQUENCE public.seq_id_postagem;
CREATE SEQUENCE public.seq_id_postagem
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
--DROP TABLE public.postagem;
CREATE TABLE public.postagem (
	id_postagem int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	conteudo varchar(5000) NOT NULL,
	curtidas_positivas int4 NULL DEFAULT 0,
	curtidas_negativas int4 NULL DEFAULT 0,
	id_postagem_genitora int4 NULL,
	id_assunto_turma int4 NOT NULL,
	id_usuario_autor int4 NOT NULL,
	CONSTRAINT pk_postagem PRIMARY KEY (id_postagem),
	CONSTRAINT fk_postagem FOREIGN KEY (id_postagem_genitora) REFERENCES public.postagem (id_postagem),
    CONSTRAINT fk_assunto_turma FOREIGN KEY (id_assunto_turma) REFERENCES public.assunto_turma (id_assunto_turma),
    CONSTRAINT fk_usuario_autor FOREIGN KEY (id_usuario_autor) REFERENCES public.usuario (id_usuario)
);