/**
 *
 *
 *
 *
 *
 *  TODO Eliminarla. aunque primero debemos acabar con el DAO Factory y JABX.
 *
 *
 *
 *
 *

 * */

package ong.dao;

import ong.entreculturas.ONG;

/**
 * Pruebas utilizando patrón DAO y presistencia en XML
 * */
public interface IDaoOng {

    ONG getONG();
    void setONG(ONG pONG);
    boolean update(ONG pONG);
    boolean remove(ONG pONG);

}
