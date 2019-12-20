// <<enum>> TipoVia.java
// Lista con los tipos de Vía en una dirección

package ong.entreculturas;

public enum TipoVia {

	AVDA ( "Avenida" ),
	CALL ( "Calle" ),
	CAM	 ( "Camino" ),
	CARR ( "Carretera" ),
	PAS  ( "Paseo" ),
	PLA  ( "Plaza" ),
	RON  ( "Ronda" ),
	TRAV ( "Travesía" );

	// Variables de instancia

	private final String tipoVia;

	// Constructor de TipoVía

	TipoVia( String pTipoVia) {

		tipoVia = pTipoVia;

	} // fin del constructor de TipoVia

	// obtener el tipo de vía

	public String getTipoVia() {

		return tipoVia;

	} // fin del método getTipoVia

} // fin de la enum TipoVia