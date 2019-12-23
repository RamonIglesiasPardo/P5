/** La clase enum TipoVia es una enumeración de los distintos
 *	tipos de vía que existen.
 *
 *	@author Alberto González Casado
 */

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

	/** Constructor de TipoVia
	 *
	 *	@param pTipoVia String con la clase de la via
	 */

	TipoVia( String pTipoVia) {

		tipoVia = pTipoVia;

	} // fin del constructor de TipoVia

	/** Obtener el tipo de vía
	 *
	 *	@return String con el tipo de la vía
	 */

	public String getTipoVia() {

		return tipoVia;

	} // fin del método getTipoVia

	/** Devuelve la representación String del tipo de vía
	 *
	 *	@return representación String del tipo de vía
	 */

	public String toString() {

		return String.format( "%s", getTipoVia() );

	} // fin del método toString

} // fin de la enum TipoVia