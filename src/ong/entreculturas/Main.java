package ong.entreculturas;

import java.util.Scanner;
import ong.dao.DaoXmlOng;

import java.util.Scanner;
import java.io.IOException;

public class Main {

	// Variables de clase

	private static String nombre;
	private static String primerApellido;
	private static String segundoApellido;
	private static Scanner entrada;
	private static Direccion direccionInt;

	public static Direccion getDireccionInt() {
		return direccionInt;
	}

	public static void setDireccionInt(Direccion direccionInt) {
		Main.direccionInt = direccionInt;
	}

	// Método para obtener la información (parcialmente implementado, solo para probar la entrada de datos)

	public static void obtenerDatosPersona() {

		entrada = new Scanner(System.in);

		System.out.print( "Introduzca el nombre de pila: " );
		nombre = entrada.nextLine();
		System.out.print( "\nIntroduzca el primer apellido: " );
		primerApellido = entrada.nextLine();
		System.out.print( "\nIntroduzca el segundo apellido: " );
		segundoApellido = entrada.nextLine();

	} // fin del método obtenerDatosPersona

    public static void main(String[] args) {

    	// Prueba de las clases Persona, Personal PerVoluntario

        ONG ong1 = new DaoXmlOng().getONG();

        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> CIF: " + ong1.getCIF());
        System.out.println("IMPRIMIENDO DESDE INSTANCIA ONG ----> Nombre: " + ong1.getNombre());

        System.out.println( "--- Prueba de la clase Persona y sus subclases" );
        System.out.println( "--- ------------------------------------------\n");
        System.out.println( "--- Personal Voluntario:\n" );

        // Creamos un objeto TipoVia y uno provincia

        TipoVia tipoVia = TipoVia.AVDA;
        Provincia provincia = Provincia.ZAR;

        // Creamos un objeto Direccion, utilizando el tipo de vía y la provincia recién creados

        Direccion direccion = new Direccion( tipoVia, "de Madrid", "192", "6º", "B", "izqda.",
            "50017", provincia, "Zaragoza" );

        // Llamamos al método obtenerDatosPersona

        obtenerDatosPersona();

        // Creamos un objeto PerVoluntario y establecemos sus datos

        PerVoluntario perVoluntario = new PerVoluntario( nombre, primerApellido, segundoApellido, direccion, "876425597",
            "jgimenezmoreno@gmail.com", 68 );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( "\n" + perVoluntario.toString() );

        System.out.println( "\n--- Personal Voluntario Internacional:\n" );

        // Creamos un objeto Direccion, sobreescribiendo el campo de Persona

        setDireccionInt(new Direccion( tipoVia, "de Madrid", "192", "6º", "B",
				"izqda.","50017", provincia, "Zaragoza" ));

        // Creamos un objeto PerVoluntario y establecemos sus datos

        PerVolInternacional perVolInt = new PerVolInternacional( "Michael", "Johnson",
				"Smith", direccion, "555424687",
            "mjohnsonsmith@gmail.com", 42,"Estados Unidos",
            "Park Avenue, 323 - PO BOX: 505423 - New York (USA)", "+34" );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( perVolInt.toString() );



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
