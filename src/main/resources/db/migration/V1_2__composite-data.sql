CREATE TABLE person (
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    age int NOT NULL,
    created datetime NOT NULL,
    updated datetime NOT NULL,
    PRIMARY KEY (first_name, last_name)
);