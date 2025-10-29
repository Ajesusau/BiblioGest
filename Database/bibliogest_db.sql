-- Tabla de Usuarios
CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE,
    tipo_usuario ENUM('administrador', 'usuario') NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Libros
CREATE TABLE Libros (
    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(100),
    ISBN VARCHAR(13) UNIQUE,
    fecha_publicacion DATE,
    estado ENUM('disponible', 'prestado') DEFAULT 'disponible'
);

-- Tabla de Préstamos
CREATE TABLE Prestamos (
    id_prestamo INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT,
    libro_id INT,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    estado ENUM('pendiente', 'devuelto') DEFAULT 'pendiente',
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (libro_id) REFERENCES Libros(id_libro)
);

-- Usuario Administrador Predeterminado
INSERT INTO Usuarios (usuario, contrasena, tipo_usuario) 
VALUES ('admin', 'admin', 'administrador');