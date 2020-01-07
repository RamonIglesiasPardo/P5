package ong.dao;

/**Clase abstracta DAO Factory.
 * Mediante el patrón definido por esta clase añadimos otra capa de abstracción que permitirá declarar diferentes
 * origenes de datos.
 * Estos comparten mismas firmas para los métodos pero las implementaciones en sus respectivos DAO son diferentes.
 *
 * @author Aware Developers
 * @version 1.0
 * */
public abstract class DAOFactory {

    // Listado de objetos DAO soportados por el factory
    public static final int XML = 1;
    public static final int MySQL = 2;

    // En adelante se definen todas las interfaces que contienen los métodos comunes a cualquier objeto DAO
    // que implemente el factory.
    public abstract IOngDAO getOngDAO();
//    public abstract IPersonalDAO getPersonalDAO();
//    public abstract IProyectoDAO getProyectoDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case XML:
                return new XmlDAOFactory();
            case MySQL:
                return null;
                //return new MySQLDAOFactory();
            default:
                return null;
        }
    }
}