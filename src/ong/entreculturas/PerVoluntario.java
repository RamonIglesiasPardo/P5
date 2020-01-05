package ong.entreculturas;

import java.util.Scanner;

/** La clase PerVoluntario es subclase directa de la clase Personal
 *	y tiene la subclase PerVolInternacional.
 *	Representa a un empleado voluntario
 *
 *	@author Aware Developers
 *  @version 1.5
 */
public class PerVoluntario extends Personal {

	private static int idVolCount = 1;
	private int numHorasVol;

	/** Constructor de PerVoluntario sin argumentos
	 *
	 */
	public PerVoluntario() {

		super();
		super.crearId(idVolCount++, "1");

	} // fin del constructor de PerVoluntario sin argumentos

	/** Constructor de PerVoluntario con todos los argumentos
	 *
	 *  @param nombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param direccion Dirección de la persona (se pasa al constructor de la superclase)
	 *	@param telefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param idPersonal Identificación de empleado (se pasa al constructor de la superclase)
	 *	@param idCount Contador del número de empleados (se pasa al constructor de la superclase)
	 *  @param idVolCount Contador del número de empleados voluntarios
	 *	@param numHorasVol Número de horas trabajadas por el voluntario
	 */
	public PerVoluntario( String nombre, String primerApellido,
						  String segundoApellido, Direccion direccion,
						  String telefono, String mail, String idPersonal,
						  int idCount, int idVolCount, int numHorasVol ) {

		// pasa los campos comunes al constructor de la superclase

		super( nombre, primerApellido, segundoApellido, direccion, telefono, mail,
				idPersonal, idCount );

		super.crearId(idVolCount++, "1");
		this.numHorasVol = numHorasVol;

	} // fin del constructor de PerVoluntario con todos los argumentos

	/** Obtiene el número del conteo de este empleado voluntario
	 *
	 * @return Int con el número del conteo de este empleado voluntario
	 */
	public static int getIdVolCount() {
		return idVolCount;
	}

	/** Establece el número del conteo de este empleado voluntario
	 *
	 * @param idVolCount
	 */
	public static void setIdVolCount(int idVolCount) {
		PerVoluntario.idVolCount = idVolCount;
	}

	/** Establece el número de horas trabajadas como voluntario
	 *
	 *	@param numHorasVol Número de horas trabajadas por el voluntario
	 */
	public void setNumHorasVol( int numHorasVol ) {

		this.numHorasVol = numHorasVol;

	} // fin del método setNumHorasVol

	/** Obtiene el número de horas trabajadas como voluntario
	 *
	 *	@return Int con el número de horas trabajadas
	 */
	public int getNumHorasVol() {

		return numHorasVol;

	} // fin del método getNumHorasVol

	/** Método para introducir los datos de la persona.
	 *  Es el método abstracto de las superclases, que aquí sí se implementa.
	 *
	 */
	@Override
	public void introducirDatosPersona() {

		// crea un objeto Scanner para obtener los datos

		Scanner entrada = new Scanner( System.in );

		// Pide los datos al usuario

		System.out.print( "Nombre: " );
		super.setNombre( entrada.nextLine() );
		System.out.print( "Primer apellido: " );
		super.setPrimerApellido( entrada.nextLine() );
		System.out.print( "Segundo apellido: " );
		super.setSegundoApellido( entrada.nextLine() );
		super.setDireccion(introducirDireccion());
		System.out.print( "Teléfono: " );
		super.setTelefono( entrada.nextLine() );
		System.out.print( "E-mail: " );
		super.setMail( entrada.nextLine() );
		setNumHorasVol( 0 );

	} // fin del método introducirDatosPersona

	// Método para introducir la dirección

	@Override
	public Direccion introducirDireccion() {

		// crea un objeto Scanner para obtener los datos
		Scanner entrada = new Scanner( System.in );
		// Creamos un objeto Direccion por defecto
		Direccion direccion = new Direccion();
		// Creamos un array con los valores del enum TipoVia
		TipoVia arrTV[] = TipoVia.values();
		// Establecemos el tipo de vía según la opción escogida
		int via = introducirTipoVia();
		// Establecemos el valor del objeto TipoVia
		TipoVia tipoVia = arrTV[via - 1];
		// Asignamos el tipo de vía a la dirección
		direccion.setTipoVia(tipoVia);
		System.out.println( "Nombre de la vía: " );
		direccion.setNombreVia( entrada.nextLine() );
		System.out.println( "Número: " );
		direccion.setNumero( entrada.nextLine() );
		System.out.println( "Piso: " );
		direccion.setPiso( entrada.nextLine() );
		System.out.println( "Puerta: " );
		direccion.setPuerta( entrada.nextLine() );
		System.out.println( "Escalera: " );
		direccion.setEscalera( entrada.nextLine() );
		System.out.println( "Código postal: " );
		direccion.setCodPostal( entrada.nextLine() );
		// Solicitamos la introducción de una povincia para añadirla a la instancia direccion.
		Provincia.introducirProvincia(entrada, direccion);
		System.out.println( "Localidad: " );
		direccion.setLocalidad( entrada.next() );

		return direccion;

	} // fin del método introducirDireccion

	public static int introducirTipoVia() {

		// crea un objeto Scanner para obtener los datos
		Scanner entrada = new Scanner( System.in );

		System.out.println( "Introduzca el tipo de vía: " );

		// listamos los elementos de la lista de tipos de vía según su orden

		for ( int i = 0; i < TipoVia.values().length; i++ )
			System.out.printf( "%d:%s ", i + 1, TipoVia.values()[i] );

		System.out.print( "\n>>> " );
		return entrada.nextInt();

	} // fin del método introducirTipoVia

	// Método para introducir la provincia

	@Override
	public String toString() {

		return String.format( "%s\n%s: %s\n%s: %d",
				super.toString(), "Tipo de empleado", "personal voluntario",
				"Número de horas como voluntario", getNumHorasVol() );

	} // fin del método toString

} // fin de la clase PerVoluntario