/** La clase abstracta Personal hereda de la clase Persona, y a su vez
 *	tiene las subclases PerEmpleado, PerColaborador y PerVoluntario.
 *	Representa a un empleado de la ONG (de cualquier tipo)
 *
 *	@author Alberto González Casado
 */

package ong.entreculturas;

// a falta de implementar la clase Proyecto
// import ong.entreculturas.Proyecto;

public abstract class Personal extends Persona {

	// a falta de implementar la clase Sede
	// private Sede delegacionAsignada;
	private String idPersonal;
	// variable de clase para contar el número de empleados
	private static int idCount = 1;
	// a falta de implementar la clase Proyecto	
	// declarar la variable tipo list de proyectosAsignados

	/** Constructor de Personal
	 *	
	 *  @param pNombre nombre de la persona (se pasa al constructor de la superclase)
	 *  @param pPrimerApellido primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pSegundoApellido segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param pDireccion dirección de la persona (se pasa al constructor de la superclase)
	 *	@param pTelefono teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param pMail correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param pIdPersonal identificación de empleado
	 *	@param pIdCount contador del número de empleados
	 */

	public Personal( String pNombre, String pPrimerApellido, 
		String pSegundoApellido, Direccion pDireccion, 
		String pTelefono, String pMail, String pIdPersonal,
		int pIdCount ) {

		// pasa los campos comunes al constructor de la superclase

		super( pNombre, pPrimerApellido, pSegundoApellido, pDireccion, pTelefono, pMail );

		idPersonal = pIdPersonal; 	
		idCount = pIdCount++;			

	} // fin del constructor de Personal

	/** Método protegido para crear un id de empleado
	 *	El identificador está formado por doce dígitos que representan
	 *	el número de incorporación como personal, el número de incorporación
	 *	como miembro del equipo y un dígito que identifique al equipo.
	 *	Por ejemplo, el id 1011501000721 sería:
	 *	Miembro #1150
	 *	Empleado #72
	 *  NOTA: este método equivale al setter de idPersonal
	 *
	 * 	@param idHijo identificador de la subclase
	 *	@param idTpo identificador del equipo
	 */

	protected void crearId( int idHijo, String idTpo ) {

		String a = Integer.toString( idHijo + 10000 );
		String b = Integer.toString( idCount + 10000 );
		idPersonal = a.concat(b).concat(idTpo);

	} // fin del método protegido crearId

	/** Obtiene el idPersonal
	 *
	 *	@return String con el id de personal
	 */

	public String getId() {

		return idPersonal;

	} // fin del método getId

	/** Obtiene el número de empleado (por incorporación)
	 *
	 *	@return int con el número de empleado (por incorporación)
	 */

	public int getIdCount() {

		return idCount;

	} // fin del método getIdCount

	/** Devuelve la representación String de un objeto Personal
	 *  NOTA: modificar si implementamos la clase Sede
	 *
	 *	@return representación String de un objeto Personal
	 */

	@Override
	public String toString() {

		return String.format( "%s\n%s: %s",
			 super.toString(), "Id de empleado",
			 getId() );

	} // fin del método toString

	// NOTA: ¿Implementamos algún método abstracto que nos sirva 
	// para las subclases (polimorfismo)?

} // fin de la clase abstracta Personal