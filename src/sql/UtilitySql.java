package sql;

import java.sql.*;

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

        //TODO:seguir con los métodos createStatement y ResultQuery

    }

    // Métodos de clase

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
                    + user + pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return miConexion;
    }
}
