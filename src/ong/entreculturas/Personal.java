// Clase Personal.java

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

	// Constructor de Personal con (ocho de momento) argumentos

	public Personal( String pNombre, String pPrimerApellido, 
		String pSegundoApellido, Direccion pDireccion, 
		String pTelefono, String pMail, String pIdPersonal,
		int pIdCount ) {

		// pasa los campos comunes al constructor de la superclase

		super( pNombre, pPrimerApellido, pSegundoApellido, pDireccion, pTelefono, pMail );

		idPersonal = pIdPersonal; 	
		idCount = pIdCount++;			

	} // fin del constructor de Personal con (ocho de momento) argumentos 

	// método protegido para crear un id de empleado
	// NOTA: este método equivale al setter de idPersonal

	protected void crearId( int idHijo, String idTpo ) {

		String a = Integer.toString( idHijo + 10000 );
		String b = Integer.toString( idCount + 10000 );
		idPersonal = a.concat(b).concat(idTpo);

	} // fin del método protegido crearId

	// obtiene el idPersonal

	public String getId() {

		return idPersonal;

	} // fin del método getId

	// obtiene el número de empleados

	public int getIdCount() {

		return idCount;

	} // fin del método getIdCount

	// devuelve la representación String de un objeto Persona
	// NOTA: modificar si implementamos la clase Sede

	public String toString() {

		return String.format( "%s\n%s: %s",
			 super.toString(), "Id de empleado",
			 getId() );

	} // fin del método toString

	// NOTA: ¿Implementamos algún método abstracto que nos sirva 
	// para las subclases (polimorfismo)?

} // fin de la clase abstracta Personal