-- Actor
INSERT INTO actor (first_name, last_name, alias, gender)
VALUES ('Tom', 'Hanks', 'The Nicest Guy in Hollywood', 'MALE'),
       ('Emma', 'Stone', 'Riley Stone', 'FEMALE'),
       ('Leonardo', 'DiCaprio', 'Leo', 'MALE'),
       ('Gal', 'Gadot', 'Wonder Woman', 'FEMALE'),
       ('Hugh', 'Jackman', 'Wolverine', 'MALE');


-- Movie
INSERT INTO movie (title, genre, release_year, director_name, movie_poster, movie_trailer)
VALUES ('Forrest Gump', 'Drama, Romance', '1994', 'Robert Zemeckis', 'http://example.com/forrest-gump-poster.jpg',
        'http://example.com/forrest-gump-trailer.mp4'),
       ('La La Land', 'Comedy, Drama, Music', '2016', 'Damien Chazelle', 'http://example.com/la-la-land-poster.jpg',
        'http://example.com/la-la-land-trailer.mp4'),
       ('The Revenant', 'Adventure, Drama, Thriller', '2015', 'Alejandro G. Iñárritu',
        'http://example.com/the-revenant-poster.jpg', 'http://example.com/the-revenant-trailer.mp4'),
       ('Wonder Woman', 'Action, Adventure, Fantasy', '2017', 'Patty Jenkins',
        'http://example.com/wonder-woman-poster.jpg', 'http://example.com/wonder-woman-trailer.mp4'),
       ('Logan', 'Action, Drama, Sci-Fi', '2017', 'James Mangold', 'http://example.com/logan-poster.jpg',
        'http://example.com/logan-trailer.mp4');


-- Franchise
INSERT INTO franchise (name, description)
VALUES ('Marvel Cinematic Universe', 'A series of superhero films based on Marvel Comics characters.'),
       ('Star Wars', 'A series of space-opera films.'),
       ('James Bond', 'A series of spy films based on the fictional character of MI6 agent James Bond.'),
       ('DC Extended Universe', 'A series of superhero films based on DC Comics characters.'),
       ('X-Men', 'A series of superhero films based on the Marvel Comics X-Men characters.');


--actor_movie
-- Forrest Gump (1994)
-- Tom Hanks
INSERT INTO actor_movies (actor_id, movie_id)
VALUES (1, 1);

-- La La Land (2016)
-- Emma Stone
INSERT INTO actor_movies (actor_id, movie_id)
VALUES (2, 2);

-- The Revenant (2015)
-- Leonardo DiCaprio
INSERT INTO actor_movies (actor_id, movie_id)
VALUES (3, 3);

-- Wonder Woman (2017)
-- Gal Gadot
INSERT INTO actor_movies (actor_id, movie_id)
VALUES (4, 4);

-- Logan (2017)
-- Hugh Jackman
INSERT INTO actor_movies (actor_id, movie_id)
VALUES (5, 5);



-- movie_franchise
-- Forrest Gump in the Paramount Pictures franchise
INSERT INTO franchise_movies (franchise_id, movie_id)
VALUES (1, 1);

--La La Land in the Lionsgate franchise
INSERT INTO franchise_movies (franchise_id, movie_id)
VALUES (2,2);

-- The Revenant in the 20th Century Fox franchise
INSERT INTO franchise_movies (franchise_id, movie_id)
VALUES (3,3);

-- Wonder Woman in the DC Extended Universe franchise
INSERT INTO franchise_movies (franchise_id, movie_id)
VALUES (4, 4);

-- Logan in the X-Men franchise
INSERT INTO franchise_movies (franchise_id, movie_id)
VALUES (5, 5);

-- actor_




