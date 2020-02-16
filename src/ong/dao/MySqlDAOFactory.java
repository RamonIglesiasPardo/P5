package ong.dao;

/** La clase XmlDAOFactory forma parte del patrón Factory.
 *  Extiende a DAOFactory para poder implementar los métodos comunes,
 *  creando aquí las instancias de objetos DAO que utilizan MySQL.
 *
 *  @author Aware Developers
 *  @version 1.0
 * */
public class MySqlDAOFactory extends DAOFactory{

    @Override
    public IOngDAO getOngDAO() {
        return new MySqlOngDAO();
    }

//TODO implementar Factory DAO para Personal

//    @Override
//    public IPersonalDAO getPersonalDAO() {
//        return new MySqlPersonalDAO();
//    }

//TODO implementar Factory DAO para Proyecto

//    @Override
//    public IProyectoDAO getProyectoDAO() {
//        return new MySqlProyectoDAO();
//    }

}
