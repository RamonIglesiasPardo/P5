CREATE DATABASE entreculturasHibernate;
USE entreculturasHibernate;

CREATE TABLE personalNacional (
id int AUTO_INCREMENT,
nombre VARCHAR(50),
apellido1 VARCHAR(100),
apellido2 VARCHAR(100),
direccionCalle VARCHAR(100),
direccionNumero VARCHAR(100),
provincia VARCHAR(100),
telefono VARCHAR(10),
mail VARCHAR(20),
PRIMARY KEY (id)
);

INSERT INTO `entreculturasHibernate`.`personalNacional`
(`nombre`,		`apellido1`,		`apellido2`,		`direccionCalle`,		`direccionNumero`,		`provincia`,		`telefono`,			`mail`)
VALUES
('Manolo','Escobar','Del Fary','c / Malaga','32','Malaga','651513211','elfary@fary.com');

INSERT INTO `entreculturasHibernate`.`personalNacional`
(`nombre`,		`apellido1`,		`apellido2`,		`direccionCalle`,		`direccionNumero`,		`provincia`,		`telefono`,			`mail`)
VALUES
('Pedro','Duque','El de la TV','c / TV','100','Madrid','651123211','elduque@delatv.com');

INSERT INTO `entreculturasHibernate`.`personalNacional`
(`nombre`,		`apellido1`,		`apellido2`,		`direccionCalle`,		`direccionNumero`,		`provincia`,		`telefono`,			`mail`)
VALUES
('Pedro','Sanchez','Sanzhezz','c / Ministerios Presidenciales','151','Moncloa','91152112','elpresi@supsi.com');

CREATE TABLE  personalInternacional (
id int AUTO_INCREMENT,
nombre VARCHAR(50),
apellido VARCHAR(100),
direccion VARCHAR(50),
pais VARCHAR(100),
telefono VARCHAR(10),
mail VARCHAR(20),
PRIMARY KEY (id)
);

INSERT INTO personalInternacional
(`nombre`,		`apellido`,		`direccion`,			`pais`,		`telefono`,			`mail`)

values
 ('James','Smith',  'White Avenue', 'USA', '0012654987','james@smith.com');