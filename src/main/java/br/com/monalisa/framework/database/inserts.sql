INSERT INTO public.conteudo (id_conteudo, nome, descricao, ativo) VALUES
(1, 'Friends', 'Seis amigos, três homens e três mulheres, enfrentam a vida e os amores em Nova York e adoram passar o tempo livre na cafeteria Central Perk.', true),
(2, 'Breaking Bad', 'O professor de química Walter White não acredita que sua vida possa piorar ainda mais. Quando descobre que tem câncer terminal, Walter decide arriscar tudo para ganhar dinheiro enquanto pode, transformando sua van em um laboratório de metanfetamina.', true),
(3, 'How i met your mother', 'No ano de 2030, Ted Mosby, um arquiteto, decide explicar a seus filhos a história de como ele conheceu a mãe deles. Tudo começou em 2005, quando um de seus amigos decidiu se casar e Ted precisou correr atrás de um amor.', true),
(4, 'Game of Thrones', 'Famílias nobres e poderosas disputam um jogo mortal pelo controle dos Sete Reinos de Westeros para assumir o Trono de Ferro.', true),
(5, 'Mr. Robot', 'Elliot é um jovem programador que trabalha como engenheiro de segurança virtual durante o dia, e como hacker vigilante durante a noite. Elliot se vê em uma encruzilhada quando é recrutado para destruir a firma que ele é pago para proteger.', true);
ALTER SEQUENCE seq_id_conteudo RESTART WITH 6;

