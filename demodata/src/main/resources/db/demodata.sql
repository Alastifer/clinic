INSERT INTO users (username, password, enabled) VALUES ('employee', 'pass', true);
INSERT INTO users (username, password, enabled) VALUES ('123', 'pass', true);

INSERT INTO user_roles (username, role) VALUES ('employee', 'ROLE_EMPLOYEE');
INSERT INTO user_roles (username, role) VALUES ('123', 'ROLE_USER');

INSERT INTO patients (username, first_name, last_name, address, birth_day, phone_number) VALUES ('123', 'Alex', 'Grisha', 'Sloboda', '1999-09-02', '+375299999999');
