CREATE TABLE users (
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    name      VARCHAR(255) NOT NULL,
    cpf       VARCHAR(11)  NOT NULL UNIQUE,
    email     VARCHAR(255) NOT NULL UNIQUE,
    birthdate DATE         NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);