// Clase PerVolInternacional.java

package ong.entreculturas;

import ong.entreculturas.Direccion;

public class PerVolInternacional extends PerVoluntario {

	private static int idVolIntCount = 1;
	private String paisOrigen;
	private String direccion;	// sobreescribe al campo de la superclase Persona
	private String codInternaTelefono;

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

	public String getDireccion() {

		return direccion;

	} // fin del método getDireccion

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
 
} // fin de la clase PerVolInternacional