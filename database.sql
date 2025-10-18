#Create the database

CREATE DATABASE IF NOT EXISTS bookstore_db;
USE bookstore_db;

#Create the books table

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    quantity INT DEFAULT 0,
    tag VARCHAR(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#Create the users table

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#Insert sample data for books

INSERT INTO books ( title, 
                    author, 
                    quantity, 
                    tag)

VALUES  ('The Alchemist', 
        'Paulo Coelho', 
        10, 
        'popular'),

        ('Atomic Habits', 
        'James Clear', 
        5, 
        'new'),

        ('Rich Dad Poor Dad', 
        'Robert Kiyosaki', 
        8, 
        'popular');

#Insert sample data for users

INSERT INTO users ( username, 
                    password, 
                    role) 

VALUES ('user', 
        'pass', 
        'user'),

        ('admin', 
        'admin', 
        'storekeeper');