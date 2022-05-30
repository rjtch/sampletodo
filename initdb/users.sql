CREATE DATABASE users;
CREATE TABLE IF NOT EXISTS users (
    userId INT NOT NULL,
    username varchar(250) NOT NULL,
    password varchar(250) NOT NULL,
    email varchar(250) NOT NULL,

    PRIMARY KEY (userId)
    );

