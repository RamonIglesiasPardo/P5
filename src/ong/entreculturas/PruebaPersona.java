/** La clase PruebaPersona prueba las clases Persona, Pervoluntario y PerVolInt
 *	creando nuevos empleados. Implementada parcialmente. Solo se pide el nombre
 *	y los apellidos.
 *
 *	@author Alberto González Casado
 *	@version 1.3
 */

package ong.entreculturas;

import ong.entreculturas.TipoVia;
import ong.entreculturas.Provincia;
import ong.entreculturas.Direccion;
import java.util.Scanner;

public class PruebaPersona {

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

	// Método para obtener la información (parcialmente implementado,
	// solo para probar la entrada de datos)

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
            "jgimenezmoreno@gmail.com", "101500045611", 1, 1, 68 );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( "\n" + perVoluntario.toString() );

        System.out.println( "\n--- Personal Voluntario Internacional:\n" );

        // Creamos un objeto Direccion, sobreescribiendo el campo de Persona

        setDireccionInt(new Direccion( tipoVia, "de Madrid", "192", "6º", "B", "izqda.", 
            "50017", provincia, "Zaragoza" ));

        // Creamos un objeto PerVoluntario y establecemos sus datos

        PerVolInternacional perVolInt = new PerVolInternacional( "Michael", "Johnson", "Smith", direccion, "555424687", 
            "mjohnsonsmith@gmail.com", "101501047821", 1, 1, 42, 1, "Estados Unidos",
            "Park Avenue, 323 - PO BOX: 505423 - New York (USA)", "+34" );

        // Obtenemos un String con los datos completos de la persona

        System.out.println( perVolInt.toString() ); 
        
    } // fin de main

} // fin de la clase PruebaPersona
