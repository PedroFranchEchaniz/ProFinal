INSERT INTO cliente (id, apellidos, password , correo_electronico, nombre, admin, username) VALUES (100, 'Naranjo', '{bcrypt}$2a$10$bofV6kNXT3YhHSv.XaW9neIjKIes8QbjSRyPmSV2p/jIzf2bjppRi', 'angelNaranjo@gmail.com', 'Angel', false, 'user');
INSERT INTO cliente (id, apellidos, password , correo_electronico, nombre, admin, username) VALUES (101, 'Molina', '{bcrypt}$2a$10$bofV6kNXT3YhHSv.XaW9neIjKIes8QbjSRyPmSV2p/jIzf2bjppRi', 'molina@gmail.com', 'Lolo', True, 'admin');
INSERT INTO editorial (id, direccion, email, nombre, tlf) VALUES (1, 'C/falsa 1234', 'norma@gmail.com', 'Norma', '959546741');
INSERT INTO editorial (id, direccion, email, nombre, tlf) VALUES (2, 'C/falsa 1235', 'malditoGames@gmail.com', 'Maldito Games', '959546741');
INSERT INTO editorial (id, direccion, email, nombre, tlf) VALUES (3, 'C/falsa 1235', 'malditoGames@gmail.com', 'Vertigo', '959546741');
INSERT INTO editorial (id, direccion, email, nombre, tlf) VALUES (4, 'C/falsa 1235', 'malditoGames@gmail.com', 'DC', '959546741');
INSERT INTO producto (id, img, precio_unidad, stock, editorial_id, titulo) VALUES (1, 'https://hablandodecomics.files.wordpress.com/2011/09/portada-batman-50-planeta-morrison.jpg', 20, 40, 1, 'Batman');
INSERT INTO comic (guionista, ilustrador, sinopsis, id) VALUES ('Paco', 'Luis', 'Un comic muy guay', 1);
INSERT INTO producto (id, img, precio_unidad, stock, editorial_id, titulo) VALUES (2, 'https://www.tiendascosmic.com/imagenes/comics/lacosadelpantano14_01g.jpg', 10, 40, 1, 'The Swanp');
INSERT INTO comic (guionista, ilustrador, sinopsis, id) VALUES ('Paco', 'Luis', 'Un comic muy guay', 2);
INSERT INTO producto (id, img, precio_unidad, stock, editorial_id, titulo) VALUES (3, 'https://www.goldengoblingames.com/media/catalog/product/cache/cfae4e09283942a26059feb86e746738/r/o/rox-402-th-01.jpg', 40.50, 40, 2, 'Brass');
INSERT INTO juego_mesa (descripcion, n_jugadores_max, n_jugadores_min, tipo, id) VALUES ('Demuestra la capacidad de control y dominio que tienes sobre tus posesiones y vence en este gran juego de estrategia', 2, 5, 'Gestión de recursos', 3);
INSERT INTO producto (id, img, precio_unidad, stock, editorial_id, titulo) VALUES (4, 'https://content.eccediciones.com/productos/5065/Vertigo_02_Sandman_01_cover_DEF.jpg', 10, 40, 3, 'The Swanp');
INSERT INTO comic (guionista, ilustrador, sinopsis, id) VALUES ('Paco', 'Luis', 'Un comic muy guay', 4);
INSERT INTO producto (id, img, precio_unidad, stock, editorial_id, titulo) VALUES (5, 'https://sm.ign.com/ign_es/gallery/t/the-batman/the-batman-march-comics-variant-covers-gallery_996h.jpg', 10, 40, 4, 'Batman');
INSERT INTO comic (guionista, ilustrador, sinopsis, id) VALUES ('Paco', 'Luis', 'Un comic muy guay', 5);
ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;