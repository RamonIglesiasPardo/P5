// clase Persona

package ong.entreculturas;

public abstract class Persona {

	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Direccion direccion;
	private String telefono;
	private String mail;

	// constructor de Persona con seis argumentos 

	public Persona( String pNombre, String pPrimerApellido, 
		String pSegundoApellido, Direccion pDireccion, 
		String pTelefono, String pMail ) {

		nombre = pNombre;
		primerApellido = pPrimerApellido;
		segundoApellido = pSegundoApellido;
		telefono = pTelefono;
		mail = pMail;

		} // fin del constructor de Persona con cinco argumentos

	// establece el nombre del empleado

	public void setNombre( String pNombre ) {

		nombre = pNombre;

	} // fin del método setNombre

	// obtiene el nombre del empleado

	public String getNombre() {

		return nombre;

	} // fin del método getNombre

	// establece el primer apellido del empleado

	public void setPrimerApellido( String pPrimerApellido ) {

		primerApellido = pPrimerApellido; 

	} // fin del método setPrimerApellido

	// obtiene el primer apellido del empleado

	public String getPrimerApellido() {

		return primerApellido;

	} // fin del método getPrimerApellido

	// establece el segundo apellido del empleado

	public void setSegundoApellido( String pSegundoApellido ) {

		segundoApellido = pSegundoApellido; 

	} // fin del método setSegundoApellido

	// obtiene el segundo apellido del empleado

	public String getSegundoApellido() {

		return segundoApellido;

	} // fin del método getSegundoApellido

	// establece el teléfono del empleado

	public void setTelefono( String pTelefono ) {

		telefono = pTelefono;

	} // fin del método setTelefono

	// obtiene el teléfono del empleado

	public String getTelefono() {

		return telefono;

	} // fin del método getTelefono

	// establece el correo electrónico del empleado

	public void setMail( String pMail ) {

		mail = pMail;

	} // fin del método setMail

	// obtiene el correo electrónico del empleado

	public String getMail() {

		return mail;

	} // fin del método getMail

	// devuelve la representación String de un objeto Persona

	public String toString() {

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s",
			"Nombre", getPrimerApellido(), getSegundoApellido(), getNombre(),
			"Teléfono", getTelefono(), "E-mail", getMail() );

	} // fin del método toString

	// NOTA: ¿Implementamos algún método abstracto que nos sirva 
	// para las subclases (polimorfismo)?


	 

} // fin de la clase abstracta Persona