INSERT INTO actor (id, name, opis) VALUES (1, 'Tom Hanks', 'spoko aktor');
INSERT INTO actor (id, name, opis) VALUES (2, 'Adam Małysz', 'skoczek');
INSERT INTO comment (nick, text, rating, actor_id) VALUES ('nick 1', 'komentarz1', 5, 1);
INSERT INTO comment (nick, text, rating, actor_id) VALUES ('nick 2', 'komentarz2', 7, 1);
INSERT INTO comment (nick, text, rating, actor_id) VALUES ('nick 3', 'komentarz3', 1, 2);
INSERT INTO film (title, year, premiere_date, description)
VALUES ('Titanic', 1998, '12.06.2000', 'ciekawy film tylko długi');
INSERT INTO film (title, year, premiere_date, description)
VALUES ('Incepction', 1996, '15.02.1997', 'film opowiada ciekawa historie');

INSERT INTO actor_film(actor_id, film_id) VALUES (1, 1);
INSERT INTO actor_film(actor_id, film_id) VALUES (1, 2);
