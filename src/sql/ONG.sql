
  /** Aquí el código SQL utilizado para crear la Base de Datos externa
   *  y sus tablas.
   */

-- Creamos el esquema de la base de datos

CREATE SCHEMA IF NOT EXISTS Entreculturas DEFAULT CHARACTER SET utf8mb4;
USE Entreculturas;

/** TABLA PERSONA
 *  Para implementar la herencia he optado por crear un campo PK, IdPersona,
 *  que utilizaremos como referencia para asociar las subclases. Cada subclase
 *  tendrá además su id propio, más que nada para identificar cada instancia en
 *  SQL, y tendremos el campo IdPersonal en la tabla Personal que será el verdadero
 *  Id de empleado general que hemos generado en Java.
 */

CREATE TABLE IF NOT EXISTS Persona (

	IdPersona INT(6) NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(16) NOT NULL,
    PrimerApellido VARCHAR(16) NOT NULL,
    SegundoApellido VARCHAR(16) NOT NULL,
    -- Opto por que la deireccion sea de tipo VARCHAR, por dos motivos:
    -- Primero, en teoría debemos pasar los datos desde el XML generado por
    -- la aplicación Java, que es una cadena de texto en realidad.
    -- Segundo, podríamos crear una tabla Direccion con los campos corresponientes
    -- (Calle, piso, puerta, etc.), pero no le veo mucho sentido porque, para qué
    -- almacenar las direcciones en una tabla aparte... Si lo que importa es que
    -- pasemos los elementos desde Java, concretamente desde un fichero XML, creo
    -- que el campo Direccion de tipo VARCHAR nos vale perfectamente.
    Direccion VARCHAR(128) NOT NULL,
    Telefono VARCHAR(12) NOT NULL,
    Mail VARCHAR(32) NOT NULL,

    PRIMARY KEY(IdPersona)

) ENGINE = InnoDB;

/** TABLA PERSONAL
 *
 * Con la FK IdPersona podemos relacionar esta tabla Personal con su superclase Persona.
 * Para realizar una consulta de una instancia Personal, deberíamos hacer un JOIN entre
 * la tabla Personal y Persona, para mostrar los campos de la superclase (nombre, teléfono, etc.)
 */

CREATE TABLE IF NOT EXISTS Personal (

	IdPersonal INT(4) NOT NULL AUTO_INCREMENT,
    IdPersona INT(6) NOT NULL,

    PRIMARY KEY(IdPersonal),
    FOREIGN KEY(IdPersona) REFERENCES Persona(IdPersona)
		ON UPDATE CASCADE ON DELETE CASCADE

) ENGINE = InnoDb;


  /** TABLA PerVoluntario
   *
   * Lo mismo que las anteriores, pero aquí se incluirán más referencias
   * (a Persona y a Personal). No obstante incluiremos una PK IdPerVol
   * que no usaremos como referencia, sino solo para incluir una PK que
   * que identifique la instancia PerVol (Revisar este último punto)
   */

   CREATE TABLE IF NOT EXISTS PerVoluntario (

	IdPerVol INT(4) NOT NULL AUTO_INCREMENT,
    IdPersonal INT(4) NOT NULL,
    IdPersona INT(6) NOT NULL,
    NumHorasVol INT(4) NULL DEFAULT 0,
    PRIMARY KEY(IdPerVol),
    FOREIGN KEY(IdPersonal) REFERENCES Personal(IdPersonal)
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(IdPersona) REFERENCES Persona(IdPersona)
		ON UPDATE CASCADE ON DELETE CASCADE

   ) ENGINE = InnoDB;

   /* TABLA PerVolInternacional */

   CREATE TABLE IF NOT EXISTS PerVolInternacional (

	IdPerVolInt INT(4) NOT NULL AUTO_INCREMENT,
    idPerVol INT(4) NOT NULL,
    IdPersonal INT(4) NOT NULL,
    IdPersona INT(6) NOT NULL,
    PaisOrigen VARCHAR(16) NOT NULL,
    -- Campo para la direccion internacional
    SDireccion VARCHAR(120) NOT NULL,
    CodInternaTelefono VARCHAR(3) NOT NULL,
    PRIMARY KEY(IdPerVolInt),
    FOREIGN KEY(idPerVol) REFERENCES PerVoluntario(IdPerVol)
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(IdPersonal) REFERENCES Personal(IdPersonal)
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(IdPersona) REFERENCES Persona(IdPersona)
		ON UPDATE CASCADE ON DELETE CASCADE

   ) ENGINE = InnoDb;

   -- PRUEBA DE CREACIÓN DE INSTANCIAS DE EMPLEADOS

   /** A continuación mostramos el proceso de cómo sería la creación de
    *  un empleado implementando una "falsa" herencia. El proceso es un
    *  poco largo, pero vemos cómo por medio de referencias es posible
    *  realizar una consulta que nos muestre los datos de un empleado
    *  voluntario concreto con sus campos asociados a las tablas
    *  Persona y Personal.
    */

   -- Creamos primero una instancia de Persona

   INSERT INTO Persona
		( Nombre, PrimerApellido, SegundoApellido, Direccion,
        Telefono, Mail )
        VALUES ( "Miguel", "Arias", "Valdemar",
        "C/ Navas de Tolosa, 6 2ºB 23003 Jaén", "696238755",
        "valdemarrules@yahoo.com" );

    -- Consultamos los datos creados, y comprobamos que el IdPersona es 1

    SELECT * FROM Persona;

    -- Creamos una instancia de Personal con los datos concretos y referenciando
	-- a la tabla Persona con el campo IdPersona

    INSERT INTO Personal (IdPersona) VALUES (1);

    -- De esta manera, hemos creado un elemento personal que referencia a la persona
    -- creada anteriormente, con su IdPersonal autogenerado. Vamos a comprobarlo.

    SELECT * FROM Personal JOIN Persona
		WHERE Personal.IdPersona = Persona.IdPersona;

    -- Creamos ahora una instancia de PerVoluntario, referenciando a las tablas anteriores
    -- (solo a la tabla Personal, en realidad) y con sus campos específicos

    INSERT INTO PerVoluntario (IdPersonal, IdPersona, NumHorasVol)
		VALUES(1, 1, 80);

    -- Con esto ya tenemos finalizada la instancia de un empleado voluntario. Si hecemos
    -- una consulta conbinada veremos cómo nos muestra todos los datos correctamente.

    SELECT Personal.IdPersonal AS "Id de Empleado", Persona.PrimerApellido
		AS "Primer Apellido", Persona.SegundoApellido AS "Segundo Apellido",
        Persona.Direccion AS "Dirección", Persona.Telefono AS "Teléfono",
        Persona.mail AS "E-Mail", PerVoluntario.NumHorasVol AS "Horas de Voluntariado"
        FROM Persona INNER JOIN Personal INNER JOIN PerVoluntario
        ON Personal.IdPersona = Persona.IdPersona
        AND PerVoluntario.IdPersonal = Personal.idPersonal;

