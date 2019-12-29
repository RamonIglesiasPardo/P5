package ong.entreculturas;

import ong.entreculturas.Direccion;

/** La clase PerVolInternacional es subclase directa de la clase
 *	PerVoluntario.
 *	Representa a un empleado voluntario internacional.
 *
 *	@author Alberto González Casado
 *  @version 1.3
 */
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

	}

	/** Constructor de PerVolInternacional
	 *
	 *  @param pNombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param pPrimerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pSegundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pDireccion Dirección de la persona (se pasa al constructor de la superclase)
	 *	@param pTelefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param pMail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param pIdPersonal Identificación de empleado (se pasa al constructor de la superclase)
	 *	@param pNumHorasVol Número de horas trabajadas por el voluntario
	 *	@param pIdVolIntCount Contador del número de voluntarios internacionales
	 *	@param pPaisOrigen País de origen del voluntario internacional
	 *	@param pSDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 *	@param pCodInternaTelefono Código (prefijo) internacional del teléfono
	 */
	public PerVolInternacional(
			String pNombre,
			String pPrimerApellido,
			String pSegundoApellido,
			Direccion pDireccion,
			String pTelefono,
			String pMail,
			int pNumHorasVol,
			String pPaisOrigen,
			String pSDireccion,
			String pCodInternaTelefono ) {

		// pasa los campos comunes al constructor de la superclase

		super( pNombre, pPrimerApellido, pSegundoApellido, pDireccion, pTelefono, pMail, pNumHorasVol );
 	
		idVolIntCount ++;
		paisOrigen = pPaisOrigen;
		direccion = pSDireccion;	// renombramos pDireccion para evitar ambigüedades
		codInternaTelefono = pCodInternaTelefono;			

	}

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
	public String getPaisOrigen() {

		return paisOrigen;

	} // fin del método getPaisOrigen
	// establece la dirección (sobreescribe al campo de la superclase Persona)

	public void setDireccion( String pSDireccion ) {

		direccion = pSDireccion;
		// estaría bien cambiar el campo direccion de la clase Persona con esta nueva
		// dirección, pero no sé cómo establecer la dirección en la clase Persona
		
	} // fin del método setDireccion

	// obtiene la dirección (sobreescrita)



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

	}

	// devuelve la representación String de un objeto PerVolInt
	// NOTA: modificar si implementamos la clase Sede
	// NOTA: debería mostrar el campo teléfono con el código internacional
	// y la dirección actualizada

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


} // fin de la clase PerVolInternacional