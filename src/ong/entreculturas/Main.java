package ong.entreculturas;

import ong.entreculturas.Proyecto;

public class Main {

    public static void main(String[] args) {
	Proyecto proyecto;
	proyecto = new Proyecto(1,"Espana", "Madrid" );
        System.out.println(proyecto.getPais());
        System.out.println(proyecto.getLocalizacion());

    }
}
