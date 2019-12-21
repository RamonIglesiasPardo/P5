// Clase PerVoluntario.java

package ong.entreculturas;

public class PerVoluntario extends Personal {

	private static int idVolCount = 1;
	private int numHorasVol;

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

	public int getNumHorasVol() {

		return numHorasVol;

	} // fin del método getNumHorasVol

	// devuelve la representación String de un objeto PerVol
	// NOTA: modificar si implementamos la clase Sede

	public String toString() {

		return String.format( "%s\n%s: %s\n%s: %d",
			 super.toString(), "Tipo de empleado", "personal voluntario",
			 "Número de horas como voluntario", getNumHorasVol() );

	} // fin del método toString
 
} // fin de la clase PerVoluntario