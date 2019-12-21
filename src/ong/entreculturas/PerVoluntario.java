/** La clase PerVoluntario es subclase directa de la clase Personal
 *	y tiene la subclase PerVolInternacional.
 *	Representa a un empleado voluntario
 *
 *	@author Alberto González Casado
 */ 

package ong.entreculturas;

public class PerVoluntario extends Personal {

	private static int idVolCount = 1;
	private int numHorasVol;

	/** Constructor de PerVoluntario
	 *
	 *  @param pNombre nombre de la persona (se pasa al constructor de la superclase)
	 *  @param pPrimerApellido primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pSegundoApellido segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pDireccion dirección de la persona (se pasa al constructor de la superclase)
	 *	@param pTelefono teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param pMail correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param pIdPersonal identificación de empleado (se pasa al constructor de la superclase) 
	 *	@param pIdCount contador del número de empleados (se pasa al constructor de la superclase)
	 *  @param pIdVolCount contador del número de empleados voluntarios
	 *	@param pNumHorasVol número de horas trabajadas por el voluntario
	 */

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

	/** Establece el número de horas trabajadas como voluntario
	 *
	 *	@param pNumHorasVol número de horas trabajadas por el voluntario
	 */

	public void setNumHorasVol( int pNumHorasVol ) {

		numHorasVol = pNumHorasVol;

	} // fin del método setNumHorasVol

	/** Obtiene el número de horas trabajadas como voluntario
	 *
	 *	@return int con el número de horas trabajadas
	 */

	public int getNumHorasVol() {

		return numHorasVol;

	} // fin del método getNumHorasVol

	/** Devuelve la representación String de un objeto PerVoluntario
	 *  NOTA: modificar si implementamos la clase Sede
	 *
	 *	@return representación String de un objeto PerVoluntario
	 */

	@Override
	public String toString() {

		return String.format( "%s\n%s: %s\n%s: %d",
			 super.toString(), "Tipo de empleado", "personal voluntario",
			 "Número de horas como voluntario", getNumHorasVol() );

	} // fin del método toString
 
} // fin de la clase PerVoluntario