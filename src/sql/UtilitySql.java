package sql;

import java.sql.*;
import java.util.*;

/**La clse UtilitySql contiene todos los métodos necesarios para realizar operaciones
 * desde Java sonbre una base de datos.
 *
 * @author Aware Developers
 * @version 1.0
 *
 */

public class UtilitySql {

    private static String host = "localhost";
    private static int puerto = 3306;
    private static String nombreBD = "Entreculturas";
    private static String user = "root";
    private static String pass = "";

    public static void main(String[] args) {

        // Llamamos al método conexionBD para conectar con la base de datos, con
        // los argumentos: host = localhost; puerto = 3306; nombreBD = Entreculturas
        // user = root; pass = ""

        Connection connection = conexionBD(host, puerto, nombreBD, user, pass);

        //Llamamos al método ejecutarSentenciaSql con la sentencia deseada como parámetro.
        //Si quisiéramos preguntar la sentencia a ejecutar, llamaríamos al método
        //preguntarSentenciaSql

        //Aquí la llamada a preguntarSentenciaSql
        //String sentenciaSql = preguntarSentenciaSql();
        //En este caso, para ejemplo, la incrustamos:
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
        try {
            ResultSet newResultSet = ejecutarSentenciaSql(connection, sentenciaSql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }

        //Podemos comprobar en la BD que se ha creado la tabla.

        //TODO:seguir con el método ResultQuery

    }

    // Métodos de clase

    /**Establece una conexión con una base de datos.
     *
     * @param pHost String con el nombre de host o la IP
     * @param pPuerto int con el número de puerto para establecer la conexión con la BD
     * @param pNombreBD String con el nombre de la BD a conectar
     * @param pUser String con el nombre de usuario de la BD
     * @param pPass String con el password del usuario anterior
     * @return Objeto Connection con una conexión establecida
     */

    public static Connection conexionBD(String pHost, int pPuerto, String pNombreBD, String pUser, String pPass) {

        host = pHost;
        puerto = pPuerto;
        nombreBD = pNombreBD;
        user = pUser;
        pass = pPass;

        //Creamos una conexión a la base de datos mediante un objeto Connection

        Connection miConexion = null;
        try {
            miConexion = DriverManager.getConnection("jdbc:mysql://" + host
                    + ":" + puerto + "/" + nombreBD
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return miConexion;
    }

    /**Ejecuta una consulta determinada por el usuario sobre una BD conectada.
     *
     * @param conexion Objeto Connection con conexión establecida a una BD
     * @param pSentencia String con la sentencia Sql deseada
     * @return Objeto ResultSet con el resultado (so lo hay) de la sentencia Sql
     * @throws SQLException
     */

    public static ResultSet ejecutarSentenciaSql(Connection conexion, String pSentencia) throws SQLException {

        String sentencia = pSentencia;
        Connection miConexion = conexion;
        Statement miStatement = miConexion.createStatement();
        ResultSet miResultSet = miStatement.executeQuery(sentencia);
        return miResultSet;

    }

    /**Pregunta al usuario por la sentencia Sql a ejecutar.
     *
     * @return String con la sentencia Sql
     */

    public static String preguntarSentenciaSql() {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca la sentencia Sql a ejecutar\n>>> ");
        return entrada.nextLine();

    }
}
