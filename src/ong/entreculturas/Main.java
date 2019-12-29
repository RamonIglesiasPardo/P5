package ong.entreculturas;

import ong.entreculturas.Proyecto;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Proyecto proyecto;
        System.out.println("Introduce el Id de Proyecto: ");
        Scanner reader = new Scanner(System.in);
        int id = reader.nextInt();
        System.out.println("Introduce el pais del Proyecto: ");
        String pais = reader.next();
        System.out.println("Introduce la localizacion del Proyecto: ");
        String localizacion = reader.next();
        proyecto = new Proyecto(id, pais, localizacion);
        System.out.println(proyecto.getPais());
        System.out.println(proyecto.getLocalizacion());

        //Test
        public void testSetAndGetDescription(id, pais, localizacion){
            Proyecto proyecto;
            proyecto = new Proyecto();
            String testPais = "Pais";
            assertNull(proyecto.getPais());
            proyecto.setPais(testPais);
            assertEquals(testPais, proyecto.getPais());
        }
    }
    }

