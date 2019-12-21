package ong.entreculturas;

import ong.dao.DaoXmlOng;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ONG ong1 = new DaoXmlOng().getONG();

        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> CIF: " + ong1.getCIF());
        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> Nombre: " + ong1.getNombre());

    }
}

