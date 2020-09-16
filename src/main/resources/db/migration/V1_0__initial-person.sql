CREATE TABLE IF NOT EXISTS person (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(64) NOT NULL,
    age int NOT NULL,
    UNIQUE KEY unique_name(name)
);
