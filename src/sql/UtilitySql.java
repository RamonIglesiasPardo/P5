package sql;

import java.sql.*;
import java.util.Scanner;

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

        System.out.println("Intentando conectarse con los siguientes datos:");
        System.out.println(nuevaConexion.toString());

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
                        "    Mail VARCHAR(32) NOT NULL,\n" +
                        "\n" +
                        "    PRIMARY KEY(IdPersona)\n" +
                        "\n" +
                        ") ENGINE = InnoDB;";

        // Como la sentencia anterior es una sentencia DDL (de definición de datos), llamamos
        // al metodo sentenciaDDL, que nos devolverá true si la sentencia es ejecutada con éxito.

        sentenciaDDL(newConnection, sentenciaSql);
        System.out.println("Sentencia DDL ejecutada con éxito.");

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
        System.out.println("Sentencia DDL ejecutada con éxito.");

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
        System.out.println("Sentencia DDL ejecutada con éxito.");

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
        System.out.println("Sentencia DDL ejecutada con éxito.");

        // Pasaremos ahora a introducir unos pocos registros manualmente, utilizando para ello
        // el método sentenciaDML, que nos servirá para usar sentencias tipo SELECT, INSERT,
        // DELETE o UPDATE. Esto es sólo de prueba, ya que en principio debemos pasar los elementos
        // mediante los XML generados en Java.

        sentenciaSql = "INSERT INTO Persona\n" +
                "\t\t( Nombre, PrimerApellido, SegundoApellido, Direccion,\n" +
                "        Telefono, Mail )\n" +
                "        VALUES ( \"Miguel\", \"Arias\", \"Valdemar\",\n" +
                "        \"C/ Navas de Tolosa, 6 2ºB 23003 Jaén\", \"696238755\",\n" +
                "        \"valdemarrules@yahoo.com\" );";

        sentenciaDML(newConnection, sentenciaSql);
        System.out.println("Sentencia DML ejecutada con éxito.");

        sentenciaSql = "INSERT INTO Personal (IdPersona) VALUES (1);";

        sentenciaDML(newConnection, sentenciaSql);
        System.out.println("Sentencia DML ejecutada con éxito.");

        sentenciaSql = "INSERT INTO PerVoluntario (IdPersonal, IdPersona, NumHorasVol)\n" +
                "\t\tVALUES(1, 1, 80);";

        sentenciaDML(newConnection, sentenciaSql);
        System.out.println("Sentencia DML ejecutada con éxito.");

        // Con esto tenemos creado un registro en varias tablas, que representa a un empleado
        // voluntario de la ONG Entreculturas.

        //TODO: crear método para ejecutar consultas.


    }


        // Métodos de clase

        /**El método conectarBD crea una conexión con los datos establecidos para un
         * objeto Conexion.
         *
         * @param miConexion Objeto Conexion con datos sobre la conexión a la BD
         * @return Objeto Connection con la conexión a la BD establecida.
         */

        public Connection conectarBD (Conexion miConexion){

            Connection newConnection = null;

            try {
                newConnection = DriverManager.getConnection("jdbc:mysql://" + miConexion.getHost()
                                + ":" + miConexion.getPuerto() + "/" + miConexion.getNombreBD()
                                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                        , miConexion.getUser(), miConexion.getPass());
            } catch (SQLException e) {
                System.out.println("Error al conectar con la base de datos.");
                e.printStackTrace();
            } finally {
                System.out.println("Conexión establecida.");
            }

            return newConnection;
        }

    /**El método sentencia DDL nos vale para ejecutar sentencias tipo
     * CREATE, DROP, ALTER, en tablas, vistas e índices SQL.
     *
     * @param newConnection Objeto Connection con una conexión a la BD establecida
     * @param sentencia String con la sentencia a ejecutar
     */

    public static void sentenciaDDL (Connection newConnection, String sentencia){

            // Creamos un objeto Statement
            Statement newStatement = null;

            try {
                newStatement = newConnection.createStatement();
                System.out.println("Statement creado con éxito.");
            } catch (SQLException e) {
                System.out.println("Error al crear el Statement.");
                e.printStackTrace();
            }
            // Como la sentencia que queremos usar es para crear una tabla, debemos usar el método
            // execute(String sentenciaSql), que devuelve un booleano.

            Boolean resultado = false;

            try {
                resultado = newStatement.execute(sentencia);
                System.out.println("Sentencia SQL ejecutada con éxito.");
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la sentencia SQL.");
                e.printStackTrace();
            }
        }

    public static int sentenciaDML (Connection newConnection, String sentencia){

        // Creamos un objeto Statement
        Statement newStatement = null;

        try {
            newStatement = newConnection.createStatement();
            System.out.println("Statement creado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al crear el Statement.");
            e.printStackTrace();
        }
        // Como la sentencia que queremos usar es para modificar una tabla,
        // debemos usar el método executeUpdate(String sentenciaSql), que devuelve un int.

        int resultado = 0;

        try {
            resultado = newStatement.executeUpdate(sentencia);
            System.out.println("Sentencia SQL ejecutada con éxito.");
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }
         return 0;
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
        this.host = "localhost";
        this.puerto = "3306";
        this.nombreBD = "Entreculturas";
        this.user = "root";
        this.pass = "";
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

