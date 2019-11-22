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