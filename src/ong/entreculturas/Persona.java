/**
 * La clase Persona es una clase abstracta que representa una persona.
 * Tiene las subclases directas Personal y Socio (esta última no implementada).
 *
 * @author Alberto González Casado
 * @version 1.3
 */ 

package ong.entreculturas;

import ong.entreculturas.Direccion;

<<<<<<< HEAD
=======
// tengo mis dudas acerca de si Persona debe ser abstracta o no. En principio 
// debería serlo, pero si no implementamos al menos un método abstracto
// no deberíamos clasificarla como abstracta

>>>>>>> Persona
public abstract class Persona {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Direccion direccion;
	private String telefono;
	private String mail;

	/** Constructor de Persona (sin argumentos)
	 *
	 */

	public Persona() {

		super();

	} // fin del constructor de Persona sin argumentos

<<<<<<< HEAD
		nombre = pNombre;
		primerApellido = pPrimerApellido;
		segundoApellido = pSegundoApellido;
		//setDireccion( pDireccion );
		telefono = pTelefono;
		mail = pMail;
=======
	/** Constructor de Persona con todos los argumentos
	 *
	 *  @param nombre Nombre de la persona 
	 *  @param primerApellido Primer apellido de la persona
	 *	@param segundoApellido Segundo apellido de la persona
	 *	@param direccion Dirección de la persona (no definida aún)
	 *	@param telefono Teléfono de la persona
	 *	@param mail Correo electrónico de la persona
	 */
>>>>>>> Persona

	public Persona( String nombre, String primerApellido, 
		String segundoApellido, Direccion direccion, 
		String telefono, String mail ) {

		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		setDireccion( direccion );
		this.telefono = telefono;
		this.mail = mail;

		} // fin del constructor de Persona con todos los argumentos

	/** Establece el nombre de la persona
	 *
	 *	@param nombre nombre de la persona
	 */

	public void setNombre( String nombre ) {

		this.nombre = nombre;

	} // fin del método setNombre

	/** Obtiene el nombre de la persona
	 *
	 *	@return String con el nombre de la persona
	 */

	public String getNombre() {

		return nombre;

	} // fin del método getNombre

	/** Establece el primer apellido de la persona
	 *
	 *  @param primerApellido primer apellido de la persona
	 */
	public void setPrimerApellido( String primerApellido ) {

		this.primerApellido = primerApellido; 

	} // fin del método setPrimerApellido

	/** Obtiene el primer apellido de la persona
	 *
	 *	@return String con el primer apellido de la persona
	 */

	public String getPrimerApellido() {

		return primerApellido;

	} // fin del método getPrimerApellido

	/** Establece el segundo apellido de la persona
	 *
	 *	@param segundoApellido segundo apellido la persona
	 */

	public void setSegundoApellido( String segundoApellido ) {

		this.segundoApellido = segundoApellido; 

	} // fin del método setSegundoApellido

	/** obtiene el segundo apellido de la persona
	 *
	 *	@return String con el segundo apellido de la persona
	 */

	public String getSegundoApellido() {

		return segundoApellido;

	} // fin del método getSegundoApellido

<<<<<<< HEAD
	// establece la dirección del empleado (utiliza el tipo de datos Direccion)
	// No sé cómo establecer la dirección desde aquí... la clase Direccion tiene 
	// métodos para establecer cada uno de los campos pero no sé cómo pasar el objeto
	// dirección a esta clase Persona
	
	//public Direccion setDireccion( pDireccion ) {

	//	dirección = 

	//	} // fin del método setDireccion

	// establece el teléfono del empleado
=======
	/** Establece la dirección del empleado (utiliza el tipo de datos Direccion)
	 *
	 *	@param direccion nombre del objeto Direccion
	 */

	public void setDireccion( Direccion direccion ) {
>>>>>>> Persona

		this.direccion = direccion;

		} // fin del método setDireccion

	/** Obtiene la dirección del empleado (utiliza el tipo de datos Direccion)
	 *
	 *	@return un objeto Direccion
	 */
	 	
	public Direccion getDireccion() {

		return direccion;

		} // fin del método getDireccion

	/** Establece el teléfono de la persona
	 *
	 *	@param telefono teléfono de la persona
	 */

	public void setTelefono( String telefono ) {

		this.telefono = telefono;

	} // fin del método setTelefono

	/** Obtiene el teléfono de la persona
	 *
	 *	@return String con el teléfono de la persona
	 */

	public String getTelefono() {

		return telefono;

	} // fin del método getTelefono

	/** establece el correo electrónico de la persona
	 *
	 *	@param mail correo electrónico de la persona
	 */

	public void setMail( String mail ) {

		this.mail = mail;

	} // fin del método setMail

	/** Obtiene el correo electrónico de la persona
	 *
	 *	@return String con el correo electrónico de la persona
	 */

	public String getMail() {

		return mail;

	} // fin del método getMail

	/** Devuelve la representación String de un objeto Persona
	 *
	 *	@return representación String de un objeto Persona
	 */

	public String toString() {

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s\n%s: %s",
			"Nombre", getPrimerApellido(), getSegundoApellido(), getNombre(),
			"Dirección", direccion.toString(),
			"Teléfono", getTelefono(), "E-mail", getMail() );

	} // fin del método toString

	// Podría implementarse al menos un método abstracto que nos permitiera
	// aplicar polimorfismo en las clases hijas	 

} // fin de la clase abstracta Persona