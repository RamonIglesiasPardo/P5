// <<enum>> Provincia.java
// Lista con las provincias españolas.

package ong.entreculturas;

public enum Provincia {

	// declaramos las constantes de tipo enum

	CORU( "La Coruña" ),
	ALA ( "Álava" ),
	ALB ( "Albacete" ),
	ALI ( "Alicante" ),
	ALM ( "Almería" ),
	AST ( "Asturias" ),
	AVI ( "Ávila" ),
	BADJ( "Badajoz" ),
	BAL ( "Baleares" ),
	BAR ( "Barcelona" ),
	BUR ( "Burgos" ),
	CAC ( "Cáceres" ),
	CAD ( "Cádiz" ),
	CANT( "Cantabria" ),
	CAS ( "Castellón" ),
	CR  ( "Ciudad Real" ),
	COR ( "Córdoba" ),
	CUE ( "Cuenca" ),
	GER ( "Gerona" ),
	GRA ( "Granada" ),
	GUA ( "Guadalajara" ),
	GIP ( "Gipuzkoa" ),
	HUEL( "Huelva" ),
	HUES( "Huesca" ),
	JAEN( "Jaén" ),
	RIOJ( "La Rioja" ),
	PALM( "Las Palmas" ),
	LEON( "León" ),
	LER ( "Lérida" ),
	LUGO( "Lugo" ),
	MAD ( "Madrid" ),
	MAL ( "Málaga" ),
	MUR ( "Murcia" ),
	NAV (  "Navarra" ),
	OREN( "Orense" ),
	PAL ( "Palencia" ),
	PONT( "Pontevedra" ),
	SAL ( "Salamanca" ),
	SEG ( "Segovia" ),
	SEV ( "Sevilla" ),
	SOR ( "Soria" ),
	TARR( "Tarragona" ),
	TEN ( "Santa Cruz de Tenerife" ),
	TER ( "Teruel" ),
	TOL ( "Toledo" ),
	VAL ( "Valencia" ),
	VALL( "Valladolid" ),
	VIZ ( "Vizcaya" ),
	ZAM ( "Zamora" ),
	ZAR ( "Zaragoza" );

	// Variables de instancia

	private final String provincia;

	// Constructor de Provincia (por si hay que hacer modificaciones)

	Provincia( String pProvincia ) {

		provincia = pProvincia;

	} // fin del Constructor de Provincia

	// obtener la provincia

	public String getProvincia() {

		return provincia;

	} // fin del método getProvincia
 

} // fin de la enum Provincia