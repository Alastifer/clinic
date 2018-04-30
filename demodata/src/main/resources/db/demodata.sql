INSERT INTO users (username, password, enabled) VALUES ('employee', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('123', 'pass', true);

INSERT INTO user_roles (username, role) VALUES ('employee', 'ROLE_EMPLOYEE');
INSERT INTO user_roles (username, role) VALUES ('123', 'ROLE_USER');

INSERT INTO patients (username, first_name, last_name, address, birth_day, phone_number) VALUES ('123', 'Александр', 'Гришкевич', 'Слободская', '1999-09-02', '+375299999999');

INSERT INTO disease_types (id, name) VALUES (1, 'Ангина');

INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (1, '2010-03-01', '2010-04-02', 'Содержание болезни', '123', 1);
INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (2, '2010-02-10', '2010-02-14', 'Содержание болезни', '123', 1);

INSERT INTO analyze_types (id, name) VALUES (1, 'Анализ крови');

INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (1, '2012-02-22', 'Содержание анализа', '123', 1);
INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (2, '2012-01-02', 'Содержание анализа', '123', 1);