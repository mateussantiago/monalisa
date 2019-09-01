-- DROP SEQUENCE public.seq_id_usuario;
CREATE SEQUENCE public.seq_id_usuario
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Permissions
ALTER SEQUENCE public.seq_id_usuario OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_usuario TO postgres;

-- Drop table
-- DROP TABLE public.usuario;
CREATE TABLE public.usuario (
	id_usuario int4 NOT NULL,
	nome varchar(250) NOT NULL,
	login varchar(50) NOT NULL,
	email varchar(250) NOT NULL,
	senha varchar(60) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
);

-- Permissions
ALTER TABLE public.usuario OWNER TO postgres;
GRANT ALL ON TABLE public.usuario TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_tag;
CREATE SEQUENCE public.seq_id_tag
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_tag OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_tag TO postgres;

-- Drop table
-- DROP TABLE public.tag;
CREATE TABLE public.tag (
	id_tag int4 NOT NULL,
	nome varchar(250) NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_tag PRIMARY KEY (id_tag),
);

-- Permissions
ALTER TABLE public.tag OWNER TO postgres;
GRANT ALL ON TABLE public.tag TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_turma;
CREATE SEQUENCE public.seq_id_turma
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_turma OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_turma TO postgres;

-- Drop table
-- DROP TABLE public.turma;
CREATE TABLE public.turma (
	id_turma int4 NOT NULL,
	nome varchar(250) NULL,
	descricao varchar(1000) NULL,
	ativo bool NOT NULL DEFAULT true,
	CONSTRAINT pk_turma PRIMARY KEY (id_turma)
);

-- Permissions
ALTER TABLE public.turma OWNER TO postgres;
GRANT ALL ON TABLE public.turma TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_postagem;
CREATE SEQUENCE public.seq_id_postagem
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_postagem OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_postagem TO postgres;

-- Drop table
-- DROP TABLE public.postagem;
CREATE TABLE public.postagem (
	id_postagem int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	texto varchar(5000) NULL,
	avaliacao_positiva int4 NULL,
	avaliacao_negativa int4 NULL,
	CONSTRAINT pk_postagem PRIMARY KEY (id_postagem)
);

-- Permissions
ALTER TABLE public.postagem OWNER TO postgres;
GRANT ALL ON TABLE public.postagem TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_tagturma;
CREATE SEQUENCE public.seq_id_tagturma
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_tagturma OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_tagturma TO postgres;

-- Drop table
-- DROP TABLE public.tagturma;
CREATE TABLE public.tagturma(
    id_tagturma int4 NOT NULL,
    id_tag int4 NOT NULL,
    id_turma int4 NOT NULL,
    ativo bool NOT NULL,

    CONSTRAINT fk_tag FOREIGN KEY (id_tag)
    REFERENCES public.tag(id_tag),

    CONSTRAINT fk_turma FOREIGN KEY (id_turma)
    REFERENCES public.turma(id_turma),

    CONSTRAINT pk_tagturma PRIMARY KEY (id_tagturma)
);

-- Permissions
ALTER TABLE public.tagturma OWNER TO postgres;
GRANT ALL ON TABLE public.tagturma TO postgres;