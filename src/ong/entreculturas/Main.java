package ong.entreculturas;

import ong.dao.*;
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
    public static Boolean sourceXML = true;

    public static void main(String[] args) throws SQLException {

        // Precargamos datos existentes desde el XML
        // Creamos una instancia del factory seleccionando XML
        DAOFactory objetoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        // Creamos una instancia DAO XML
        IOngDAO ongDAO = objetoFactory.getOngDAO();
        // Creamos nuestra instancia de ONG
        ong = ongDAO.readOngDAO();
        // Creamos una instancia del menú principal por consola pasándole la instancia ong con los datos del sistema.
        MenusConsola mostrarMenusConsola = new MenusConsola();
        // Abrimos el menú principal
        mostrarMenusConsola.mostrarMenuPrincipal(ong);
        // Guardamos estado actual de la aplicación antes de salir.
        objetoFactory.getOngDAO().createOngDAO(ong);

    } // fin de main


} // fin de la clase Main

//TODO: Eliminar empleados a la lista de empleados.
//TODO: Revisar método crearID en subclases de Personal (¿bien implementado?)
