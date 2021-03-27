DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS analyzes;
DROP TABLE IF EXISTS analyze_types;
DROP TABLE IF EXISTS diseases;
DROP TABLE IF EXISTS disease_types;
DROP TABLE IF EXISTS user2roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_details;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS positions;
DROP TABLE IF EXISTS hospitals;
DROP TABLE IF EXISTS user_address;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS cities;


CREATE TABLE users
(
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE roles
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE user2roles
(
    username     VARCHAR(50) NOT NULL,
    user_role_id BIGINT      NOT NULL,
    UNIQUE (username, user_role_id),
    FOREIGN KEY (username) REFERENCES users (username) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (user_role_id) REFERENCES roles (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE countries
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE cities
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE addresses
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    country_code    BIGINT       NOT NULL,
    city_code       BIGINT       NOT NULL,
    street_name     VARCHAR(100) NOT NULL,
    house_number    VARCHAR(50)  NOT NULL,
    corps           VARCHAR(50),
    apartment       VARCHAR(10),
    primary_address BOOLEAN DEFAULT FALSE,
    UNIQUE (country_code, city_code, street_name, house_number, corps, apartment),
    FOREIGN KEY (country_code) REFERENCES countries (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (city_code) REFERENCES cities (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE hospitals
(
    code       VARCHAR(100) PRIMARY KEY,
    name       VARCHAR(200) NOT NULL,
    address_id BIGINT       NOT NULL,
    FOREIGN KEY (address_id) REFERENCES addresses (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE user_address
(
    username   VARCHAR(50) NOT NULL,
    address_id BIGINT      NOT NULL,
    UNIQUE (username, address_id),
    FOREIGN KEY (username) REFERENCES users (username) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (address_id) REFERENCES addresses (id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE positions
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE user_details
(
    username     VARCHAR(50) PRIMARY KEY,
    first_name   VARCHAR(50)  NOT NULL,
    last_name    VARCHAR(50),
    address      VARCHAR(100) NOT NULL,
    birth_day    DATE         NOT NULL,
    phone_number VARCHAR(30)  NOT NULL,
    id_position  BIGINT,
    hospital_id  VARCHAR(100) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_position) REFERENCES positions (id) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (hospital_id) REFERENCES hospitals (code) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE disease_types
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE diseases
(
    id         BIGINT AUTO_INCREMENT,
    begin_date DATETIME      NOT NULL,
    end_date   DATETIME,
    content    VARCHAR(3000) NOT NULL,
    username   VARCHAR(30)   NOT NULL,
    id_type    BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES users (username) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_type) REFERENCES disease_types (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE analyze_types
(
    id   BIGINT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE analyzes
(
    id             BIGINT AUTO_INCREMENT,
    receiving_date DATETIME,
    content        VARCHAR(3000) NOT NULL,
    username       VARCHAR(30)   NOT NULL,
    id_type        BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES users (username) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (id_type) REFERENCES analyze_types (id) ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE tickets
(
    id           BIGINT AUTO_INCREMENT,
    receipt_date DATETIME    NOT NULL,
    room         VARCHAR(10) NOT NULL,
    employee     VARCHAR(30),
    patient      VARCHAR(30),
    PRIMARY KEY (id),
    FOREIGN KEY (patient) REFERENCES users (username) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (employee) REFERENCES users (username) ON UPDATE CASCADE ON DELETE RESTRICT
);