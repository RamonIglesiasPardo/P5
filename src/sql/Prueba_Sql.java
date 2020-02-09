package sql;

import java.sql.*;

public class Prueba_Sql {

    public static void main(String[] args) {

        try {

            //1.Creamos una conexion a la base de datos mediante un objeto Connection

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://192.168.168.111:3306/entreculturas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "Qs122prt@34");

            //2.Creamos un objeto Statement, para poder crear una sentencia después

            Statement miStatement = miConexion.createStatement();

            //3.Creamos un objeto ResultSet para ejecutar una sentencia SQL utilizando el método executeQuery()

            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM Personal;");

            //4.Utilizamos un ciclo while para mostrar los campos indicados mediante el método getString()

            while (miResultSet.next()) {


                System.out.println(miResultSet.getString("idPersonal") + " - " +
                        miResultSet.getString("segundoApellido") + " " + miResultSet.getString("primerApellido") + ", " +
                        miResultSet.getString("nombre") );
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar la consulta.");
            e.printStackTrace();
        }

    }

}
