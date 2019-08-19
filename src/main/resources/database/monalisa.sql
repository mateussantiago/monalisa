CREATE SEQUENCE public.seq_id_usuario
   INCREMENT 1
   START 1
   MINVALUE 1
   MAXVALUE 999999999999999999;

-- Drop table
-- DROP TABLE public.usuario;
CREATE TABLE public.usuario (
	id_usuario serial NOT NULL,
	nome varchar(250) NOT NULL,
	login varchar(50) NOT NULL,
	email varchar(250) NOT NULL,
	senha varchar(256) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),
	CONSTRAINT usuario_email_key UNIQUE (email),
	CONSTRAINT usuario_usuario_key UNIQUE (login)
);
-- Permissions
ALTER TABLE public.usuario OWNER TO postgres;
GRANT ALL ON TABLE public.usuario TO postgres;
-- Add sequence
ALTER TABLE usuario ALTER COLUMN id_usuario SET DEFAULT NEXTVAL('seq_id_usuario');
