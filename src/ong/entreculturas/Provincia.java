/** Clase enum con la lista de las provincias españolas.
 * 
 *  @author Alberto González Casado
 *  @version 1.3
 */



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

	/** Constructor de Provincia
	 *
	 *	@param pProvinvia String con el nombre del objeto Provincia	
	 */

	Provincia( String provincia ) {

		this.provincia = provincia;

	} // fin del Constructor de Provincia

	/** Obtener el nombre de un objeto provincia
	 *
	 *	@return String con el nombre de un objeto provincia
	 */

	public String getProvincia() {

		return provincia;

	} // fin del método getProvincia

	/** Devuelve la representación String de un objeto Provincia
	 *
	 *	@return representación String de la provincia
	 */

	public String toString() {

		return String.format( "%s", getProvincia() );

	} // fin del método toString
 

} // fin de la enum Provincia