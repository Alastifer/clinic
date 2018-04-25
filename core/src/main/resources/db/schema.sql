DROP TABLE IF EXISTS diseases;
DROP TABLE IF EXISTS analyzes;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  username VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL,
  enabled INT NOT NULL DEFAULT 1,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles (
  userrole_id BIGINT AUTO_INCREMENT,
  username VARCHAR(30) NOT NULL,
  role VARCHAR(30) NOT NULL,
  PRIMARY KEY (userrole_id),
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE TABLE patients (
  username VARCHAR(30),
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  address VARCHAR(100) NOT NULL,
  birth_day DATE NOT NULL,
  phone_number VARCHAR(30) NOT NULL,
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE TABLE employees (
  username VARCHAR(30),
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  id_position BIGINT NOT NULL,
  PRIMARY KEY (username),
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE TABLE diseases (
  id BIGINT AUTO_INCREMENT,
  begin_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  content VARCHAR(3000) NOT NULL,
  username VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (username) REFERENCES patients(username)
);

CREATE TABLE analyzes (
  id BIGINT AUTO_INCREMENT,
  receiving_date DATETIME NOT NULL,
  content VARCHAR(3000) NOT NULL,
  username VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (username) REFERENCES patients(username)
);

CREATE TABLE tickets (
  id BIGINT AUTO_INCREMENT,
  receipt_date DATETIME NOT NULL,
  id_collaborator BIGINT NOT NULL,
  id_room BIGINT NOT NULL,
  username VARCHAR(30) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (username) REFERENCES patients(username)
);