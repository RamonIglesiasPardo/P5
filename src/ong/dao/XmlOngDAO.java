package ong.dao;

import ong.entreculturas.ONG;

/** En XmlOngDAO forma parte del patrón DAO.
 *  Permite separar la lógica para la persistencia de la lógica del negocio.
 *
 *  XmlOngDAO implementa la interfaz IOngDAO que declara los métodos que de deberán implementar
 *  todas las instancias DAO ONG, ya sean XmlOngDAO o MySQLDAO.
 *
 *  En el caso de XmlOngDAO se implementa toda la lógica necesaria para que ONG trabaje con XML,
 *  tan solo implementamos los métodos básicos CRUD (Create, Read, Update y Delete).
 *
 *  @author Aware Developers
 *  @version 1.0
 * */
public class XmlOngDAO implements IOngDAO {

       public XmlOngDAO() {

              //Implementación de la lógica
              //Inicialización
       }

       @Override
       public void createOngDAO(ONG pONG) {

              //Implementación de la lógica
              //Crea una nueva instancia de ONG.

       }

       @Override
       public ONG readOngDAO() {

              //Implementación de la lógica
              //Devuelve la instancia de ONG.

              return null;
       }

       @Override
       public boolean updateOngDAO(ONG pONG) {

              //Implementación de la lógica
              //Modifica la instancia de ONG.
              //Devuelve false si no se ha podido modificar los datos.

              return false;
       }

       @Override
       public boolean deleteOngDAO(ONG pONG) {

              //Implementación de la lógica
              //Elimina la instancia de ONG.
              //Devuelve false si no se ha podido eliminar los datos.

              return false;
       }
}
