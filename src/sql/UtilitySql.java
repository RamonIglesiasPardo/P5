package sql;

import java.sql.*;
import java.util.Scanner;


/**La clse UtilitySql contiene todos los métodos necesarios para realizar operaciones
 * desde Java sobre una base de datos, incluyendo la conexión inicial con la BD.
 *
 * @author Aware Developers
 * @version 1.1
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

    //Método main de prueba

    public static void main(String[] args) {

        //Para crear una conexión a nuestra base de datos, tenemos dos opciones:
        //1 - Crear un objeto conexión llamando al constructor por defecto (lo cual
        // nos dará los datos de conexión por defecto)

        Conexion miConexion = new Conexion();

        //2- Llamar al método setDatosConexion para que nos pregunte dichos datos. En cualquier caso
        //necesitamos tanto un objeto Conexion como un objeto UtilitySql, al que pasaremos como
        //parámetro el oibjeto Conexion.

        UtilitySql sesionSql = new UtilitySql(miConexion);

        // Así tendríamos los datos de la conexión por defecto, pero vamos a introducirlos de nuevo:
        // NOTA: comentar la siguiente línea si se quieren usar los datos por defecto

        sesionSql.setDatosConexion(miConexion);

        // Ahora llamamos al método conectarBD con miConexion como parámetro para efectivamente
        //conectar con la base de datos deseada.

        Connection nuevaConexion = sesionSql.conectarBD(miConexion);

        //Pasamos a llamar al método que establecerá y ejecutará la consulta.

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
            ResultSet newResultSet = ejecutarSentenciaSql(nuevaConexion, sentenciaSql);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la sentencia SQL.");
            e.printStackTrace();
        }

        //Podemos comprobar en la BD que se ha creado la tabla.

        //TODO:seguir con el método ResultQuery

    }


    //Métodos de clase

    public void setDatosConexion(Conexion miConexion) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca el nombre o la IP del host: ");
        miConexion.setHost(entrada.nextLine());
        System.out.print("Introduzca el puerto para la conexión: ");
        miConexion.setPuerto(entrada.nextInt());
        System.out.print("Introduzca el nombre de la Base de Datos a conectar: ");
        miConexion.setNombreBD(entrada.nextLine());
        System.out.print("Introduzca el nombre de usuario: ");
        miConexion.setUser(entrada.nextLine());
        System.out.print("Introduzca la contraseña: ");
        miConexion.setPass(entrada.nextLine());

    }

    public Connection conectarBD(Conexion miConexion) {

        Connection newConnection = null;

        try {
            newConnection = DriverManager.getConnection("jdbc:mysql://" + miConexion.getHost()
                            + ":" + miConexion.getPuerto() + "/" + miConexion.getNombreBD()
                            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , miConexion.getUser(), miConexion.getPass());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newConnection;

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

/**Se incluye la clase Conexion, que utilizará la clase UtilitySql.
 *
 */

class Conexion {

    //Variables de clase

    private String host;
    private int puerto;
    private String nombreBD;
    private String user;
    private String pass;

    //Constructores

    //Al llamar al constructor por defecto, le pasaremos automáticamente unos datos
    //de conexión prefijados

    public Conexion() {
        this.host = "localhost";
        this.puerto = 3306;
        this.nombreBD = "Entreculturas";
        this.user = "root";
        this.pass = "";
    }

    public Conexion(String host, int puerto, String nombreBD, String user, String pass) {
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

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
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
}
