package ong.entreculturas;

import java.util.Scanner;

/**La clase enum TipoVia es una enumeración de los distintos
 * tipos de vía que existen.
 * @author Aware Developers
 * @version 1.5
 */

public enum TipoVia {
	AVDA ( "Avenida" ),
	CALL ( "Calle" ),
	CAM	 ( "Camino" ),
	CARR ( "Carretera" ),
	PAS  ( "Paseo" ),
	PLA  ( "Plaza" ),
	RON  ( "Ronda" ),
	TRAV ( "Travesía" );

	private final String tipoVia;

	/**Constructor de TipoVia.
	 * @param tipoVia String con la clase de la vía.
	 */

	TipoVia( String tipoVia) { this.tipoVia = tipoVia; }

	/**Obtener el tipo de vía
	 * @return String con el tipo de la vía
	 */

	public String getTipoVia() { return tipoVia; }

	/**Muestra por línea de comandos todos los tipos de vía que contiene la clase enumerada.
	 * Se define como static porque es un método que se muestra de manera idéntica sea quien sea el
	 * objeto que lo llame.
	 */
	public static void mostrarListadoVias(){
		System.out.println( "Mostrando listado tipos de vía: " );
		// listamos los elementos de la lista de provincias según su orden
		for (TipoVia elemento : TipoVia.values()) {
			//Al igual que en un array la primera posición es 0, para no mostrar un listado que empiece en la posición 0
			//se compensa con el provincia.ordinal()+1.
			System.out.printf("%d:%s ",elemento.ordinal()+1, elemento);
		}
	}

	/**Método que solicita la introducción de un tipo de vía al usuario.
	 * Previamente muestra el listado de tipos de vía que define el enumerado TipoVia y despues solicita un
	 * entero que permitirá declarar el tipo de vía correspondiente.
	 * @param direccion recibe la instancia direccion que se esta creando.
	 */
	public static void introducirTipoVia(Direccion direccion) {
		Scanner entrada = new Scanner( System.in );
		// Mostramos los tipos de via que tiene nuestra clase Enumerada.
		TipoVia.mostrarListadoVias();
		System.out.println( "\nSeleccione un tipo de vía:" );
		// Añadimos a la instancia "dirección" la provincia seleccionada
		direccion.setTipoVia(TipoVia.values()[entrada.nextInt()-1]);
	}
	/**Devuelve la representación String del tipo de vía
	 * @return representación String del tipo de vía
	 */

	public String toString() {
		return String.format( "%s", getTipoVia() );
	}
}