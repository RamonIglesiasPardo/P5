package ong.dao;

import ong.entreculturas.ONG;

/** Aquí declaramos todos los métodos que nuestros objetos ONG DAO deberán soportar
 *  En nuestro caso nos limitamos a declarar los típicos métodos CRUD.
 *
 *  @author Aware Developers
 *  @version 1.0
 */
public interface IOngDAO {

    void createOngDAO(ONG pONG);
    ONG readOngDAO();
    boolean updateOngDAO(ONG pONG);
    boolean deleteOngDAO(ONG pONG);
}
