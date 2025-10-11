CREATE DATABASE CSD430;

CREATE USER IF NOT EXISTS 'student1'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON CSD430.* TO 'student1'@'localhost';
FLUSH PRIVILEGES;

USE CSD430;

CREATE TABLE mandy_movies_data (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    director VARCHAR(100),
    rel_year INT,
    genre VARCHAR(50),
    main_char VARCHAR (100)
);

INSERT INTO mandy_movies_data (title, director, rel_year, genre, main_char) VALUES
('Back to the Future', 'Robert Zemeckis', '1985', 'Sci-Fi', 'Marty McFly'),
('Spy Kids 3D', 'Robert Rodriguez', '2003', 'Action', 'Juni Cortez'),
('Titanic', 'James Cameron', '1997', 'Romance', 'Rose Dawson'),
('Smile', 'Parker Finn', '2022', 'Horror', 'Rose Cotter'),
('Harry Potter and the Deathly Hallows Pt. 2', 'David Yates', '2011', 'Fantasy', 'Harry Potter'),
('Maze Runner', 'Wes Ball', '2011', 'Sci-Fi', 'Thomas'),
('Scott Pilgrim Vs. The World', 'Edgar Wright', '2010', 'Action', 'Scott Pilgrim'),
('Tarzan', 'Kevin Lima and Chris Buck', '1999', 'Adventure', 'Tarzan'),
('Hot Rod', 'Akiva Schaffer', '2007', 'Comedy', 'Rod Kimble'),
('A Little Princess', 'Alfonso Cuaron', '1995', 'Fantasy', 'Sarah Crewe');

SELECT * from mandy_movies_data;