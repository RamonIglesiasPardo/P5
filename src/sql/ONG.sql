
  /** Aquí el código SQL utilizado para crear la Base de Datos externa
   *  y sus tablas.
   */

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