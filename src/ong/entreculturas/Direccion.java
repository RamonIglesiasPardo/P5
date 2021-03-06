package ong.entreculturas;

/**La clase Direccion es un tipo de datos personalizado para almacenar
 * una dirección, con campos prefijados.
 * La clase importa las clases TipoVia y Provincia.
 * @author Aware Developers
 * @version 1.5
 */

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

	// Constructor Direccion por defecto
	Direccion() {}

	/**Constructor Direccion
	 * @param tipoVia Tipo de vía (utiliza la clase enum TipoVia).
	 * @param nombreVia Nombre de la vía, calle, etc...
	 * @param numero Número de la dirección del domicilio.
	 * @param piso Piso de la dirección del domicilio.
	 * @param puerta Letra de la puerta de la dirección del domicilio.
	 * @param escalera Escalera de la dirección del domicilio.
	 * @param codPostal Código postal.
	 * @param provincia Provincia (utiliza la clase enum Provincia).
	 * @param localidad Localidad.
	 */

	public Direccion( TipoVia tipoVia, String nombreVia, String numero, 
			String piso, String puerta, String escalera, String codPostal,
			Provincia provincia, String localidad ) {

		this.tipoVia = tipoVia;
		this.nombreVia = nombreVia;
		this.numero = numero;
		this.piso = piso;
		this.puerta = puerta;
		this.escalera = escalera;
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.localidad = localidad;
	}

	/**Establece el tipo de vía (utiliza la clase enum TipoVia).
	 * @param tipoVia Tipo de vía (utiliza la clase enum TipoVia).
	 */
	public void setTipoVia( TipoVia tipoVia ) { this.tipoVia = tipoVia;	}

	/**Obtiene el tipo de vía.
	 * @return El tipo de la vía (tipo personalizado TipoVia).
	 */

	public TipoVia getTipoVia() { return tipoVia; }

	/**Establece el nombre de la vía.
	 * @param nombreVia Nombre de la vía, calle, etc...
	 */

	public void setNombreVia( String nombreVia ) {
		this.nombreVia = nombreVia;
	}

	/**Obtiene el nombre de la vía.
	 * @return String con el nombre de la vía, calle, etc...
	 */

	public String getNombreVia() { return nombreVia; }

	/**Establece el número de la dirección.
	 * @param numero Número de la dirección del domicilio.
	 */

	public void setNumero( String numero ) { this.numero = numero; }

	/**Obtiene el número de la dirección.
	 * @return String con el número de la dirección.
	 */

	public String getNumero() { return numero; }

	/**Establece el piso de la dirección.
	 * @param piso Piso de la dirección del domicilio.
	 */

	public void setPiso( String piso ) { this.piso = piso; }

	/**Obtiene el piso de la dirección.
	 * @return String con el piso de la dirección.
	 */

	public String getPiso() { return piso; }

	/**Establece la letra de la puerta de la dirección.
	 * @param puerta  String con la letra de la puerta de la dirección del domicilio.
	 */

	public void setPuerta( String puerta ) { this.puerta = puerta; }

	/**Obtiene la letra de la puerta de la dirección.
	 * @return String con la letra de la dirección.
	 */

	public String getPuerta() { return puerta; }

	/**Establece la escalera de la dirección.
	 * @param escalera Escalera de la dirección del domicilio.
	 */

	public void setEscalera( String escalera ) { this.escalera = escalera; }

	/**Obtiene la escalera de la dirección.
	 * @return String con la escalera de la dirección.
	 */

	public String getEscalera() { return escalera; }

	/**Establece el código postal de la dirección.
	 * @param codPostal Código postal.
	 */

	public void setCodPostal( String codPostal ) { this.codPostal = codPostal; }

	/**Obtiene el código postal de la dirección.
	 * @return String con el código postal.
	 */

	public String getCodPostal() { return codPostal; }

	/**Establece la provincia (utiliza la clase enum provincia).
	 * @param provincia Provincia (tipo personalizado Provincia).
	 */

	public void setProvincia( Provincia provincia ) { this.provincia = provincia; }

	/**Obtiene la provincia.
	 * @return String con la provincia.
	 */

	public Provincia getProvincia() { return provincia; }

	/**Establece la localidad.
	 *@param localidad Localidad.
	 */

	public void setLocalidad( String localidad ) { this.localidad = localidad; }

	/**Obtiene la localidad.
	 * @return String con la localidad.
	 */

	public String getLocalidad() { return localidad; }

	/**Devuelve la representación String de un objeto Direccion.
	 * @return representación String de un objeto Direccion.
	 */

	@Override
	public String toString() {
		return String.format(
			"%s %s, %s %s%s %s %s %s - %s, (%s)",
			getTipoVia(), getNombreVia(), getNumero(), getPiso(), getPuerta(),
			"escalera", getEscalera(), getCodPostal(), getLocalidad(), 
			getProvincia() );
	}
}