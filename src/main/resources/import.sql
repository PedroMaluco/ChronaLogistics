INSERT INTO tb_maquinista(nome, idade, soldo, email, senha) VALUES ('Krauspenhar', 26, 2750.00, 'kraus@outlook.com', 'Alpha');
INSERT INTO tb_maquinista(nome, idade, soldo, email, senha) VALUES ('Da Silva', 36, 4550.00, 'silva@yahoo.com', 'Bravo');
INSERT INTO tb_maquinista(nome, idade, soldo, email, senha) VALUES ('Severo', 22, 2500.00, 'saveiro@outlook.com', 'Charlie');
INSERT INTO tb_maquinista(nome, idade, soldo, email, senha) VALUES ('Padilha', 25, 2850.00, 'padilha@gmail.com', 'Delta');

INSERT INTO tb_role(authority) VALUES ('Engenheiro-chefe');
INSERT INTO tb_role(authority) VALUES ('Administrador');
INSERT INTO tb_role(authority) VALUES ('Operador');

INSERT INTO tb_maquinista_role(maquinista_id, role_id) VALUES (1, 2);
INSERT INTO tb_maquinista_role(maquinista_id, role_id) VALUES (1, 3);
INSERT INTO tb_maquinista_role(maquinista_id, role_id) VALUES (2, 1);
INSERT INTO tb_maquinista_role(maquinista_id, role_id) VALUES (2, 2);
INSERT INTO tb_maquinista_role(maquinista_id, role_id) VALUES (3, 3);
INSERT INTO tb_maquinista_role(maquinista_id, role_id) VALUES (4, 3);

INSERT INTO tb_itinerario(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2025-05-07T13:00:00Z', TIMESTAMP WITH TIME ZONE '2025-05-07T18:00:00Z');
INSERT INTO tb_itinerario(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2025-05-09T09:00:00Z', TIMESTAMP WITH TIME ZONE '2025-05-09T15:00:00Z');

INSERT INTO tb_locomotiva(nome, modelo, kilometragem, ano, maquinista_id, itinerario_id) VALUES ('New Dawn', 'Diesel', 70.000, 2002, 1, 1);
INSERT INTO tb_locomotiva(nome, modelo, kilometragem, ano, maquinista_id, itinerario_id) VALUES ('Odyssey', 'Steam-Engine', 130.000, 1998, 3, 2);
INSERT INTO tb_locomotiva(nome, modelo, kilometragem, ano, maquinista_id, itinerario_id) VALUES ('Sun Shine', 'Steam-Engine', 770.000, 1997, 2, null)


INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (2500, 2002, 1, 2);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (3500, 2012, 1, 2);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (4200, 2007, 0, 2);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (5500, 2009, 1, 1);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (4000, 2011, 0, 1);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (3800, 2020, 0, 1);

INSERT INTO tb_estacao(nome) VALUES ('Cachoeira');
INSERT INTO tb_estacao(nome) VALUES ('Vale Vanádio');

INSERT INTO tb_estacao_itinerario(estacao_id, itinerario_id) VALUES (1, 1);
INSERT INTO tb_estacao_itinerario(estacao_id, itinerario_id) VALUES (2, 2);

INSERT INTO tb_locomotiva_estacao(estacao_id, locomotiva_id) VALUES (1, 2);
INSERT INTO tb_locomotiva_estacao(estacao_id, locomotiva_id) VALUES (2, 1);
