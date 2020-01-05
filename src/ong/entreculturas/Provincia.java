package ong.entreculturas;

/** Clase enum con la lista de las provincias españolas.
 *
 *  @author Aware Developers
 *  @version 1.4
 */
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
	 *	@param provincia String con el nombre del objeto Provincia
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

	/** Muestra por línea de comandos todas las provincias que contiene la clase enumerada.
	 * Además itroduce saltos de línea cada 10 provincias para facilitar una salida más leible.
	 * Se define como static porque es un método que se muestra de manera idéntica sea quien sea el
	 * objeto que lo llame.
	 *
	 * */
	public static void mostrarListadoProvincias(){

		System.out.println( "Mostrando listado de privincias: " );

		// listamos los elementos de la lista de provincias según su orden
		for (Provincia provincia : Provincia.values()) {
			//Al igual que en un array la primera posición es 0, para no mostrar un listado que empiece en la posición 0
			//se compensa con el provincia.ordinal()+1.
			System.out.printf("%d:%s ",provincia.ordinal()+1, provincia);

			//Si el número de elemento es múltiplo de 10 añadimos un salto de línea.
			if( (provincia.ordinal()+1)%10 == 0 ){
				System.out.println();
			};
		}

	}

	/** Devuelve la representación String de un objeto Provincia
	 *
	 *	@return representación String de la provincia
	 */
	public String toString() {

		return String.format( "%s", getProvincia() );

	} // fin del método toString
 

} // fin de la enum Provincia