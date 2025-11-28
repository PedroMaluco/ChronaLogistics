INSERT INTO tb_maquinista(nome, idade, soldo, email, senha, role) VALUES ('Krauspenhar', 26, 2750.00, 'kraus@outlook.com', '$2a$10$UDL4BSdgk8lHMxXTqu.Kq.LCZGvfP0ZIQ4nuhkmDAYJlXJ5eqwsV.', 'ROLE_ENGENHEIRO_CHEFE');
INSERT INTO tb_maquinista(nome, idade, soldo, email, senha, role) VALUES ('Da Silva', 36, 4550.00, 'silva@yahoo.com', '$2a$10$hupyLRnVUR53UCCo0AI3ZOCN1teiSDPpULOa1EVNvbpsVsBdv9W.e', 'ROLE_ENGENHEIRO_CHEFE');
INSERT INTO tb_maquinista(nome, idade, soldo, email, senha, role) VALUES ('Severo', 22, 2500.00, 'saveiro@outlook.com', '$2a$10$VLzSHgWMC3fEgoAdAlraruOUT6enbH58sYGZW0m2ZuN5wCUYME40O', 'ROLE_ENGENHEIRO_SUBALTERNO');
INSERT INTO tb_maquinista(nome, idade, soldo, email, senha, role) VALUES ('Padilha', 25, 2850.00, 'padilha@gmail.com', '$2a$10$KXgP85jmD7dnwV.qL5pdtu/bki3DKZb.PAq2MotJlId7HsPxl02AW', 'ROLE_ENGENHEIRO_SUBALTERNO');

INSERT INTO tb_itinerario(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2025-05-07T13:00:00Z', TIMESTAMP WITH TIME ZONE '2025-05-07T18:00:00Z');
INSERT INTO tb_itinerario(inicio, fim) VALUES (TIMESTAMP WITH TIME ZONE '2025-05-09T09:00:00Z', TIMESTAMP WITH TIME ZONE '2025-05-09T15:00:00Z');

INSERT INTO tb_locomotiva(nome, modelo, kilometragem, ano, maquinista_id, itinerario_id) VALUES ('New Dawn', 'Diesel', 70.000, 2002, 1, 1);
INSERT INTO tb_locomotiva(nome, modelo, kilometragem, ano, maquinista_id, itinerario_id) VALUES ('Odyssey', 'Steam-Engine', 130.000, 1998, 3, 2);
INSERT INTO tb_locomotiva(nome, modelo, kilometragem, ano, maquinista_id, itinerario_id) VALUES ('Sun Shine', 'Steam-Engine', 770.000, 1997, 2, null)


INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (2500, 2002, 0, 2);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (3500, 2012, 1, 2);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (4200, 2007, 2, 2);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (5500, 2009, 1, 1);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (4000, 2011, 2, 1);
INSERT INTO tb_vagoes(peso, ano, modelo, locomotiva_id) VALUES (3800, 2020, 0, 1);

INSERT INTO tb_estacao(nome) VALUES ('Cachoeira');
INSERT INTO tb_estacao(nome) VALUES ('Vale Vanádio');

INSERT INTO tb_estacao_itinerario(estacao_id, itinerario_id) VALUES (1, 1);
INSERT INTO tb_estacao_itinerario(estacao_id, itinerario_id) VALUES (2, 2);

INSERT INTO tb_locomotiva_estacao(estacao_id, locomotiva_id) VALUES (1, 2);
INSERT INTO tb_locomotiva_estacao(estacao_id, locomotiva_id) VALUES (2, 1);
