INSERT INTO tb_author (name, email, description, created_at) VALUES ('Armando', 'armando@gmail.com', 'eefefefeewf554we46f54e6w4f654ew65f465ew4f65e4w65f465ew4f56e4wf654ew65f456ew4f65e4w65f4ew564f65ew465f46e5w4f65we4f654we65f456ew4f564ew56f4ew56ewfwefewf4f56ew4f564ew5f64ew56f45e6w4f56e4w5f64ew56f456ew4f5564ew65ew4ew4f56ew4f564ew56f4ew564f56ew4f56ew4f564ew65f46e4w5f64ew56f456ew4f56ew4f56e4w5f64ew56f456ew4f56e4w5f64e5w64f56564e56f465we4f564we56f456w4ef564we56f4w5e64f56we4f56ew4f6ewfewfwefewfew54ef', '2021-03-29T15:00:59.530242-03:00');
INSERT INTO tb_author (name, email, description, created_at) VALUES ('Homero', 'classicos@gmail.com', 'bla bla bla bla bla bla bla bla bla bla bla bla', '2021-03-29T15:00:59.530242-03:00');

INSERT INTO tb_category (name) VALUES ('Poesia Épica');
INSERT INTO tb_category (name) VALUES ('Programação');

INSERT INTO tb_book (title, summary, index, price, pages, isbn, publish_date, category_id, author_id) VALUES ('Ilíada', 'Considerada como a "obra fundadora" da literatura ocidental e uma das mais importantes da literatura mundial. Tornou-se, juntamente com a Odisseia (atribuída ao mesmo autor), modelo da poesia épica, seguido pelos autores clássicos, como Virgílio, no poema Eneida, dentre outros.', '## Ilíada', 20, 698, 'FR78G4Y1G', '2021-03-30', 2, 2);
INSERT INTO tb_book (title, summary, index, price, pages, isbn, publish_date, category_id, author_id) VALUES ('Odisseia', 'Considerada como a "obra fundadora" da literatura ocidental e uma das mais importantes da literatura mundial. Tornou-se, juntamente com a Odisseia (atribuída ao mesmo autor), modelo da poesia épica, seguido pelos autores clássicos, como Virgílio, no poema Eneida, dentre outros.', '## Odisseia', 20, 698, 'FR78G5Y1G', '2021-03-30', 2, 2);
INSERT INTO tb_book (title, summary, index, price, pages, isbn, publish_date, category_id, author_id) VALUES ('Lógica de Programação', 'Os primeiros passos para entrar no mundo de desenvolvimento de software.', '## Lógica de programação', 9.90, 180, 'FRDD8G5Y1G', '2021-03-30', 1, 1);

INSERT INTO tb_country (name) VALUES ('Brasil');
INSERT INTO tb_country (name) VALUES ('Australia');
INSERT INTO tb_country (name) VALUES ('Venezuela');

