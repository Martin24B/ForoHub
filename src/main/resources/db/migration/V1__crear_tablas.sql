
CREATE TABLE autores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE
);


CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT
);

CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    autor_id INT,
    curso_id INT,
    FOREIGN KEY (autor_id) REFERENCES autores(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);



INSERT INTO autores (nombre, fecha_nacimiento) VALUES
('Juan Pérez', '1985-08-15'),
('Ana Gómez', '1990-02-25'),
('Carlos Martínez', '1980-11-30');


INSERT INTO cursos (titulo, descripcion) VALUES
('Introducción a la programación', 'Curso básico sobre fundamentos de programación.'),
('Desarrollo web con Java', 'Curso intermedio sobre desarrollo de aplicaciones web usando Java.'),
('Bases de datos SQL', 'Curso avanzado sobre diseño y optimización de bases de datos SQL.');

-
INSERT INTO topicos (titulo, mensaje, status, autor_id, curso_id) VALUES
('¿Qué es Java?', 'Estoy aprendiendo Java y tengo dudas sobre sus fundamentos.', 'activo', 1, 2),
('Problema con SQL', 'No entiendo cómo realizar un JOIN en SQL, ¿alguien me puede ayudar?', 'activo', 2, 3),
('¿Qué es la programación orientada a objetos?', 'Quiero aprender sobre programación orientada a objetos, ¿alguien puede explicar?', 'activo', 3, 1);
