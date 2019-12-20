// <<data type>> Direccion.java
// Tipo de datos personalizado para las direcciones.

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

	// Constructor TipoVia

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

	// establecer el tipo de vía

	public void setTipoVia( TipoVia pTipoVia ) {

		tipoVia = pTipoVia;

	} // fin del método setTipoVia

	// obtener el tipo de vía

	public TipoVia getTipoVia() {

		return tipoVia;

	} // fin del método getTipoVia

	// establecer el nombre de la vía

	public void setNombreVia( String pNombreVia ) {

		nombreVia = pNombreVia;

	} // fin del método setNombreVia

	// obtener el nombre de la vía

	public String getNombreVia() {

		return nombreVia;

	} // fin del método getNombreVia

	// establecer el número de la dirección

	public void setNumero( String pNumero ) {

		numero = pNumero;

	} // fin del método setNumero

	// obtener el numero de la dirección

	public String getNumero() {

		return numero;

	} // fin del método getNombreVia

	// establecer el piso de la dirección

	public void setPiso( String pPiso ) {

		piso = pPiso;

	} // fin del método setPiso

	// obtener el piso de la dirección

	public String getPiso() {

		return piso;

	} // fin del método getPiso

	// establecer la puerta de la dirección

	public void setPuerta( String pPuerta ) {

		puerta = pPuerta;

	} // fin del método setPuerta

	// obtener la puerta de la dirección

	public String getPuerta() {

		return puerta;

	} // fin del método getPuerta

	// establecer la escalera de la dirección

	public void setEscalera( String pEscalera ) {

		escalera = pEscalera;

	} // fin del método setEscalera

	// obtener la escalera de la dirección

	public String getEscalera() {

		return escalera;

	} // fin del método getEscalera

	// establecer el código postal de la dirección

	public void setCodPostal( String pCodPostal ) {

		codPostal = pCodPostal;

	} // fin del método setCodPostal

	// obtener el código postal de la dirección

	public String getCodPostal() {

		return codPostal;

	} // fin del método getCodPostal

	// establecer la provincia

	public void setProvincia( Provincia pProvincia ) {

		provincia = pProvincia;

	} // fin del método setProvincia

	// obtener la provincia

	public Provincia getProvincia() {

		return provincia;

	} // fin del método getProvincia

	// establecer la localidad

	public void setLocalidad( String pLocalidad ) {

		localidad = pLocalidad;

	} // fin del método setLocalidad

	// obtener la localidad

	public String getLocalidad() {

		return localidad;

	} // fin del método getLocalidad

	// Devuelve la representación String de un objeto Direccion

	public String toString() {

		return String.format(
			"%s %s, %s %s%s %s %s\n%s %s (%s)",
			getTipoVia(), getNombreVia(), getNumero(), getPiso(), getPuerta(),
			"escalera", getEscalera(), getCodPostal(), getLocalidad(), 
			getProvincia() );

	} // fin del método toString

} // fin de la clase data type Direccion