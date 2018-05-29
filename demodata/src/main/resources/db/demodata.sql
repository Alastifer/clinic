INSERT INTO users (username, password, enabled) VALUES ('employee1', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('employee2', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('user1', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('user2', 'pass', true);

INSERT INTO user_roles (username, role) VALUES ('employee1', 'ROLE_EMPLOYEE');
INSERT INTO user_roles (username, role) VALUES ('employee2', 'ROLE_EMPLOYEE');
INSERT INTO user_roles (username, role) VALUES ('user1', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('user2', 'ROLE_USER');

INSERT INTO patients (username, first_name, last_name, address, birth_day, phone_number) VALUES ('user1', 'Александр', 'Гришкевич', 'Слободская', '1999-09-02', '+375299999999');
INSERT INTO patients (username, first_name, last_name, address, birth_day, phone_number) VALUES ('user2', 'Иван', 'Гузич', 'Космонавтов', '2000-11-12', '+375259999999');

INSERT INTO disease_types (id, name) VALUES (1, 'Ангина');
INSERT INTO disease_types (id, name) VALUES (2, 'Простуда');

INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (1, '2010-03-01', '2010-04-02', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 'user1', 1);
INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (2, '2010-02-10', '2010-02-14', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 'user1', 2);
INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (3, '2012-02-10', '2012-02-14', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 'user2', 1);
INSERT INTO diseases (id, begin_date, end_date, content, username, id_type) VALUES (4, '2012-02-10', '2012-02-14', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 'user2', 2);

INSERT INTO analyze_types (id, name) VALUES (1, 'Общий анализ крови');
INSERT INTO analyze_types (id, name) VALUES (2, 'Кровь на сахар');

INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (1, '2012-02-22', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 'user1', 1);
INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (2, '2012-01-02', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 'user1', 2);
INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (3, '2012-02-22', 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.', 'user2', 1);
INSERT INTO analyzes (id, receiving_date, content, username, id_type) VALUES (4, '2012-01-02', 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using ''Content here, content here'', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for ''lorem ipsum'' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).', 'user2', 2);

INSERT INTO positions (id, name) VALUES (1, 'Терапевт');
INSERT INTO positions (id, name) VALUES (2, 'Хирург');

INSERT INTO employees (username, first_name, last_name, id_position) VALUES ('employee1', 'Иван', 'Иванов', 1);
INSERT INTO employees (username, first_name, last_name, id_position) VALUES ('employee2', 'Дмитрий', 'Ковалев', 2);

INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (1, '2022-03-02', 108, 'employee1', 'user1');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (2, '2021-03-12', 108, 'employee2', 'user1');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (3, '2020-04-02', 108, 'employee1', 'user1');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (4, '2019-01-22', 108, 'employee2', 'user1');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (5, '2023-01-22', 108, 'employee1', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (6, '2022-03-02', 108, 'employee2', 'user1');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (7, '2022-03-12', 108, 'employee1', 'user2');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (8, '2023-04-02', 108, 'employee2', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (9, '2023-01-22', 108, 'employee1', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (10, '2019-01-22', 108, 'employee2', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (11, '2019-03-02', 108, 'employee1', 'user2');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (12, '2022-03-12', 108, 'employee2', 'user2');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (13, '2023-04-02', 108, 'employee1', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (14, '2020-01-22', 108, 'employee2', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (15, '2023-01-22', 108, 'employee1', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (16, '2021-03-02', 108, 'employee2', 'user2');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (17, '2022-03-12', 108, 'employee1', 'user2');
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (18, '2023-04-02', 108, 'employee2', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (19, '2019-01-22', 108, 'employee1', NULL);
INSERT INTO tickets (id, receipt_date, room, employee, patient) VALUES (20, '2020-01-22', 108, 'employee2', NULL);