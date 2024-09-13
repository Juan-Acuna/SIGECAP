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

-- CAPACITACIONES
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitacion AZ-900', 'Capacitacion en Azure', '2024-09-02T10:00:00','2024-09-02T11:30:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Java Básico', 'Introducción a la programación en Java.', '2024-08-05T09:00:00', '2024-08-05T11:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Python Avanzado', 'Temas avanzados de Python para desarrolladores.', '2024-08-07T14:00:00', '2024-08-07T16:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Docker', 'Uso de Docker para la contenedorización de aplicaciones.', '2024-08-10T10:00:00', '2024-08-10T12:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Kubernetes', 'Gestión de contenedores con Kubernetes.', '2024-08-12T13:00:00', '2024-08-12T15:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en DevOps', 'Integración y despliegue continuo en proyectos.', '2024-08-15T09:30:00', '2024-08-15T11:00:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en AWS', 'Conceptos básicos de AWS.', '2024-08-18T10:00:00', '2024-08-18T12:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en CI/CD con Jenkins', 'Automatización de flujos de trabajo con Jenkins.', '2024-08-20T14:00:00', '2024-08-20T15:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Spring Boot', 'Desarrollo de aplicaciones web con Spring Boot.', '2024-08-22T09:00:00', '2024-08-22T12:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Angular', 'Desarrollo front-end con Angular.', '2024-08-24T13:30:00', '2024-08-24T15:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en React', 'Fundamentos de React y desarrollo de componentes.', '2024-08-26T10:30:00', '2024-08-26T12:00:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Seguridad Informática', 'Conceptos de seguridad para desarrolladores.', '2024-09-01T11:00:00', '2024-09-01T12:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Node.js', 'Desarrollo de aplicaciones con Node.js.', '2024-09-03T09:00:00', '2024-09-03T11:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Bases de Datos SQL', 'Introducción a SQL y modelado de datos.', '2024-09-05T14:00:00', '2024-09-05T16:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en NoSQL', 'Bases de datos NoSQL y su uso en aplicaciones modernas.', '2024-09-07T10:00:00', '2024-09-07T12:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Machine Learning', 'Conceptos básicos de Machine Learning.', '2024-09-09T13:00:00', '2024-09-09T15:30:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Inteligencia Artificial', 'Aplicaciones de IA en el desarrollo de software.', '2024-09-12T11:00:00', '2024-09-12T13:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Git y GitHub', 'Gestión de versiones y trabajo colaborativo con Git.', '2024-09-14T09:30:00', '2024-09-14T11:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en HTML y CSS', 'Fundamentos del desarrollo web.', '2024-09-17T14:00:00', '2024-09-17T15:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en JavaScript', 'Programación con JavaScript para la web.', '2024-09-19T10:00:00', '2024-09-19T12:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en TypeScript', 'Uso de TypeScript para aplicaciones web modernas.', '2024-09-21T13:00:00', '2024-09-21T14:30:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en APIs RESTful', 'Diseño e implementación de APIs RESTful.', '2024-10-01T09:00:00', '2024-10-01T11:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en GraphQL', 'Uso de GraphQL para la consulta de datos.', '2024-10-03T14:00:00', '2024-10-03T16:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Blockchain', 'Introducción a la tecnología Blockchain.', '2024-10-05T10:00:00', '2024-10-05T12:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Ciberseguridad', 'Protección y seguridad en redes y aplicaciones.', '2024-10-07T13:30:00', '2024-10-07T15:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Big Data', 'Manejo de grandes volúmenes de datos.', '2024-10-10T11:00:00', '2024-10-10T13:00:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Análisis de Datos', 'Técnicas y herramientas para el análisis de datos.', '2024-10-12T09:00:00', '2024-10-12T11:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Metodologías Ágiles', 'Scrum, Kanban y otras metodologías ágiles.', '2024-10-14T14:00:00', '2024-10-14T16:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Testing de Software', 'Técnicas de testing en aplicaciones.', '2024-10-16T10:00:00', '2024-10-16T11:30:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Arquitectura de Software', 'Diseño de arquitecturas escalables.', '2024-10-18T13:00:00', '2024-10-18T15:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Diseño UX/UI', 'Principios de diseño de interfaces y experiencia de usuario.', '2024-10-20T11:00:00', '2024-10-20T12:30:00');

INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en Microservicios', 'Diseño e implementación de microservicios.', '2024-10-22T09:00:00', '2024-10-22T12:00:00');
INSERT INTO capacitacion (titulo, descripcion, inicio, fin) VALUES ('Capacitación en SRE', 'Prácticas de Site Reliability Engineering.', '2024-10-24T14:00:00', '2024-10-24T15:30:00');