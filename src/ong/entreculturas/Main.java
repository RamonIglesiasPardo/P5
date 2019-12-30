package ong.entreculturas;

import java.util.Scanner;
import ong.dao.DaoXmlOng;
import ong.entreculturas.TipoVia;
import ong.entreculturas.Provincia;
import ong.entreculturas.Direccion;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    // Variables de clase (eliminadas: no son necesarias)

    public static void main(String[] args) {

        // Prueba de las clases Persona, Personal PerVoluntario

        ONG ong1 = new DaoXmlOng().getONG();

        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> CIF: " + ong1.getCIF());
        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> Nombre: " + ong1.getNombre());

        // Creamos dos objetos empleados sin argumentos

        PerVoluntario vol1 = new PerVoluntario();
        PerVolInternacional vol2 = new PerVolInternacional();

        // Creamos un objeto TipoVia y uno provincia (mejorar para pedir datos)

        TipoVia tipoVia = TipoVia.AVDA;
        Provincia provincia = Provincia.ZAR;

        // Creamos un objeto Direccion, utilizando el tipo de vía y la provincia recién creados
        // (mejorar para pedir datos)

        Direccion direccion = new Direccion(tipoVia, "de Madrid", "192", "6º", "B", "izqda.",
                "50017", provincia, "Zaragoza");


        System.out.println("--- Prueba de la clase Persona y sus subclases");
        System.out.println("--- ------------------------------------------\n");
        System.out.println("--- Personal Voluntario:\n");

        // Llamamos al método introducirDatosPersona (implementado parcialmente)

        vol1.introducirDatosPersona();

        // con esto hemos obtenido los datos básicos: ahora (provisionalmente) introducimos
        // manualmente los datos restantes (que hemos seteado al crear el objeto Direccion)

        vol1.setDireccion(direccion);

        // Obtenemos un String con los datos completos de la persona

        System.out.println("\n" + vol1.toString());


        ////////////////////////////////////////////////////////////////////////


        System.out.println("\n--- Personal Voluntario Internacional:\n");

        // Llamamos al método introducirDatosPersona (implementado parcialmente)

        vol2.introducirDatosPersona();

        // Obtenemos un String con los datos completos de la persona

        System.out.println(vol2.toString());


        // Si os parece, de momento voy a comentar esta parte (da error al compilar, quizá porque ya hay un main
        // antes)

        //public static void main(String[] args) throws IOException {
        //Proyecto proyecto;
        //System.out.println("Introduce el Id de Proyecto: ");
        //Scanner reader = new Scanner(System.in);
        //int id = reader.nextInt();
        //System.out.println("Introduce el pais del Proyecto: ");
        //String pais = reader.next();
        //System.out.println("Introduce la localizacion del Proyecto: ");
        //String localizacion = reader.next();
        //proyecto = new Proyecto(id, pais, localizacion);
        //System.out.println(proyecto.getPais());
        //System.out.println(proyecto.getLocalizacion());

        //Test
        //public void testSetAndGetDescription(id, pais, localizacion){
        //Proyecto proyecto;
        //proyecto = new Proyecto();
        //String testPais = "Pais";
        //assertNull(proyecto.getPais());
        //proyecto.setPais(testPais);
        //assertEquals(testPais, proyecto.getPais());
        //}
        //}
    } // fin de main

} // fin de la clase Main
