package ong.entreculturas;

import ong.entreculturas.TipoVia;
import ong.entreculturas.Provincia;
import ong.entreculturas.Direccion;

public class Main {

    public static void main(String[] args) {
	
        // Prueba de las clases Persona, Personal PerVoluntario

        System.out.println( "--- Prueba de la clase Persona y sus subclases\n\n" );
        System.out.println( "--- Personal Voluntario:\n" );

        // Creamos un objeto TipoVia y uno provincia

        TipoVia tipoVia = TipoVia.AVDA;
        Provincia provincia = Provincia.ZAR;

        // Creamos un objeto Direccion, utilizando el tipo de vía y la provincia recién creados

        Direccion direccion = new Direccion( tipoVia, "de Madrid", "192", "6º", "B", "izqda.", 
            "50017", provincia, "Zaragoza" );

        // Creamos un objeto PerVoluntario y establecemos sus datos

        PerVoluntario perVoluntario = new PerVoluntario( "Jacinto", "Giménez", "Moreno", direccion, "876425597", 
            "jgimenezmoreno@gmail.com", "101500045611", 1, 1, 68 );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( perVoluntario.toString() );

        System.out.println( "\n--- Personal Voluntario Internacional:\n" );

        // Creamos un objeto Direccion, sobreescribiendo el campo de Persona

        Direccion direccionInt = new Direccion( tipoVia, "de Madrid", "192", "6º", "B", "izqda.", 
            "50017", provincia, "Zaragoza" );

        // Creamos un objeto PerVoluntario y establecemos sus datos

        PerVolInternacional perVolInt = new PerVolInternacional( "Michael", "Johnson", "Smith", direccion, "555424687", 
            "mjohnsonsmith@gmail.com", "101501047821", 1, 1, 42, 1, "Estados Unidos",
            "Park Avenue, 323 - PO BOX: 505423 - New York (USA)", "+34" );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( perVolInt.toString() );
        
        

    }

}
