CREATE TABLE vaccines (
	id               BIGINT       NOT NULL AUTO_INCREMENT,
	name             VARCHAR(255) NOT NULL,
    realization_date DATE         NOT NULL,
    user_id          BIGINT       NOT NULL,
    CONSTRAINT vaccines_pk PRIMARY KEY (id),
    CONSTRAINT vaccines_fk_users FOREIGN KEY (user_id) REFERENCES users(id)
);