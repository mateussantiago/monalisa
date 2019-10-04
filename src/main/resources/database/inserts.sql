INSERT INTO public.turma (id_turma, nome, descricao, ativo) VALUES 
(1, 'Cálculo 1', 'Disciplina de cálculo 1', true),
(2, 'Probabilidade', 'Disciplina de probabilidade', true),
(3, 'Fundamentos matemáticos para a computação 1', 'Disciplina de FMC1', true),
(4, 'Gramática 1', 'Disciplina que ensina a escrever', true),
(5, 'Cálculo 2', 'Disciplina de Cálculo 2', true),
(6, 'Psicologia aplicada', 'Disciplina de psicologia', true);
ALTER SEQUENCE seq_id_turma RESTART WITH 7;

INSERT INTO public.assunto(id_assunto, nome, descricao, ativo) VALUES 
(1, 'Limites', 'Limites', true),
(2, 'Derivadas', 'Derivadas', true),
(3, 'Psicanálise', 'Psicanálise', true),
(4, 'Conjuntos', 'Conjuntos', true),
(5, 'Integrais múltiplas', 'Integrais múltiplas', true),
(6, 'Ciência de Dados', 'Introdução ao estudo de ciência de dados', true);
ALTER SEQUENCE seq_id_assunto RESTART WITH 7;

INSERT INTO public.assunto_turma(id_assunto_turma, id_assunto, id_turma, ativo) VALUES 
(1, 1, 1, true),
(2, 1, 2, true),
(3, 5, 5, true),
(4, 5, 3, true),
(5, 2, 4, true),
(6, 2, 1, true),
(7, 5, 1, true),
(9, 4, 3, true);
ALTER SEQUENCE seq_id_assunto_turma RESTART WITH 10;

INSERT INTO public.tag(id_tag, nome, ativo) VALUES 
(1, 'Matemática elementar 1', true),
(2, 'Matemática elementar 2', true),
(3, 'Matemática discreta', true);
ALTER SEQUENCE seq_id_tag RESTART WITH 4;

INSERT INTO public.tag_turma(id_tag_turma, id_tag, id_turma, ativo) VALUES 
(1, 1, 1, true),
(2, 2, 5, true),
(3, 3, 3, true);
ALTER SEQUENCE seq_id_tag_turma RESTART WITH 4;