INSERT INTO cliente (id, apellidos, password , correo_electronico, nombre, admin, username) VALUES (1, 'Naranjo', '{bcrypt}$2a$10$bofV6kNXT3YhHSv.XaW9neIjKIes8QbjSRyPmSV2p/jIzf2bjppRi', 'angelNaranjo@gmail.com', 'Angel', false, 'user');
INSERT INTO cliente (id, apellidos, password , correo_electronico, nombre, admin, username) VALUES (2, 'Molina', '{bcrypt}$2a$10$bofV6kNXT3YhHSv.XaW9neIjKIes8QbjSRyPmSV2p/jIzf2bjppRi', 'molina@gmail.com', 'Lolo', True, 'admin');
INSERT INTO editorial (id, direccion, email, nombre, tlf) VALUES (1, 'C/falsa 1234', 'norma@gmail.com', 'Norma', '959546741');
INSERT INTO producto (id, img, precio_unidad, stock, editorial_id, titulo) VALUES (1, 'https://hablandodecomics.files.wordpress.com/2011/09/portada-batman-50-planeta-morrison.jpg', 20, 40, 1, 'Batman');
INSERT INTO comic (guionista, ilustrador, sinopsis, id) VALUES ('Paco', 'Luis', 'Un comic muy guay', 1);
ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;