package ong.entreculturas;
import ong.entreculturas.Direccion;

/** La clase PerVoluntario es subclase directa de la clase Personal
 *	y tiene la subclase PerVolInternacional.
 *	Representa a un empleado voluntario
 *
 *	@author Alberto González Casado
 *  @version 1.3
 */
public class PerVoluntario extends Personal {

	private static int idVolCount = 1;
	private int numHorasVol;

	public PerVoluntario() {

		super();

	} // fin del constructor de PerVoluntario sin argumentos

	/** Constructor de PerVoluntario con todos los argumentos
	 *
	 *  @param pNombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param pPrimerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pSegundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pDireccion Dirección de la persona (se pasa al constructor de la superclase)
	 *	@param pTelefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param pMail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param pNumHorasVol Número de horas trabajadas por el voluntario
	 */
	public PerVoluntario(
			String pNombre,
			String pPrimerApellido,
			String pSegundoApellido,
			Direccion pDireccion,
			String pTelefono,
			String pMail,
			int pNumHorasVol ) {

		// pasa los campos comunes al constructor de la superclase

		super( pNombre, pPrimerApellido, pSegundoApellido, pDireccion, pTelefono, pMail, idVolCount);

		PerVoluntario.setIdVolCount(idVolCount++);
		this.numHorasVol = pNumHorasVol;

	}

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

	}

	/** Obtiene el número de horas trabajadas como voluntario
	 *
	 *	@return Int con el número de horas trabajadas
	 */
	public int getNumHorasVol() {

		return numHorasVol;

	}

	// devuelve la representación String de un objeto PerVol
	// NOTA: modificar si implementamos la clase Sede

	/** Devuelve la representación String de un objeto PerVoluntario
	 *  NOTA: modificar si implementamos la clase Sede
	 *
	 *	@return Representación String de un objeto PerVoluntario
	 */
	@Override
	public String toString() {

		return String.format( "%s\n%s: %s\n%s: %d",
			 super.toString(), "Tipo de empleado", "personal voluntario",
			 "Número de horas como voluntario", getNumHorasVol() );

	} // fin del método toString
 
} // fin de la clase PerVoluntario