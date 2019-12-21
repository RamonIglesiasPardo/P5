/** La clase Direccion es un tipo de datos personalizado para almacenar 
 *  una dirección, con campos prefijados.
 *	La clase importa las clases TipoVia y Provincia
 *
 *	@author Alberto González Casado
 */

package ong.entreculturas;

import ong.entreculturas.TipoVia;
import ong.entreculturas.Provincia;

public class Direccion {

	private TipoVia tipoVia;
	private String nombreVia;
	private String numero;
	private String piso;
	private String puerta;
	private String escalera;
	private String codPostal;
	private Provincia provincia;
	private String localidad;

	/** Constructor TipoVia
	 *
	 *	@param pTipoVia tipo de vía (utiliza la clase enum TipoVia)
	 *	@param pNombreVia nombre de la vía, calle, etc...
	 *	@param pNumero numero de la dirección del domicilio
	 *	@param pPiso piso de la dirección del domicilio
	 *	@param pPuerta letra de la puerta de la dirección del domicilio
	 *	@param pEscalera escalera de la dirección del domicilio
	 *	@param pCodPostal código postal
	 *	@param pProvincia provincia (utiliza la clase enum Provincia)
	 *	@param pLocalidad localidad 
	 */

	public Direccion( TipoVia pTipoVia, String pNombreVia, String pNumero, 
		String pPiso, String pPuerta, String pEscalera, String pCodPostal,
		Provincia pProvincia, String pLocalidad ) {

		tipoVia = pTipoVia;
		nombreVia = pNombreVia;
		numero = pNumero;
		piso = pPiso;
		puerta = pPuerta;
		escalera = pEscalera;
		codPostal = pCodPostal;
		provincia = pProvincia;
		localidad = pLocalidad;

	} // fin del constructor TipoVia

	/** Establece el tipo de vía (utiliza la clase enum TipoVia)
	 *
	 *	@param pTipoVia tipo de vía (utiliza la clase enum TipoVia)
	 */

	public void setTipoVia( TipoVia pTipoVia ) {

		tipoVia = pTipoVia;

	} // fin del método setTipoVia

	/** Obtiene el tipo de vía
	 *
	 *  @return el tipo de la vía (tipo personalizado TipoVia)
	 */

	public TipoVia getTipoVia() {

		return tipoVia;

	} // fin del método getTipoVia

	/** Establece el nombre de la vía
	 *
	 *	@param pNombreVia nombre de la vía, calle, etc...
	 */

	public void setNombreVia( String pNombreVia ) {

		nombreVia = pNombreVia;

	} // fin del método setNombreVia

	/** Obtiene el nombre de la vía
	 *
	 *	@return String con el nombre de la vía, calle, etc... 
	 */

	public String getNombreVia() {

		return nombreVia;

	} // fin del método getNombreVia

	/** Establece el número de la dirección
	 *
	 *	@param pNumero numero de la dirección del domicilio
	 */

	public void setNumero( String pNumero ) {

		numero = pNumero;

	} // fin del método setNumero

	/** Obtiene el número de la dirección
	 *
	 *	@return String con el número de la dirección
	 */

	public String getNumero() {

		return numero;

	} // fin del método getNombreVia

	/** Establece el piso de la dirección
	 *
	 *	@param pPiso piso de la dirección del domicilio
	 */

	public void setPiso( String pPiso ) {

		piso = pPiso;

	} // fin del método setPiso

	/** Obtiene el piso de la dirección
	 *
	 *	@return String con el piso de la dirección
	 */

	public String getPiso() {

		return piso;

	} // fin del método getPiso

	/** Establece la letra de la puerta de la dirección
	 *
	 *	@param pNumero  String con la letra de la puerta de la dirección del domicilio
	 */
	public void setPuerta( String pPuerta ) {

		puerta = pPuerta;

	} // fin del método setPuerta

	/** Obtiene la letra de la puerta de la dirección
	 *
	 *	@return String con la letra de la dirección
	 */

	public String getPuerta() {

		return puerta;

	} // fin del método getPuerta

	/** Establece la escalera de la dirección
	 *
	 *	@param pEscalera escalera de la dirección del domicilio
	 */

	public void setEscalera( String pEscalera ) {

		escalera = pEscalera;

	} // fin del método setEscalera

	/** Obtiene la escalera de la dirección
	 *
	 *	@return String con la escalera de la dirección
	 */

	public String getEscalera() {

		return escalera;

	} // fin del método getEscalera

	/** Establece el código postal de la dirección
	 *
	 *	@param pCodPostal código postal
	 */

	public void setCodPostal( String pCodPostal ) {

		codPostal = pCodPostal;

	} // fin del método setCodPostal

	/** Obtiene el código postal de la dirección
	 *
	 *	@return String con el código postal
	 */

	public String getCodPostal() {

		return codPostal;

	} // fin del método getCodPostal

	/** Establece la provincia (utiliza la clase enum provincia)
	 *
	 *	@param pProvincia provincia (tipo personalizado Provincia)
	 */

	public void setProvincia( Provincia pProvincia ) {

		provincia = pProvincia;

	} // fin del método setProvincia

	/** Obtiene la provincia
	 *
	 *	@return String con la provincia
	 */

	public Provincia getProvincia() {

		return provincia;

	} // fin del método getProvincia

	/** Establece la localidad
	 *
	 *	@param pLocalidad localidad
	 */

	public void setLocalidad( String pLocalidad ) {

		localidad = pLocalidad;

	} // fin del método setLocalidad

	/** Obtiene la localidad
	 *
	 *	@return String con la localidad
	 */

	public String getLocalidad() {

		return localidad;

	} // fin del método getLocalidad

	/** Devuelve la representación String de un objeto Direccion
	 *
	 *	@return representación String de un objeto Direccion
	 */

	@Override
	public String toString() {

		return String.format(
			"%s %s, %s %s%s %s %s\n%s %s (%s)",
			getTipoVia(), getNombreVia(), getNumero(), getPiso(), getPuerta(),
			"escalera", getEscalera(), getCodPostal(), getLocalidad(), 
			getProvincia() );

	} // fin del método toString

} // fin de la clase data type Direccion