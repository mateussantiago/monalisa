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
--DROP SEQUENCE public.seq_id_conteudo;
CREATE SEQUENCE public.seq_id_conteudo
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
--DROP TABLE public.conteudo;
CREATE TABLE public.conteudo (
	id_conteudo int4 NOT NULL,
	nome varchar(250) NOT NULL,
	descricao varchar(1024) NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_conteudo PRIMARY KEY (id_conteudo)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_topico;
CREATE SEQUENCE public.seq_id_topico
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;


-- Drop table
-- DROP TABLE public.topico;
CREATE TABLE public.topico (
	id_topico int4 NOT NULL,
	nome varchar(250) NOT NULL,
	descricao varchar(1000) NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	id_conteudo int4 NOT NULL,
	CONSTRAINT pk_topico PRIMARY KEY (id_topico),
	CONSTRAINT fk_topico FOREIGN KEY (id_conteudo) REFERENCES conteudo(id_conteudo)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_postagem;
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
	texto varchar(5000) NOT NULL,
	curtidas_positivas int4 NULL DEFAULT 0,
	curtidas_negativas int4 NULL DEFAULT 0,
	id_postagem_genitora int4 NULL,
	id_topico int4 NOT NULL,
	id_usuario_autor int4 NOT NULL,
	CONSTRAINT pk_postagem PRIMARY KEY (id_postagem),
	CONSTRAINT fk_postagem FOREIGN KEY (id_postagem_genitora) REFERENCES public.postagem (id_postagem),
    CONSTRAINT fk_topico FOREIGN KEY (id_topico) REFERENCES public.topico (id_topico),
    CONSTRAINT fk_usuario_autor FOREIGN KEY (id_usuario_autor) REFERENCES public.usuario (id_usuario)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_conteudo_usuario;
CREATE SEQUENCE public.seq_id_conteudo_usuario
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
-- DROP TABLE public.conteudo_usuario;
CREATE TABLE public.conteudo_usuario (
	id_conteudo_usuario int4 NOT NULL,
	id_conteudo int4 NOT NULL,
	id_usuario int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_conteudo_usuario PRIMARY KEY (id_conteudo_usuario, id_conteudo, id_usuario),
	CONSTRAINT unique_conteudo_usuario UNIQUE (id_conteudo, id_usuario),
	CONSTRAINT fk_conteudo FOREIGN KEY (id_conteudo) REFERENCES conteudo(id_conteudo),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_denuncia;
CREATE SEQUENCE public.seq_id_denuncia
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Drop table
-- DROP TABLE public.denuncia;
CREATE TABLE public.denuncia (
	id_denuncia int4 NOT NULL,
	tipo_denuncia varchar(250) NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	processada bool NOT NULL DEFAULT false,
	id_usuario_autor int4 NOT NULL,
	id_postagem int4 NOT NULL,
	CONSTRAINT pk_denuncia PRIMARY KEY (id_denuncia),
	CONSTRAINT fk_usuario FOREIGN KEY (id_usuario_autor) REFERENCES usuario(id_usuario),
	CONSTRAINT fk_postagem FOREIGN KEY (id_postagem) REFERENCES postagem(id_postagem)
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
-- DROP SEQUENCE public.seq_id_tag_turma;
CREATE SEQUENCE public.seq_id_conteudo_tag
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Drop table
-- DROP TABLE public.conteudo_tag;
CREATE TABLE public.conteudo_tag (
	id_conteudo_tag int4 NOT NULL,
	id_tag int4 NOT NULL,
	id_conteudo int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_conteudotag PRIMARY KEY (id_conteudo_tag),
	CONSTRAINT fk_tag FOREIGN KEY (id_tag) REFERENCES tag(id_tag),
	CONSTRAINT fk_conteudo FOREIGN KEY (id_conteudo) REFERENCES conteudo(id_conteudo)
);