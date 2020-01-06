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
public class DaoXmlOng implements IDaoOng {


    @Override
    public ONG getONG() {
        return new XmlController().getXMLONG();
    }

    @Override
    public void setONG(ONG pONG) {

    }

    @Override
    public boolean update(ONG pONG) {
        return false;
    }

    @Override
    public boolean remove(ONG pONG) {
        return false;
    }
}
