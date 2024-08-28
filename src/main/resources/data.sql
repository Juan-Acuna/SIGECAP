-- ROLES
INSERT INTO rol (nombre) VALUES ('Administrador');
INSERT INTO rol (nombre) VALUES ('Alumno');
INSERT INTO rol (nombre) VALUES ('Tutor');

-- USUARIOS ADMINISTRADORES
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Francisco', 'Fernandez Fuentes', 'francisco@fake.com', '$2a$10$blX3QyYFItqI84NLYfozrecTuAp5xQGeHu4OekO39QMXjT33qRVy2', true, 1);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Lucia', 'Lopez Lira', 'lucia@fake.com', '$2a$10$Ah6u3ne/LabFBE8YF660/ekvSjLfY9nCguG/Nwe6EkgMHSenIvJ1.', true, 1);
-- USUARIOS ALUMNOS
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Tadeo', 'Tapia Toro', 'tadeo@fake.com', '$2a$10$NbaPpz2RBUg45twiO1LKIuVGsWKqe8bB0Dae6wCRrYhUjMr4Qdwhm', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Javiera', 'Jara Jopia', 'javiera@fake.com','$2a$10$gOrH33PMU6zTcX3petf1KuFhhb7/esxeKUAbBoqOhkeUuB3KU9pIm', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Gonzalo', 'Gonzalez Gonzalez', 'gonzalo@fake.com', '$2a$10$.4Hmrr6Ge0BiGKiOUA.RpO9Gd8IiKGqycv8QgNPL6Y01jCKoUDyee', true, 2);
-- USUARIOS TUTORES
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Martin', 'Mora Meneses', 'martin@fake.com','$2a$10$e05ZRRdyHoOIyTPOLeEZgexkmUumOoY4gEXWXsq960m75mk21L.8S', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Sofia', 'Salazar Soto', 'sofia@fake.com','$2a$10$YO1WkhJY81nMO/nQiYc6Be3avGzurAy6NnxFpYVhO0xc22Xk3MJsu', true, 3);