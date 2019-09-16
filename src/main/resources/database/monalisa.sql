------------------------------------------------------------
--DROP SEQUENCE public.seq_id_usuario;
CREATE SEQUENCE public.seq_id_usuario
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Permissions
ALTER SEQUENCE public.seq_id_usuario OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_usuario TO postgres;

-- Drop table
--DROP TABLE public.usuario;
CREATE TABLE public.usuario (
	id_usuario int4 NOT NULL,
	nome varchar(250) NOT NULL,
	login varchar(50) NOT NULL,
	email varchar(250) NOT NULL,
	senha varchar(60) NOT NULL,
	ativo bool NULL DEFAULT true,
	CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);

-- Permissions
ALTER TABLE public.usuario OWNER TO postgres;
GRANT ALL ON TABLE public.usuario TO postgres;

------------------------------------------------------------
--DROP SEQUENCE public.seq_id_tag;
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
--DROP TABLE public.tag;
CREATE TABLE public.tag (
	id_tag int4 NOT NULL,
	nome varchar(250) NULL,
	ativo bool NULL DEFAULT true,
	CONSTRAINT pk_tag PRIMARY KEY (id_tag)
);

-- Permissions
ALTER TABLE public.tag OWNER TO postgres;
GRANT ALL ON TABLE public.tag TO postgres;

------------------------------------------------------------
--DROP SEQUENCE public.seq_id_turma;
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
--DROP TABLE public.turma;
CREATE TABLE public.turma (
	id_turma int4 NOT NULL,
	nome varchar(250) NULL,
	descricao varchar(1000) NULL,
	ativo bool NULL DEFAULT true,
	CONSTRAINT pk_turma PRIMARY KEY (id_turma)
);

-- Permissions
ALTER TABLE public.turma OWNER TO postgres;
GRANT ALL ON TABLE public.turma TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_tag_turma;
CREATE SEQUENCE public.seq_id_tag_turma
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Permissions
ALTER SEQUENCE public.seq_id_tag_turma OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_tag_turma TO postgres;

-- Drop table
-- DROP TABLE public.tag_turma;
CREATE TABLE public.tag_turma (
    id_tag_turma int4 NOT NULL,
    id_tag int4 NOT NULL,
    id_turma int4 NOT NULL,
    ativo bool NULL DEFAULT true,
    CONSTRAINT pk_tag_turma PRIMARY KEY (id_tag_turma)
    CONSTRAINT fk_tag FOREIGN KEY (id_tag) REFERENCES public.tag(id_tag),
    CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES public.turma(id_turma)
);

-- Permissions
ALTER TABLE public.tag_turma OWNER TO postgres;
GRANT ALL ON TABLE public.tag_turma TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_turma_usuario;
CREATE SEQUENCE public.seq_id_turma_usuario
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_turma_usuario OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_turma_usuario TO postgres;

-- Drop table
-- DROP TABLE public.turma_usuario;
CREATE TABLE public.turma_usuario (
    id_turma_usuario int4 NOT NULL,
    id_usuario int4 NOT NULL,
    id_turma int4 NOT NULL,
    data_inicio TIMESTAMP,
    data_fim TIMESTAMP,
    ativo bool NULL DEFAULT true,
    CONSTRAINT pk_turma_usuario PRIMARY KEY (id_turma_usuario),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario (id_usuario),
    CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES public.turma (id_turma)
);

-- Permissions
ALTER TABLE public.turma_usuario OWNER TO postgres;
GRANT ALL ON TABLE public.turma_usuario TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_assunto;
CREATE SEQUENCE public.seq_id_assunto
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_assunto OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_assunto TO postgres;

-- Drop table
-- DROP TABLE public.assunto;
CREATE TABLE public.assunto (
	id_assunto int4 NOT NULL,
	nome varchar(250) NULL,
	descricao varchar(1000) NULL,
	ativo bool NULL DEFAULT true,
	CONSTRAINT pk_assunto PRIMARY KEY (id_assunto)
);

ALTER TABLE public.assunto OWNER TO postgres;
GRANT ALL ON TABLE public.assunto TO postgres;

------------------------------------------------------------
-- DROP SEQUENCE public.seq_id_assunto_turma;
CREATE SEQUENCE public.seq_id_assunto_turma
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999999999999999
	CACHE 1
	NO CYCLE;

-- Permissions
ALTER SEQUENCE public.seq_id_assunto_turma OWNER TO postgres;
GRANT ALL ON SEQUENCE public.seq_id_assunto_turma TO postgres;

-- Drop table
-- DROP TABLE public.assunto_turma;
CREATE TABLE public.assunto_turma (
	id_assunto_turma int4 not null,
    id_assunto int4 NOT NULL,
    id_turma int4 NOT NULL,
    ativo bool NULL DEFAULT true,
    CONSTRAINT pk_assunto_turma PRIMARY KEY (id_assunto_turma),
    CONSTRAINT fk_assunto FOREIGN KEY (id_assunto) REFERENCES public.assunto(id_assunto),
    CONSTRAINT fk_turma FOREIGN KEY (id_turma) REFERENCES public.turma(id_turma)
);

-- Permissions
ALTER TABLE public.assunto_turma OWNER TO postgres;
GRANT ALL ON TABLE public.assunto_turma TO postgres;

------------------------------------------------------------
--DROP SEQUENCE public.seq_id_postagem;
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
--DROP TABLE public.postagem;
CREATE TABLE public.postagem (
	id_postagem int4 NOT NULL,
	ativo bool NOT NULL DEFAULT true,
	conteudo varchar(5000) NOT NULL,
	avaliacao_positiva int4 NULL DEFAULT 0,
	avaliacao_negativa int4 NULL DEFAULT 0,
	id_postagem_genitora int4 NULL,
	id_assunto_turma int4 NULL,
	CONSTRAINT pk_postagem PRIMARY KEY (id_postagem),
	CONSTRAINT fk_postagem FOREIGN KEY (id_postagem_genitora) REFERENCES public.postagem (id_postagem),
    CONSTRAINT fk_assunto_turma FOREIGN KEY (id_assunto_turma) REFERENCES public.assunto_turma (id_assunto_turma)
);