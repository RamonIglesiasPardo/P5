// PruebaPersona.java
// Archivo de pruebas para la aplicación principal

        package ong.entreculturas;

import ong.entreculturas.TipoVia;
import ong.entreculturas.Provincia;
import ong.entreculturas.Direccion;
import java.util.Scanner;

public class PruebaPersona {

    public static void main( String[] args ) {

        // Creamos dos objetos empleados sin argumentos

        PerVoluntario vol1 = new PerVoluntario();
        PerVolInternacional vol2 = new PerVolInternacional();

        // Creamos un objeto TipoVia y uno provincia (mejorar para pedir datos)

        TipoVia tipoVia = TipoVia.AVDA;
        Provincia provincia = Provincia.ZAR;

        // Creamos un objeto Direccion, utilizando el tipo de vía y la provincia recién creados
        // (mejorar para pedir datos)

        Direccion direccion = new Direccion( tipoVia, "de Madrid", "192", "6º", "B", "izqda.",
                "50017", provincia, "Zaragoza" );


        System.out.println( "--- Prueba de la clase Persona y sus subclases" );
        System.out.println( "--- ------------------------------------------\n");
        System.out.println( "--- Personal Voluntario:\n" );

        // Llamamos al método introducirDatosPersona (implementado parcialmente)

        vol1.introducirDatosPersona();

        // con esto hemos obtenido los datos básicos: ahora (provisionalmente) introducimos
        // manualmente los datos restantes (que hemos seteado al crear el objeto Direccion)

        vol1.setDireccion( direccion );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( "\n" + vol1.toString() );


        ////////////////////////////////////////////////////////////////////////


        System.out.println( "\n--- Personal Voluntario Internacional:\n" );

        // Llamamos al método introducirDatosPersona (implementado parcialmente)

        vol2.introducirDatosPersona();

        // Obtenemos un String con los datos completos de la persona

        System.out.println( vol2.toString() );

    } // fin de main

} // fin de la clase PruebaPersona

