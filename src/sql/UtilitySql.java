package sql;

import ong.entreculturas.ONG;
import ong.entreculturas.PerVolInternacional;

import java.sql.*;
import java.util.*;

import static java.lang.System.*;

/**La clse UtilitySql contiene todos los métodos necesarios para realizar operaciones
 * desde Java sobre una base de datos, incluyendo la conexión inicial con la BD.
 *
 * @author Aware Developers
 * @version 1.2
 *
 */

public class UtilitySql {
    //Variables de clase
    //Ub objeto Conexion que llamará a los métodos deseados.
    Conexion miConexion;

    //Constructores
    public UtilitySql() {
    }

    public UtilitySql(Conexion miConexion) {
        this.miConexion = miConexion;
    }

    //Getters y Setters
    public Conexion getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Conexion miConexion) {
        this.miConexion = miConexion;
    }

    // Método main de prueba

    public static void main(String[] args) {

        // Creamos un objeto UtilitySql y un objeto ConexionBaseDeDatos.
        // Al usar el constructor por defecto de ConexionBaseDeDatos que hemos implementado,
        // se nos creará un objeto ConexionBaseDeDatos con los datos de conexión adecuados
        // para nuestro ejemplo.

        Conexion nuevaConexion = new Conexion();
        UtilitySql sesionSql = new UtilitySql(nuevaConexion);

        // Comprobamos que los datos son los que esperábamos.

        out.println("Intentando conectarse con los siguientes datos:");
        out.println(nuevaConexion.toString());

        // Ahora llamamos al método conectarBD con miConexion como parámetro para efectivamente
        //conectar con la base de datos deseada.

        Connection newConnection = sesionSql.conectarBD(nuevaConexion);

        // Vamos a definir una sentencia SQL que utilizaremos a continuación. En este caso,
        // creamos la tabla Persona.

        String sentenciaSql =
                "CREATE TABLE IF NOT EXISTS Persona (\n" +
                        "\n" +
                        "\tIdPersona INT(6) NOT NULL AUTO_INCREMENT,\n" +
                        "    Nombre VARCHAR(16) NOT NULL,\n" +
                        "    PrimerApellido VARCHAR(16) NOT NULL,\n" +
                        "    SegundoApellido VARCHAR(16) NOT NULL,Direccion VARCHAR(128) NOT NULL,\n" +
                        "    Telefono VARCHAR(12) NOT NULL,\n" +
                        "    Mail VARCHAR(32),\n" +
                        "\n" +
                        "    PRIMARY KEY(IdPersona)\n" +
                        "\n" +
                        ") ENGINE = InnoDB;";

        // Como la sentencia anterior es una sentencia DDL (de definición de datos), llamamos
        // al metodo sentenciaDDL, que nos devolverá true si la sentencia es ejecutada con éxito.

        sentenciaDDL(newConnection, sentenciaSql);
        out.println("Sentencia DDL ejecutada con éxito.");

        // Pasamos pues, tras haber comprobado que lo anterior ha funcionado correctamente, a crear
        // el resto de tablas simplemente modificando la sentencia y volviendo a llamar al método
        // sentenciaDDL()

        sentenciaSql = "CREATE TABLE IF NOT EXISTS Personal (\n" +
                "\n" +
                "\tIdPersonal INT(4) NOT NULL AUTO_INCREMENT,\n" +
                "    IdPersona INT(6) NOT NULL,\n" +
                "    \n" +
                "    PRIMARY KEY(IdPersonal),\n" +
                "    FOREIGN KEY(IdPersona) REFERENCES Persona(IdPersona)\n" +
                "\t\tON UPDATE CASCADE ON DELETE CASCADE\n" +
                "\n" +
                ") ENGINE = InnoDb;";
        sentenciaDDL(newConnection, sentenciaSql);
        out.println("Sentencia DDL ejecutada con éxito.");

        sentenciaSql = " CREATE TABLE IF NOT EXISTS PerVoluntario (\n" +
                "\n" +
                "\tIdPerVol INT(4) NOT NULL AUTO_INCREMENT,\n" +
                "    IdPersonal INT(4) NOT NULL,\n" +
                "    IdPersona INT(6) NOT NULL,\n" +
                "    NumHorasVol INT(4) NULL DEFAULT 0,\n" +
                "    PRIMARY KEY(IdPerVol),\n" +
                "    FOREIGN KEY(IdPersonal) REFERENCES Personal(IdPersonal)\n" +
                "\t\tON UPDATE CASCADE ON DELETE CASCADE,\n" +
                "\tFOREIGN KEY(IdPersona) REFERENCES Persona(IdPersona)\n" +
                "\t\tON UPDATE CASCADE ON DELETE CASCADE\n" +
                "\n" +
                "   ) ENGINE = InnoDB;";

        sentenciaDDL(newConnection, sentenciaSql);
        out.println("Sentencia DDL ejecutada con éxito.");

        sentenciaSql = "CREATE TABLE IF NOT EXISTS PerVolInternacional (\n" +
                "\n" +
                "\tIdPerVolInt INT(4) NOT NULL AUTO_INCREMENT,\n" +
                "    idPerVol INT(4) NOT NULL,\n" +
                "    IdPersonal INT(4) NOT NULL,\n" +
                "    IdPersona INT(6) NOT NULL,\n" +
                "    PaisOrigen VARCHAR(16) NOT NULL,\n" +
                "    -- Campo para la direccion internacional\n" +
                "    SDireccion VARCHAR(120) NOT NULL,\n" +
                "    CodInternaTelefono VARCHAR(3) NOT NULL,\n" +
                "    PRIMARY KEY(IdPerVolInt),\n" +
                "    FOREIGN KEY(idPerVol) REFERENCES PerVoluntario(IdPerVol)\n" +
                "\t\tON UPDATE CASCADE ON DELETE CASCADE,\n" +
                "\tFOREIGN KEY(IdPersonal) REFERENCES Personal(IdPersonal)\n" +
                "\t\tON UPDATE CASCADE ON DELETE CASCADE,\n" +
                "\tFOREIGN KEY(IdPersona) REFERENCES Persona(IdPersona)\n" +
                "\t\tON UPDATE CASCADE ON DELETE CASCADE\n" +
                "\n" +
                "   ) ENGINE = InnoDb;";

        sentenciaDDL(newConnection, sentenciaSql);
        out.println("Sentencia DDL ejecutada con éxito.");

        //Creamos un stored procedure que permitirá operaciones tipo CRUD con la tabla personal
        sentenciaSql =
                "/* Vamos a crear un Procedimiento Almacenado con varios parámetros de entrada (IN) \n" +
                "Su funcionalidad es ejecutar operaciones CRUD, en la tabla Personal, en función del último parámetro facilitado*/\n" +
                "CREATE PROCEDURE crud_personal(\n" +
                "IN paramIdPersona INT, \n" +
                "IN paramNombre VARCHAR(16),\n" +
                "IN paramPrimerApellido VARCHAR(16),\n" +
                "IN paramSegundoApellido VARCHAR(16),\n" +
                "IN paramDireccion VARCHAR(128),\n" +
                "IN paramTelefono VARCHAR(12),\n" +
                "IN paramMail VARCHAR(32),\n" +
                "IN accion CHAR(6)\n" +
                ")\n" +
                "BEGIN\n" +
                "    CASE accion\n" +
                "    WHEN 'create' THEN\n" +
                "\t\tINSERT INTO Entreculturas.Persona(Nombre, PrimerApellido, SegundoApellido, Direccion, Telefono, Mail)\n" +
                "\t\tVALUES(paramNombre, paramPrimerApellido, paramSegundoApellido, paramDireccion, paramTelefono, paramMail);\n" +
                "\tWHEN 'read' THEN\n" +
                "\t\tSELECT * FROM Entreculturas.Persona\n" +
                "        WHERE IdPersona=paramIdPersona;    \n" +
                "\tWHEN 'update' THEN\n" +
                "        UPDATE Entreculturas.Persona \n" +
                "        SET Nombre=paramNombre, PrimerApellido=paramPrimerApellido, SegundoApellido=paramSegundoApellido, Direccion=paramDireccion, Telefono=paramTelefono, Mail=paramMail\n" +
                "\t\tWHERE IdPersona=paramIdPersona;\n" +
                "\tWHEN 'delete' THEN\n" +
                "        DELETE FROM Entreculturas.Persona \n" +
                "        WHERE IdPersona=paramIdPersona;\n" +
                "\tELSE\n" +
                "\t\tSIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Buhhh!! Tan solo se permiten las opciones CRUD: Create, Read, Update o Delete :(';\n" +
                "\tEND CASE;\n" +
                "END;";

        sentenciaDDL(newConnection, sentenciaSql);
        out.println("Sentencia DDL ejecutada con éxito.");

        // Pasaremos ahora a introducir unos pocos registros manualmente, utilizando para ello
        // el método sentenciaDML, que nos servirá para usar sentencias tipo SELECT, INSERT,
        // DELETE o UPDATE. Esto es sólo de prueba, ya que en principio debemos pasar los elementos
        // mediante los XML generados en Java.

        sentenciaSql = "INSERT INTO Persona\n" +
                "\t\t( Nombre, PrimerApellido, SegundoApellido, Direccion,\n" +
                "        Telefono, Mail )\n" +
                "        VALUES ( \"Rosa\", \"Giménez\", \"Villar\",\n" +
                "        \"C/ Terminillo, 12 4ºC 50017 Zaragiza\", \"674988745\",\n" +
                "        \"rosagv@gmail.com\" );";

        sentenciaDML(newConnection, sentenciaSql);
        out.println("Sentencia DML ejecutada con éxito.");

        sentenciaSql = "INSERT INTO Personal (IdPersona) VALUES (1);";

        sentenciaDML(newConnection, sentenciaSql);
        out.println("Sentencia DML ejecutada con éxito.");

        sentenciaSql = "INSERT INTO PerVoluntario (IdPersonal, IdPersona, NumHorasVol)\n" +
                "\t\tVALUES(1, 1, 60);";

        sentenciaDML(newConnection, sentenciaSql);
        out.println("Sentencia DML ejecutada con éxito.");

        // Creamos otro empleado más

        sentenciaSql = "INSERT INTO Persona\n" +
                "\t\t( Nombre, PrimerApellido, SegundoApellido, Direccion,\n" +
                "        Telefono, Mail )\n" +
                "        VALUES ( \"Miguel\", \"Arias\", \"Valdemar\",\n" +
                "        \"C/ Navas de Tolosa, 6 2ºB 23003 Jaén\", \"696238755\",\n" +
                "        \"valdemarrules@yahoo.com\" );";

        sentenciaDML(newConnection, sentenciaSql);
        out.println("Sentencia DML ejecutada con éxito.");

        sentenciaSql = "INSERT INTO Personal (IdPersona) VALUES (2);";

        sentenciaDML(newConnection, sentenciaSql);
        out.println("Sentencia DML ejecutada con éxito.");

        sentenciaSql = "INSERT INTO PerVoluntario (IdPersonal, IdPersona, NumHorasVol)\n" +
                "\t\tVALUES(2, 2, 80);";

        sentenciaDML(newConnection, sentenciaSql);
        out.println("Sentencia DML ejecutada con éxito.");

        // Con esto tenemos creado un registro en varias tablas, que representa a un empleado
        // voluntario de la ONG Entreculturas.

        //Vamos a probar a hacer una consulta. Creamos una nueva sentencia, para seleccionar
        //campos de las tablas involucradas

        sentenciaSql = "SELECT E.IdPersonal, P.PrimerApellido, P.SegundoApellido," +
                " P.Nombre FROM Persona AS P INNER JOIN Personal AS E" +
                " ON P.IdPersona = E.IdPersona;";

        // Pasamos la sentencia y la conexión ya creada que venimos utilizando al nuevo método
        // sentenciaSELECT

        ResultSet newResultSet = (sentenciaSELECT(newConnection, sentenciaSql));
        out.println("Consulta SQL ejecutada con éxito. Listo para mostrar datos.");

        // Vamos a comprobar si el ResultSet es Válido.

        consultaBD(newConnection, newResultSet);


    }


    // Métodos de clase

    /**
     * El método conectarBD crea una conexión con los datos establecidos para un
     * objeto Conexion.
     *
     * @param miConexion Objeto Conexion con datos sobre la conexión a la BD
     * @return Objeto Connection con la conexión a la BD establecida.
     */

    public Connection conectarBD(Conexion miConexion) {

        Connection newConnection = null;

        try {
            newConnection = DriverManager.getConnection("jdbc:mysql://" + miConexion.getHost()
                            + ":" + miConexion.getPuerto() + "/" + miConexion.getNombreBD()
                            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , miConexion.getUser(), miConexion.getPass());
        } catch (SQLException e) {
            out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        } finally {
            out.println("Conexión establecida.");
        }

        return newConnection;
    }

    /**
     * El método sentencia DDL nos vale para ejecutar sentencias tipo
     * CREATE, DROP, ALTER, en tablas, vistas e índices SQL.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia     String con la sentencia a ejecutar
     */

    public static void sentenciaDDL(Connection newConnection, String sentencia) {

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para crear una tabla, debemos usar el método
        // execute(String sentenciaSql), que devuelve un booleano.

        Boolean resultado = false;

        try {
            resultado = newStatement.execute(sentencia);
            out.println("Sentencia SQL ejecutada con éxito.");
        } catch (SQLException e) {
            out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
    }

    /**
     * El método sentencia DML nos sirve para ejecutar sentencias SQL de tipo INSERT, DELETE o
     * UPDATE. Para las consultas tipo SELECT utilizaremos el método sentenciaSELECT.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia     String con la sentencia a ejecutar
     * @return int para determinar el resultado positivo o negativo
     */

    public static int sentenciaDML(Connection newConnection, String sentencia) {

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para modificar una tabla,
        // debemos usar el método executeUpdate(String sentenciaSql), que devuelve un int.

        int resultado = 0;

        try {
            resultado = newStatement.executeUpdate(sentencia);
            out.println("Sentencia SQL ejecutada con éxito.");
            return resultado;
        } catch (SQLException e) {
            out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * El método sentencia SELECT devuelve un objeto ResultSet con el resultado de
     * una sentencia SQL de tipo SELECT. No muestra los resultados.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia     String con la sentencia a ejecutar
     * @return Objeto ResultSet con el resultado de una consulta SELECT
     */

    public static ResultSet sentenciaSELECT(Connection newConnection, String sentencia) {

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para modificar una tabla,
        // debemos usar el método executeUpdate(String sentenciaSql), que devuelve un int.

        ResultSet newResultSet = null;

        try {
            newResultSet = newStatement.executeQuery(sentencia);
            out.println("Sentencia SQL ejecutada con éxito.");
            return newResultSet;
        } catch (SQLException e) {
            out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
        return null;

    }

    public static void consultaBD(Connection newConnection, ResultSet newResultSet) {

        Scanner entrada = new Scanner(in);
        out.print("¿Número de campos a mostrar? ");
        int numCampos = entrada.nextInt();

        // Creamos un array de Strings con el número de elementos indicado para almacenar
        // el nombre de los campos a mostrar, que se nos preguntarán y se almacenarán
        // a continuación

        String lCampos[] = new String[numCampos];
        Scanner nuevaEntrada = new Scanner(System.in);
        for (int i = 1; i <= (numCampos); i++) {

            System.out.printf("Campo %d: ", i);
            lCampos[i - 1] = nuevaEntrada.nextLine();
        }

        // Con dos ciclos  for y while anidados, por cada campo y mientras queden registros en la tabla
        // se irań mostrando en pantalla.

            while (true) {
                try {
                    if (!newResultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i <= (numCampos - 1); i++) {

                    try {
                        System.out.print(newResultSet.getString(lCampos[i]));
                        System.out.print("  ");
                    } catch (SQLException e) {
                        out.println("Error al mostrar la consulta.");
                        e.printStackTrace();
                    }
                }

                System.out.println("");

            }

    }

    public static void cargarDatos(ONG ong) throws SQLException  {

        //Recorremos personal para insertarlo en la BD MySQL.
        for (int i = 0; i < ong.lequipo.size(); i++) {

            String nombre, primerApellido, segundoApellido, direccion, telefono, mail;

            nombre = ong.lequipo.get(i).getNombre();
            primerApellido = ong.lequipo.get(i).getPrimerApellido();
            segundoApellido = ong.lequipo.get(i).getSegundoApellido();
            mail = ong.lequipo.get(i).getMail();

            //En función de que sea personal internacional o nacional tabla destino y campos varian
            if (!(ong.lequipo.get(i) instanceof PerVolInternacional)) {

                telefono = ong.lequipo.get(i).getTelefono();
                direccion = ong.lequipo.get(i).getDireccion().toString();

            } else {

                PerVolInternacional perVolutarioInternacional = (PerVolInternacional) ong.lequipo.get(i);
                telefono = perVolutarioInternacional.getCodInternaTelefono() + " " + perVolutarioInternacional.getTelefono();
                direccion = perVolutarioInternacional.getDir();

            }

            UtilitySql.insertPersonal(nombre, primerApellido, segundoApellido, direccion, telefono, mail);
        }
    }
    public static void insertPersonal (String nombre, String primerApellido, String segundoApellido, String direccion,
                                       String telefono, String mail) throws SQLException {

            Conexion nuevaConexion = new Conexion();
            UtilitySql sesionSql = new UtilitySql(nuevaConexion);

            // Comprobamos que los datos son los que esperábamos.

            out.println("Intentando conectarse con los siguientes datos:");
            out.println(nuevaConexion.toString());

            // Ahora llamamos al método conectarBD con miConexion como parámetro para efectivamente
            //conectar con la base de datos deseada.

            Connection newConnection = sesionSql.conectarBD(nuevaConexion);

            String sentenciaSql = "CALL Entreculturas.crud_personal( null,?,?,?,?,?,?, 'create');";

            PreparedStatement ps = newConnection.prepareStatement(sentenciaSql);
            ps.setString(1, nombre);
            ps.setString(2, primerApellido);
            ps.setString(3, segundoApellido);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, mail);

            ps.executeUpdate();
            out.println("Sentencia DML ejecutada con éxito. Se ha insertado: "
                    + nombre + " " + primerApellido + " " + segundoApellido + " " + direccion + " " + telefono + " " + mail);

    }
}



/**
 * Se incluye la clase Conexion, que utilizará la clase UtilitySql.
 */

class Conexion {

    //Variables de clase

    private String host;
    private String puerto;
    private String nombreBD;
    private String user;
    private String pass;

    //Constructores
    //Al llamar al constructor por defecto, le pasaremos automáticamente unos datos
    //de conexión prefijados

    public Conexion() {
        this.host = "192.168.168.111";
        this.puerto = "3306";
        this.nombreBD = "Entreculturas";
        this.user = "root";
        this.pass = "Qs122prt@34";
    }

    public Conexion(String host, String puerto, String nombreBD, String user, String pass) {
        this.host = host;
        this.puerto = puerto;
        this.nombreBD = nombreBD;
        this.user = user;
        this.pass = pass;
    }

    //Getters y Setters
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString() {

        return String.format("Host: %s - Puerto: %s\nBase de Datos: %s - Usuario: %s.",
                host, puerto, nombreBD, user);

    }
}

