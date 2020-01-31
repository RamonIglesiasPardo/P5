DROP SCHEMA IF EXISTS ENTRECULTURAS;
CREATE SCHEMA IF NOT EXISTS ENTRECULTURAS DEFAULT CHARACTER SET utf8MB4;
USE ENTRECULTURAS;

CREATE TABLE IF NOT EXISTS Personal (

	idPersonal INT(4) NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(16) NOT NULL,
    primerApellido VARCHAR(16) NOT NULL,
    segundoApellido VARCHAR(16) NOT NULL,
    dni VARCHAR(9) NOT NULL,
    direccion VARCHAR(64) NOT NULL,
    telefono VARCHAR(18) NOT NULL,
    mail VARCHAR(36) NOT NULL,
    PRIMARY KEY(idPersonal),
    UNIQUE(dni)

) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS PerVoluntario (
	idPersonal INT(4) NOT NULL,
    numHorasVol INT(4) NOT NULL,
    FOREIGN KEY(idPersonal) REFERENCES Personal(idPersonal)	

) ENGINE = InnoDB;

INSERT INTO Personal (nombre, primerApellido, segundoApellido, dni, direccion, telefono, mail)
	VALUES ("Manuel", "Vázquez", "Andrade", "25174612V", 
    "C/Principal, 2 2ºB, 500250, Benabarre (Huesca)", "674697423", "mvazquez@hotmail.com");

INSERT INTO Personal (nombre, primerApellido, segundoApellido, dni, direccion, telefono, mail)
	VALUES ("Judith", "Ortega", "Vargas", "17458746H", 
    "C/Las Rosas, 48 s/n, 274462, Málaga", "864223587", "laprimajudith@gmail.com");

INSERT INTO Personal (nombre, primerApellido, segundoApellido, dni, direccion, telefono, mail)
	VALUES ("Vicente", "Marqués", "Salvador", "17245887Z", 
    "Avda. Navarra, 172 , 51017, Zaragoza", "686235478", "vsmarques@gmail.com");




