CREATE DATABASE SIS_RESERVACIONES;
USE SIS_RESERVACIONES;

CREATE TABLE PELICULAS(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(45) NOT NULL UNIQUE,
	DUR_MIN INT NOT NULL
);

SHOW TABLES;
SELECT * FROM PELICULAS;

CREATE TABLE CLIENTES (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NOMBRE VARCHAR(45),
	APELLIDO VARCHAR(45) NOT NULL,
	EMAIL varchar(45) NOT NULL UNIQUE
);

CREATE TABLE SALAS(
	ID INT PRIMARY KEY auto_increment,
	NOMBRE varchar(45) NOT NULL,
	N_ASIENTOS INT NOT NULL
);

CREATE TABLE FUNCIONES(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	ID_PELICULA INT NOT NULL,
	ID_SALA INT NOT NULL,
	HORA_INICIO DATETIME NOT NULL,
	FOREIGN KEY (ID_PELICULA) REFERENCES PELICULAS(ID),
	FOREIGN KEY (ID_SALA) REFERENCES SALAS(ID)
);
CREATE TABLE ASIENTOS(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	FILA CHAR(1) NOT NULL,
	NUMERO INT NOT NULL,
	ID_SALA int not null,
	FOREIGN KEY (ID_SALA) REFERENCES SALAS(ID)
);

CREATE TABLE RESERVACIONES(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	ID_FUNCION INT NOT NULL,
	ID_CLIENTE INT NOT NULL,
	FOREIGN KEY (ID_FUNCION) REFERENCES FUNCIONES(ID),
    FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID)
);

CREATE TABLE ASIENTOS_RESERVADOS(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_RESERVACION INT NOT NULL,
    ID_ASIENTO INT NOT NULL,
    FOREIGN KEY (ID_RESERVACION) REFERENCES RESERVACIONES(ID),
    FOREIGN KEY (ID_ASIENTO) REFERENCES ASIENTOS(ID)
);
