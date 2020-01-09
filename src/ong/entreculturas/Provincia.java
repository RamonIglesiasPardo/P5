package ong.entreculturas;

import java.util.Scanner;

/** Clase enum con la lista de las provincias españolas.
 *
 *  @author Aware Developers
 *  @version 1.4
 */
public enum Provincia {
	// declaramos las constantes de tipo enum
	CORU( "La Coruña" ),
	ALA ( "Alava" ),
	ALB ( "Albacete" ),
	ALI ( "Alicante" ),
	ALM ( "Almería" ),
	AST ( "Asturias" ),
	AVI ( "Avila" ),
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

	private final String provincia;

	/**Constructor
	 * @param provincia String con el nombre del objeto Provincia.
	 */
	Provincia( String provincia ) { this.provincia = provincia; }

	/**Obtener el nombre de un objeto provincia.
	 * @return String con el nombre de un objeto provincia.
	 */
	public String getProvincia() { return provincia; }

	/**Muestra por línea de comandos todas las provincias que contiene la clase enumerada.
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
			}
		}
	}

	/**Método que solicita la introducción de una Provincia al usuario.
	 * Préviamente muestra el listado de provincias que define el enumerado Provincia y despues solicita un
	 * entero que permitirá declarar la Provincia correspondiente.
	 * @param direccion recibe la instancia direccion que se esta creando.
	 * */
	public static void introducirProvincia(Direccion direccion) {
		// crea un objeto Scanner para obtener los datos
		Scanner entrada = new Scanner( System.in );
		// Mostramos las provincias que tiene nuestra clase Enumerada.
		Provincia.mostrarListadoProvincias();
		// Solicitamos el usuario introduzca un número de provincia válido
		System.out.println( "Seleccione un número de provincia:" );
		// Añadimos a la instancia "dirección" la provincia seleccionada
		direccion.setProvincia(Provincia.values()[entrada.nextInt()-1]);
	}

	/**Devuelve la representación String de un objeto Provincia
	 * @return representación String de la provincia
	 */

	public String toString() {
		return String.format( "%s", getProvincia() );
	}
}