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
    static ONG ong = new ONG();

    public static void main(String[] args) throws SQLException {

        // Precargamos datos existentes desde el XML
        // Creamos una instancia del factory seleccionando XML
        DAOFactory objetoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
        // Creamos una instancia DAO XML
        assert objetoFactory != null;
        IOngDAO ongDAO = objetoFactory.getOngDAO();
        // Creamos nuestra instancia de ONG
        ong = ongDAO.readOngDAO();


        //Recorremos personal para insertarlo en la BD MySQL.
        for (int i=0; i <ong.lequipo.size();i++){

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
                telefono = perVolutarioInternacional.getCodInternaTelefono()+" "+perVolutarioInternacional.getTelefono();
                direccion = perVolutarioInternacional.getDir();

            }

            UtilitySql.insertPersonal(nombre, primerApellido, segundoApellido, direccion, telefono, mail);
        }

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
