package ong.entreculturas;

import java.util.Scanner;
import ong.entreculturas.Direccion;

import javax.xml.bind.annotation.XmlRootElement;

/** La clase PerVolInternacional es subclase directa de la clase
 *	PerVoluntario.
 *	Representa a un empleado voluntario internacional.
 *
 *	@author Alberto González Casado
 *  @version 1.4
 */
@XmlRootElement(name = "TipoVol")
public class PerVolInternacional extends PerVoluntario {

	private static int idVolIntCount = 1;
	private String paisOrigen;
	private String direccion;	// sobreescribe al campo de la superclase Persona
	private String codInternaTelefono;

	/** Constructor de PerVolInternacional sin argumentos
	 *
	 */
	public PerVolInternacional() {

		super();
		super.crearId(idVolIntCount++, "1");

	} // fin del Constructor de PerVolInternacional sin argumentos

	/** Constructor de PerVolInternacional
	 *
	 *  @param nombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param direccion Dirección de la persona (se pasa al constructor de la superclase)
	 *	@param telefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param idPersonal Identificación de empleado (se pasa al constructor de la superclase)
	 *	@param numHorasVol Número de horas trabajadas por el voluntario
	 *	@param idVolIntCount Contador del número de voluntarios internacionales
	 *	@param paisOrigen País de origen del voluntario internacional
	 *	@param sDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 *	@param codInternaTelefono Código (prefijo) internacional del teléfono
	 */

	//TODO eliminar dirección, idVolIntCount y reflejarlo en un nuevo constructor en su super clase.
	public PerVolInternacional( String nombre, String primerApellido,
								String segundoApellido, Direccion direccion,
								String telefono, String mail, String idPersonal,
								int numHorasVol, int idVolIntCount,
								String paisOrigen, String sDireccion, String codInternaTelefono ) {

		// pasa los campos comunes al constructor de la superclase

		super( nombre, primerApellido, segundoApellido, direccion, telefono, mail,
				idPersonal, numHorasVol );
		super.crearId(idVolIntCount++, "1");
		this.paisOrigen = paisOrigen;
		this.direccion = sDireccion;	// renombramos pDireccion para evitar ambigüedades
		this.codInternaTelefono = codInternaTelefono;

	} // fin del constructor de PerVoluntario con todos los argumentos

	/** Obtiene el número del conteo de este empleado voluntario internacional
	 *
	 * @return Int con el número del conteo de este empleado voluntario internacional
	 */

	public static int getIdVolIntCount() {
		return idVolIntCount;
	}


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

	public String getPaisOrigen() {

		return paisOrigen;

	} // fin del método getPaisOrigen

	/** Establece la dirección (sobreescribe al campo de la superclase Persona)
	 *
	 *	@param sDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 */

	public void setDir( String sDireccion ) {

		this.direccion = sDireccion;

	} // fin del método setDireccion

	/** Obtiene la dirección (sobreescrita)
	 *
	 *	@return String con la nueva dirección
	 */

	public String getDir() {

		return direccion;

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

	public String getCodInternaTelefono() {

		return codInternaTelefono;

	} // fin del método setCodInternaTelefono

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
		setDatosPerVolInternacional();
		System.out.print( "Teléfono: " );
		super.setTelefono( entrada.nextLine() );
		System.out.print( "E-mail: " );
		super.setMail( entrada.nextLine() );
		super.crearId( 1150, "72" ); // TODO automatizar este punto
		super.setNumHorasVol( 120 ); // solo prueba: esta opción deberíamos ponerla como un método aparte


	} // fin del método introducirDatosPersona

	/** Método para establecer los datos específicos de un personal voluntario internacional
	 *
	 */

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

	public String toString() {

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s%s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n\n",
				"Nombre", super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
				"Dirección", getDir(), "Teléfono", getCodInternaTelefono(), super.getTelefono(), "E-mail", super.getMail(),
				"Id de empleado", super.getId(), "Tipo de empleado", "personal voluntario internacional",
				"País de origen", getPaisOrigen(), "Número de horas como voluntario", super.getNumHorasVol() );

	} // fin del método toString

} // fin de la clase PerVolInternacional