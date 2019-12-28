<<<<<<< HEAD
// Clase PerVolInternacional.java
=======
/** La clase PerVolInternacional es subclase directa de la clase
 *	PerVoluntario.
 *	Representa a un empleado voluntario internacional.
 *
 *	@author Alberto González Casado
 *  @version 1.3
 */ 
>>>>>>> Persona

package ong.entreculturas;

import ong.entreculturas.Direccion;

public class PerVolInternacional extends PerVoluntario {

	private static int idVolIntCount = 1;
	private String paisOrigen;
	private String direccion;	// sobreescribe al campo de la superclase Persona
	private String codInternaTelefono;

<<<<<<< HEAD
	// Constructor de PerVoluntario con (catorce de momento) argumentos

	public PerVolInternacional( String pNombre, String pPrimerApellido, 
		String pSegundoApellido, Direccion pDireccion, 
		String pTelefono, String pMail, String pIdPersonal,
		int pIdCount, int pIdVolCount, int pNumHorasVol, int pIdVolIntCount,
		String pPaisOrigen, String pSDireccion, String pCodInternaTelefono ) {

		// pasa los campos comunes al constructor de la superclase

		super( pNombre, pPrimerApellido, pSegundoApellido, pDireccion, pTelefono, pMail, 
		pIdPersonal, pIdCount, pIdVolCount, pNumHorasVol );
 	
		idVolIntCount = pIdVolIntCount++;
		paisOrigen = pPaisOrigen;
		direccion = pSDireccion;	// renombramos pDireccion para evitar ambigüedades
		codInternaTelefono = pCodInternaTelefono;			

	} // fin del constructor de PerVoluntario con (catorce de momento) argumentos 

	// establece el pais de origen

	public void setPaisOrigen( String pPaisOrigen ) {

		paisOrigen = pPaisOrigen;

	} // fin del método setPaisOrigen

	// obtiene el pais de origen
=======
	/** Constructor de PerVolInternacional sin argumentos
	 *
	 */

	public PerVolInternacional() {

		super();

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
	 *	@param idCount Contador del número de empleados (se pasa al constructor de la superclase)
	 *  @param idVolCount Contador del número de empleados voluntarios
	 *	@param numHorasVol Número de horas trabajadas por el voluntario
	 *	@param idVolIntCount Contador del número de voluntarios internacionales
	 *	@param paisOrigen País de origen del voluntario internacional
	 *	@param sDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 *	@param codInternaTelefono Código (prefijo) internacional del teléfono
	 */

	public PerVolInternacional( String nombre, String primerApellido, 
		String segundoApellido, Direccion direccion, 
		String telefono, String mail, String idPersonal,
		int idCount, int idVolCount, int numHorasVol, int idVolIntCount,
		String paisOrigen, String sDireccion, String codInternaTelefono ) {

		// pasa los campos comunes al constructor de la superclase

		super( nombre, primerApellido, segundoApellido, direccion, telefono, mail, 
		idPersonal, idCount, idVolCount, numHorasVol );
 	
		PerVolInternacional.setIdVolIntCount(idVolIntCount++);
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
	
	/** Establece el número del conteo de este empleado voluntario internacional
	 * 
	 * @param idVolIntCount Contador del número de empleados voluntarios
	 */

	public static void setIdVolIntCount(int idVolIntCount) {
		PerVolInternacional.idVolIntCount = idVolIntCount;
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
>>>>>>> Persona

	public String getPaisOrigen() {

		return paisOrigen;

	} // fin del método getPaisOrigen

<<<<<<< HEAD
	// establece la dirección (sobreescribe al campo de la superclase Persona)

	public void setDireccion( String pSDireccion ) {

		direccion = pSDireccion;
		// estaría bien cambiar el campo direccion de la clase Persona con esta nueva
		// dirección, pero no sé cómo establecer la dirección en la clase Persona
		
	} // fin del método setDireccion

	// obtiene la dirección (sobreescrita)

	public String getDireccion() {
=======
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
>>>>>>> Persona

		return direccion;

	} // fin del método getDireccion

<<<<<<< HEAD
	// establece el código internacional del teléfono y lo concatena al campo 
	// teléfono de la superclase Persona

	public void setCodInternaTelefono( String pCodInternaTelefono ) {

		codInternaTelefono = pCodInternaTelefono;
		super.setTelefono( codInternaTelefono.concat( super.getTelefono() ) );

	} // fin del método setCodInternaTelefono

	// devuelve la representación String de un objeto PerVolInt
	// NOTA: modificar si implementamos la clase Sede
	// NOTA: debería mostrar el campo teléfono con el código internacional
	// y la dirección actualizada

	public String toString() {

		return String.format( "%s\n%s: %s\n%s: %d",
			 super.toString(), "País de origen", getPaisOrigen() );

	} // fin del método toString
 
=======
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

	/** Devuelve la representación String de un objeto PerVolInternacional
	 *  NOTA: modificar si implementamos la clase Sede
	 *  NOTA: debería mostrar el campo teléfono con el código internacional
	 *  y la dirección actualizada
	 *
	 *	@return La representación String de un objeto PerVolInternacional
	 */

	public String toString() {

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s%s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s",
			"Nombre", super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
			"Dirección", getDir(), "Teléfono", getCodInternaTelefono(), super.getTelefono(), "E-mail", super.getMail(),
			"Id de empleado", super.getId(), "Tipo de empleado", "personal voluntario internacional",
			"País de origen", getPaisOrigen(), "Número de horas como voluntario", super.getNumHorasVol() );

	} // fin del método toString

>>>>>>> Persona
} // fin de la clase PerVolInternacional