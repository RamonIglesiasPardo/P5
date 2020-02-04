package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.Scanner;

/** La clase PerVoluntario es subclase directa de la clase Personal
 *	y tiene la subclase PerVolInternacional.
 *	Representa a un empleado voluntario
 *
 *	@author Aware Developers
 *  @version 1.6
 */

public class PerVoluntario extends Personal {

	//Variables de clase

	private int numHorasVol;

	/** Constructor por defecto
	 *
	 */
	public PerVoluntario() {
		super();
		//Al crear un personal voluntario el número de horas trabajadas es 0.
		setNumHorasVol(0);
	}

	/** Constructor de PerVoluntario
	 *
	 *  @param nombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param direccion Dirección de la persona (se pasa al constructor de la superclase)
	 *	@param telefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 */
	public PerVoluntario( String nombre, String primerApellido,
						  String segundoApellido, Direccion direccion,
						  String telefono, String mail) {

		// pasa los campos comunes al constructor de la superclase

		super( nombre, primerApellido, segundoApellido, direccion, telefono, mail);
		//Al crear un personal voluntario el número de horas trabajadas es 0.
		setNumHorasVol(0);

	}

	/**Constructor de PerVoluntario (para perVolInternacional)
	 *
	 * @param nombre nombre de la persona
	 * @param primerApellido primer apellido de la persona
	 * @param segundoApellido segundo apellido de la persona
	 * @param telefono teléfono de la persona
	 * @param mail mail de la persona
	 */

	public PerVoluntario(String nombre, String primerApellido, String segundoApellido, String telefono, String mail) {
		super (nombre, primerApellido, segundoApellido, telefono, mail);
	}

	//Getters y Setters

	/** Establece el número de horas trabajadas como voluntario
	 *
	 *	@param numHorasVol Número de horas trabajadas por el voluntario
	 */

	public void setNumHorasVol( int numHorasVol ) {

		this.numHorasVol = numHorasVol;

	}

	/** Obtiene el número de horas trabajadas como voluntario
	 *
	 *	@return Int con el número de horas trabajadas
	 */
	@XmlElement(name = "NumHorasVoluntariado")
	public int getNumHorasVol() {

		return numHorasVol;

	}

	//Métodos de clase

	/** Método para introducir los datos de la persona.
	 *  Es el método abstracto de la superclase, que aquí sí se implementa.
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
		//Al introducir los datos del nuevo personal voluntario, se nos da la opción de establecer
		//el número de horas de voluntariado
		System.out.print("Número de horas de voluntariado: ");
		setNumHorasVol( entrada.nextInt() );

	}

	/**Método para introducir la dirección de la persona.
	 * Es el método abstracto de las superclase, que aquí sí se implementa.
	 * @return objeto Direccion
	 */

	@Override
	public Direccion introducirDireccion() {

		// crea un objeto Scanner para obtener los datos
		Scanner entrada = new Scanner( System.in );
		// Creamos un objeto Direccion por defecto
		Direccion direccion = new Direccion();
		// Solicitamos la introducción de un tipo de via para añadirla a la instancia direccion.
		TipoVia.introducirTipoVia(direccion);
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
		Provincia.introducirProvincia(direccion);
		System.out.println( "Localidad: " );
		direccion.setLocalidad( entrada.nextLine() );

		return direccion;

	}

	/**Devuelve la representación String de un objeto PerVoluntario
	 *
	 * @return Representación String de un objeto PerVoluntario
	 */

	@Override
	public String toString() {

		return String.format( "%s\nTipo de empleado: personal voluntario" +
						"\nNúmero de horas de voluntariado: %d\n",
				super.toString(), getNumHorasVol() );

	}

}