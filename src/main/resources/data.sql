-- ROLES
INSERT INTO rol (nombre) VALUES ('Administrador');
INSERT INTO rol (nombre) VALUES ('Alumno');
INSERT INTO rol (nombre) VALUES ('Tutor');

-- USUARIOS ADMINISTRADORES
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Francisco', 'Fernandez Fuentes', 'francisco@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 1);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Lucia', 'Lopez Lira', 'lucia@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 1);
-- USUARIOS ALUMNOS
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Tadeo', 'Tapia Toro', 'tadeo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Javiera', 'Jara Jopia', 'javiera@fake.com','$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Gonzalo', 'Gonzalez Gonzalez', 'gonzalo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);

INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Carlos', 'Martinez Lopez', 'carlos@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Maria', 'Gonzalez Perez', 'maria@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Jose', 'Rodriguez Sanchez', 'jose@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Ana', 'Hernandez Garcia', 'ana@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Luis', 'Ruiz Martinez', 'luis@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Sara', 'Diaz Fernandez', 'sara@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Raul', 'Torres Gomez', 'raul@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Paula', 'Ramirez Torres', 'paula@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Jorge', 'Alvarez Ruiz', 'jorge@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Tomas', 'Morales Herrera', 'tomas@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Lorena', 'Mendez Navarro', 'lorena@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Diego', 'Ortega Paredes', 'diego@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Claudia', 'Vega Montes', 'claudia@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Eduardo', 'Guzman Garcia', 'eduardo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Isabel', 'Perez Alvarado', 'isabel@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Victor', 'Sanchez Cruz', 'victor@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Marta', 'Gimenez Rivas', 'marta@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Ivan', 'Ortiz Solis', 'ivan@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Laura', 'Blanco Martin', 'laura@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Pablo', 'Romero Herrera', 'pablo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Monica', 'Luna Bravo', 'monica@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Alberto', 'Salazar Torres', 'alberto@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Estela', 'Campos Morales', 'estela@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Fernando', 'Nuñez Soto', 'fernando@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('David', 'Gallego Ibañez', 'david@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Patricia', 'Marquez Fernandez', 'patricia@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Javier', 'Silva Paredes', 'javier@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Carmen', 'Santos Munoz', 'carmen@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Mario', 'Perez Castro', 'mario@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Elena', 'Lopez Romero', 'elena@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Adrian', 'Hernandez Castro', 'adrian@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Nuria', 'Torres Silva', 'nuria@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Guillermo', 'Gonzalez Fernandez', 'guillermo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Valeria', 'Marin Serrano', 'valeria@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Rodrigo', 'Jimenez Ramos', 'rodrigo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Teresa', 'Diaz Castillo', 'teresa@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Alfonso', 'Aguilar Ruiz', 'alfonso@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Hugo', 'Santos Perez', 'hugo@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 2);

-- USUARIOS TUTORES
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Martin', 'Mora Meneses', 'martin@fake.com','$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Sofia', 'Salazar Soto', 'sofia@fake.com','$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);

INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Miguel', 'Reyes Serrano', 'miguel@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Angela', 'Jimenez Flores', 'angela@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Oscar', 'Paredes Campos', 'oscar@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Clara', 'Rios Morales', 'clara@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Sergio', 'Navarro Montes', 'sergio@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Alicia', 'Vargas Ruiz', 'alicia@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Alvaro', 'Lara Diaz', 'alvaro@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Gabriela', 'Molina Gomez', 'gabriela@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Felipe', 'Cruz Ortega', 'felipe@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Cecilia', 'Ruiz Vargas', 'cecilia@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Rafael', 'Guerra Solis', 'rafael@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Irene', 'Romero Bravo', 'irene@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Emilio', 'Carrillo Vargas', 'emilio@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Susana', 'Pena Moreno', 'susana@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Roberto', 'Aguilar Nunez', 'roberto@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Alejandra', 'Castillo Ramirez', 'alejandra@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Juan', 'Padilla Molina', 'juan@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);
INSERT INTO usuario (nombres, apellidos, email, pwd, activo, rol) VALUES ('Vicente', 'Salazar Soto', 'vicente@fake.com', '$2a$12$PyWenXmeszP9PXI0YkN07O4oAwOJkAWP2898cncWHDdP.ki2t.pla', true, 3);

-- CAPACITACIONES
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitacion AZ-900', 'Capacitacion en Azure', '2024-10-02T10:00:00','2024-10-02T11:00:00', 20, 2);

INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Java Básico', 'Introducción a la programación en Java.', '2024-10-05T09:00:00', '2024-10-05T11:00:00', 40, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Python Avanzado', 'Temas avanzados de Python para desarrolladores.', '2024-10-07T14:00:00', '2024-10-07T16:00:00', 20, 3);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Docker', 'Uso de Docker para la contenedorización de aplicaciones.', '2024-10-10T10:00:00', '2024-10-10T12:00:00', 20, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Kubernetes', 'Gestión de contenedores con Kubernetes.', '2024-10-12T13:00:00', '2024-10-12T15:00:00', 40, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en DevOps', 'Integración y despliegue continuo en proyectos.', '2024-10-15T09:00:00', '2024-10-15T11:00:00', 40, 2);

INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en AWS', 'Conceptos básicos de AWS.', '2024-10-18T10:00:00', '2024-10-18T12:00:00', 40, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en CI/CD con Jenkins', 'Automatización de flujos de trabajo con Jenkins.', '2024-10-20T14:00:00', '2024-10-20T15:00:00', 20, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Spring Boot', 'Desarrollo de aplicaciones web con Spring Boot.', '2024-10-22T09:00:00', '2024-10-22T12:00:00', 40, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Angular', 'Desarrollo front-end con Angular.', '2024-10-24T13:00:00', '2024-10-24T15:00:00', 20, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en React', 'Fundamentos de React y desarrollo de componentes.', '2024-10-26T10:00:00', '2024-10-26T12:00:00', 30, 2);

INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Seguridad Informática', 'Conceptos de seguridad para desarrolladores.', '2024-10-01T11:00:00', '2024-10-01T12:00:00', 30, 1);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Node.js', 'Desarrollo de aplicaciones con Node.js.', '2024-10-03T09:00:00', '2024-10-03T11:00:00', 30, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Bases de Datos SQL', 'Introducción a SQL y modelado de datos.', '2024-10-05T14:00:00', '2024-10-05T16:00:00', 20, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en NoSQL', 'Bases de datos NoSQL y su uso en aplicaciones modernas.', '2024-10-07T10:00:00', '2024-10-07T12:00:00', 20, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Machine Learning', 'Conceptos básicos de Machine Learning.', '2024-10-09T13:00:00', '2024-10-09T15:00:00', 30, 2);

INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Inteligencia Artificial', 'Aplicaciones de IA en el desarrollo de software.', '2024-10-12T11:00:00', '2024-10-12T13:00:00', 30, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en Git y GitHub', 'Gestión de versiones y trabajo colaborativo con Git.', '2024-10-14T09:00:00', '2024-10-14T11:00:00', 20, 3);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en HTML y CSS', 'Fundamentos del desarrollo web.', '2024-10-17T14:00:00', '2024-10-17T15:00:00', 20, 2);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en JavaScript', 'Programación con JavaScript para la web.', '2024-10-19T10:00:00', '2024-10-19T12:00:00', 20, 3);
INSERT INTO capacitacion (titulo, descripcion, inicio, fin, max_alumnos, max_tutores) VALUES ('Capacitación en TypeScript', 'Uso de TypeScript para aplicaciones web modernas.', '2024-10-21T13:00:00', '2024-10-21T14:00:00', 20, 2);

-- USUARIOS CAPACITACIONES

INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (3, 1, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (4, 1, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (5, 1, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (44, 1, null);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (6, 2, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (7, 2, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (8, 2, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (45, 2, null);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (9, 3, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (10, 3, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (11, 3, 0.0);
INSERT INTO usuario_capacitacion (usuario, capacitacion, nota) VALUES (46, 3, null);