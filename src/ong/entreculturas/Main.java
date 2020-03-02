package ong.entreculturas;

import ong.dao.*;
import org.w3c.dom.ls.LSOutput;
import sql.UtilitySql;

import java.sql.SQLException;

/**
 * Clase principal de la aplicación.
 *
 * @author Aware Developers
 */

public class Main {

    //Declaramos e instanciamos ONG, ya que contendrá toda las otras instancias de la aplicación.
    public static ONG ong = new ONG();
    public enum sourceType {XML, MySQL};
    public static sourceType sourceSelected = sourceType.XML;
    // Por defecto, al iniciar el programa, precargamos siempre los datos existentes en el XML.
    // Para ello creamos una instancia del factory seleccionando la opción XML
    public static DAOFactory objetoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);

    public static void main(String[] args) throws SQLException {


        // A continuación, creamos una instancia DAO XML
        IOngDAO ongDAO = objetoFactory.getOngDAO();
        // Y finalmente creamos nuestra instancia de ONG
        ong = ongDAO.readOngDAO();
        // En este punto creamos una instancia del menú principal en consola pasándole la instancia ong
        // con los datos del sistema.
        MenusConsola mostrarMenusConsola = new MenusConsola();
        mostrarMenusConsola.mostrarMenuPrincipal(ong);
        // Guardamos estado actual de la aplicación antes de salir.
        objetoFactory.getOngDAO().createOngDAO(ong);

    } // fin de main

} // fin de la clase Main

