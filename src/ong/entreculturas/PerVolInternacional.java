package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.Scanner;

/** La clase PerVolInternacional es subclase directa de la clase
 *	PerVoluntario.
 *	Representa a un empleado voluntario internacional.
 *
 *	@author Aware Developers
 *  @version 1.5
 */

@XmlRootElement(name="perVolInternacional")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"dir", "paisOrigen", "codInternaTelefono"})
public class PerVolInternacional extends PerVoluntario {

	//Variables de clase

	private String paisOrigen;
	private String sDireccion;	// sobreescribe al campo de la superclase Persona
	private String codInternaTelefono;

	/** Constructor por defecto
	 *
	 */
	public PerVolInternacional() {
		super();
	}

	/** Constructor de PerVolInternacional
	 *
	 *  @param nombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param telefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param paisOrigen País de origen del voluntario internacional
	 *	@param sDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 *	@param codInternaTelefono Código (prefijo) internacional del teléfono
	 */

	public PerVolInternacional( String nombre, String primerApellido,
								String segundoApellido,	String telefono, String mail,
								String paisOrigen, String sDireccion, String codInternaTelefono ) {

		// pasa los campos comunes al constructor de la superclase

		super( nombre, primerApellido, segundoApellido,telefono, mail);
		this.paisOrigen = paisOrigen;
		this.sDireccion = sDireccion;	// renombramos pDireccion para evitar ambigüedades
		this.codInternaTelefono = codInternaTelefono;

	}

	//Getters y Setters

	/** Establece el pais de origen
	 *
	 *	@param paisOrigen País de origen del voluntario internacional
	 */

	public void setPaisOrigen( String paisOrigen ) {

		this.paisOrigen = paisOrigen;

	} // fin del método setPaisOrigen

	/** Obtiene el pais de origen
	 *
	 *	@return String con el país de origen del voluntario internacional
	 */

	@XmlElement(name = "paisOrigen")
	public String getPaisOrigen() {

		return paisOrigen;

	} // fin del método getPaisOrigen

	/** Establece la dirección (sobreescribe al campo de la superclase Persona)
	 *
	 *	@param sDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 */

	public void setDir( String sDireccion ) {

		this.sDireccion = sDireccion;

	} // fin del método setDireccion

	/** Obtiene la dirección (sobreescrita)
	 *
	 *	@return String con la nueva dirección
	 */

	@XmlElement(name = "dir")
	public String getDir() {

		return sDireccion;

	} // fin del método getDireccion

	/** Establece el código internacional del teléfono
	 *
	 *	@param codInternaTelefono Código (prefijo) internacional del teléfono
	 */

	public void setCodInternaTelefono( String codInternaTelefono ) {

		this.codInternaTelefono = codInternaTelefono;

	} // fin del método setCodInternaTelefono

	/** Obtiene el código internacional del teléfono
	 *
	 *	@return String con el código (prefijo) internacional del teléfono
	 */

	@XmlElement(name = "codInternaTelefono")
	public String getCodInternaTelefono() {

		return codInternaTelefono;

	} // fin del método setCodInternaTelefono

	//Métodos de clase

	/** Método para introducir los datos de la persona.
	 *  Es el método abstracto de la superclase, que aquí sí se implementa.
	 *
	 */
	//TODO:unificar con el método setDatosPerVolInternacional, y modificar las
	//llamadas a estos métodos en otras clases.

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
		System.out.print( "Teléfono: " );
		super.setTelefono( entrada.nextLine() );
		System.out.print( "E-mail: " );
		super.setMail( entrada.nextLine() );
		//Al introducir los datos del nuevo personal voluntario, se nos da la opción de establecer
		//el número de horas de voluntariado
		System.out.print("Número de horas de voluntariado: ");
		super.setNumHorasVol( entrada.nextInt() );

	}

	/** Método para establecer los datos específicos de un personal voluntario internacional
	 *
	 */

	//TODO:unificar con el método anterior

	public void setDatosPerVolInternacional() {

		Scanner entrada = new Scanner(System.in);

		System.out.print( "Dirección: " );
		setDir( entrada.nextLine() );
		System.out.print( "País: " );
		setPaisOrigen( entrada.nextLine() );
		System.out.print( "Prefijo telefónico internacional: " );
		setCodInternaTelefono( entrada.nextLine() );

	} // fin del método setDatosPerVolInternacional

	/** Devuelve la representación String de un objeto PerVolInternacional
	 *  NOTA: modificar si implementamos la clase Sede
	 *  NOTA: debería mostrar el campo teléfono con el código internacional
	 *  y la dirección actualizada
	 *
	 *	@return La representación String de un objeto PerVolInternacional
	 */

	//TODO:modificar una vez unificados los métodos anteriores

	public String toString() {

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s%s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n\n",
				"Nombre", super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
				"Dirección", getDir(), "Teléfono", getCodInternaTelefono(), super.getTelefono(), "E-mail", super.getMail(),
				"Id de empleado", super.getId(), "Tipo de empleado", "personal voluntario internacional",
				"País de origen", getPaisOrigen(), "Número de horas como voluntario", super.getNumHorasVol() );

	} // fin del método toString

} // fin de la clase PerVolInternacional