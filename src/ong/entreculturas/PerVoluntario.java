<<<<<<< HEAD
// Clase PerVoluntario.java

package ong.entreculturas;

=======
/** La clase PerVoluntario es subclase directa de la clase Personal
 *	y tiene la subclase PerVolInternacional.
 *	Representa a un empleado voluntario
 *
 *	@author Alberto González Casado
 *  @version 1.3
 */ 

package ong.entreculturas;

import ong.entreculturas.Direccion;

>>>>>>> Persona
public class PerVoluntario extends Personal {

	private static int idVolCount = 1;
	private int numHorasVol;

<<<<<<< HEAD
	// Constructor de PerVoluntario con (diez de momento) argumentos

	public PerVoluntario( String pNombre, String pPrimerApellido, 
		String pSegundoApellido, Direccion pDireccion, 
		String pTelefono, String pMail, String pIdPersonal,
		int pIdCount, int pIdVolCount, int pNumHorasVol ) {

		// pasa los campos comunes al constructor de la superclase

		super( pNombre, pPrimerApellido, pSegundoApellido, pDireccion, pTelefono, pMail, 
		pIdPersonal, pIdCount );
 	
		idVolCount = pIdVolCount++;
		numHorasVol = pNumHorasVol;			

	} // fin del constructor de PerVoluntario con (diez de momento) argumentos 

	// establece el número de horas trabajadas como voluntario

	public void setNumHorasVol( int pNumHorasVol ) {

		numHorasVol = pNumHorasVol;

	} // fin del método setNumHorasVol

	// obtiene el número de horas trabajadas como voluntario
=======
	/** Constructor de PerVoluntario sin argumentos 
	 *
	 */

	public PerVoluntario() {

		super();

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
 	
		PerVoluntario.setIdVolCount(idVolCount++);
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
>>>>>>> Persona

	public int getNumHorasVol() {

		return numHorasVol;

	} // fin del método getNumHorasVol

<<<<<<< HEAD
	// devuelve la representación String de un objeto PerVol
	// NOTA: modificar si implementamos la clase Sede

=======
	/** Devuelve la representación String de un objeto PerVoluntario
	 *  NOTA: modificar si implementamos la clase Sede
	 *
	 *	@return Representación String de un objeto PerVoluntario
	 */

	@Override
>>>>>>> Persona
	public String toString() {

		return String.format( "%s\n%s: %s\n%s: %d",
			 super.toString(), "Tipo de empleado", "personal voluntario",
			 "Número de horas como voluntario", getNumHorasVol() );

	} // fin del método toString
 
} // fin de la clase PerVoluntario