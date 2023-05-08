insert into editorial (id, nombre, direccion, contacto) values (1, 'Norma', 'C/Falsa', 'norma@gmail.com');
insert into producto (id, titulo, precio_unidad, stock, editorial_id) values ('1', 'Batman', 12, 20, 1);
insert into comic (autor, guionista, sinopsis, id) values ('Pedro', 'Lolo', 'Un cómic de un señor en mayas', 1);
insert into cliente (apellidos, ciudad, contrasenia, correo_electronico, cp, direccion, dni, fecha_nacimiento, nombre, provincia, telefono) values ( 'Franch', 'Sevilla', 'merendolA.4', 'pedrofe.av@gmail.com', '21130', 'C/STA Ma de la Rábida', '49107200S', '1991-06-24', 'Pedro', 'Sevilla', '666066874');
insert into cliente (apellidos, ciudad, contrasenia, correo_electronico, cp, direccion, dni, fecha_nacimiento, nombre, provincia, telefono) values ( 'Franch', 'Sevilla', 'merendolA.4', 'pedrofe.av@gmail.com', '21130', 'C/STA Ma de la Rábida', '49107200S', '1991-06-24', 'Pedro', 'Sevilla', '666066874');
ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 100;
