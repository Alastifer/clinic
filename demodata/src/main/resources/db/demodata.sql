INSERT INTO users (username, password, enabled) VALUES ('employee', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('123', 'pass', true);

INSERT INTO user_roles (username, role) VALUES ('employee', 'ROLE_EMPLOYEE');
INSERT INTO user_roles (username, role) VALUES ('123', 'ROLE_USER');

INSERT INTO patients (username, first_name, last_name, address, birth_day, phone_number) VALUES ('123', 'Александр', 'Гришкевич', 'Слободская', '1999-09-02', '+375299999999');

INSERT INTO disease_types (id, name) VALUES (1, 'Ангина');

INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (1, '2010-03-01', '2010-04-02', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', '123', 1);
INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (2, '2010-02-10', '2010-02-14', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', '123', 1);

INSERT INTO analyze_types (id, name) VALUES (1, 'Анализ крови');

INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (1, '2012-02-22', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', '123', 1);
INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (2, '2012-01-02', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', '123', 1);

INSERT INTO positions (id, name) VALUES (1, 'Терапевт');

INSERT INTO employees (username, first_name, last_name, id_position) VALUES ('employee', 'Иван', 'Иванов', 1);

INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (1, '2022-03-02', 108, 'employee', '123');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (2, '2022-03-12', 108, 'employee', '123');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (3, '2023-04-02', 108, 'employee', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (4, '2023-01-22', 108, 'employee', NULL);