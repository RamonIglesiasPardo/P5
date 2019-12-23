/** La clase PerVolInternacional es subclase directa de la clase
 *	PerVoluntario.
 *	Representa a un empleado voluntario internacional.
 *
 *	@author Alberto González Casado
 */ 

package ong.entreculturas;

import ong.entreculturas.Direccion;

public class PerVolInternacional extends PerVoluntario {

	private static int idVolIntCount = 1;
	private String paisOrigen;
	private String direccion;	// sobreescribe al campo de la superclase Persona
	private String codInternaTelefono;

	/** Constructor de PerVolInternacional
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
	 *	@param pIdVolIntCount contador del número de voluntarios internacionales
	 *	@param pPaisOrigen país de origen del voluntario internacional
	 *	@param pSDireccion dirección internacional (sobreescribe al campo direccion de Persona)
	 *	@param pCodInternaTelefono código (prefijo) internacional del teléfono
	 */

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

	/** Establece el pais de origen
	 *
	 *	@param pPaisOrigen país de origen del voluntario internacional
	 */

	public void setPaisOrigen( String pPaisOrigen ) {

		paisOrigen = pPaisOrigen;

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
	 *	@param pSDireccion dirección internacional (sobreescribe al campo direccion de Persona)
	 */

	public void setDir( String pSDireccion ) {

		direccion = pSDireccion;
		// estaría bien cambiar el campo direccion de la clase Persona con esta nueva
		// dirección, pero no sé cómo establecer la dirección en la clase Persona
		
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
	 *	@param pCodInternaTelefono código (prefijo) internacional del teléfono
	 */

	public void setCodInternaTelefono( String pCodInternaTelefono ) {

		codInternaTelefono = pCodInternaTelefono;

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
	 *	@return la representación String de un objeto PerVolInternacional
	 */

	public String toString() {

		return String.format( "%s: %s %s, %s\n%s: %s\n%s: %s%s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s",
			"Nombre", super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
			"Dirección", getDir(), "Teléfono", getCodInternaTelefono(), super.getTelefono(), "E-mail", super.getMail(),
			"Id de empleado", super.getId(), "Tipo de empleado", "personal voluntario internacional",
			"País de origen", getPaisOrigen(), "Número de horas como voluntario", super.getNumHorasVol() );

	} // fin del método toString
 
} // fin de la clase PerVolInternacional