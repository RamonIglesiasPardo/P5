/**
 * La clase Persona es una clase abstracta que representa una persona.
 * Tiene las subclases directas Personal y Socio.
 *
 * @author Alberto González Casado
 */ 

package ong.entreculturas;

import ong.entreculturas.Direccion;

public abstract class Persona {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Direccion direccion;
	private String telefono;
	private String mail;

	/** Constructor de Persona
	 *
	 *  @param pNombre nombre de la persona 
	 *  @param pPrimerApellido primer apellido de la persona
	 *	@param pSegundoApellido segundo apellido de la persona
	 *	@param pDireccion dirección de la persona (no definida aún)
	 *	@param pTelefono teléfono de la persona
	 *	@param pMail correo electrónico de la persona
	 */

	@Override
	public Persona( String pNombre, String pPrimerApellido, 
		String pSegundoApellido, Direccion pDireccion, 
		String pTelefono, String pMail ) {

		nombre = pNombre;
		primerApellido = pPrimerApellido;
		segundoApellido = pSegundoApellido;
		//setDireccion( pDireccion );
		telefono = pTelefono;
		mail = pMail;

		} // fin del constructor de Persona

	/** Establece el nombre de la persona
	 *
	 *	@param pNombre nombre de la persona
	 */

	public void setNombre( String pNombre ) {

		nombre = pNombre;

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
	 *  @param pPrimerApellido primer apellido de la persona
	 */
	public void setPrimerApellido( String pPrimerApellido ) {

		primerApellido = pPrimerApellido; 

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
	 *	@param pSegundoApellido segundo apellido la persona
	 */

	public void setSegundoApellido( String pSegundoApellido ) {

		segundoApellido = pSegundoApellido; 

	} // fin del método setSegundoApellido

	/** obtiene el segundo apellido de la persona
	 *
	 *	@return String con el segundo apellido de la persona
	 */

	public String getSegundoApellido() {

		return segundoApellido;

	} // fin del método getSegundoApellido

	// establece la dirección del empleado (utiliza el tipo de datos Direccion)
	// No sé cómo establecer la dirección desde aquí... la clase Direccion tiene 
	// métodos para establecer cada uno de los campos pero no sé cómo pasar el objeto
	// dirección a esta clase Persona
	
	//public Direccion setDireccion( pDireccion ) {

	//	dirección = 

	//	} // fin del método setDireccion

	/** Establece el teléfono de la persona
	 *
	 *	@param pTelefono teléfono de la persona
	 */

	public void setTelefono( String pTelefono ) {

		telefono = pTelefono;

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
	 *	@param pMail correo electrónico de la persona
	 */

	public void setMail( String pMail ) {

		mail = pMail;

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

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s",
			"Nombre", getPrimerApellido(), getSegundoApellido(), getNombre(),
			"Teléfono", getTelefono(), "E-mail", getMail() );

	} // fin del método toString

	// NOTA: ¿Implementamos algún método abstracto que nos sirva 
	// para las subclases (polimorfismo)?	 

} // fin de la clase abstracta Persona