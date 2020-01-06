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
