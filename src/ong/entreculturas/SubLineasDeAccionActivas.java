/** La clase enum SubLineasDeAccionActivas es una enumeración de las
 * distintas lineas de acción de la ONG.
 *
 * @author Aware Developers
 * @version 1.2
 */
package ong.entreculturas;

public enum SubLineasDeAccionActivas {

    //Constantes enum

    PROMOCIONSOCIAL ("Promoción Social"),
    CALIDADAD ("Calidad"),
    UNIVERSALIZACIÓN ("Universalización"),
    AYUDAHUMANITARIA ("Ayuda Humanitaria"),
    FORTALECIMIENTO ("Fortalecimiento"),
    TÉCNICA ("Técnica"),
    EDUDESAROLLO ("Educación para el desarollo"),
    EMERGENCIA ("Emergencia");

    //Variables de clase

    private String sublineaDeAcciónActiva;

    /**Constructor SubLineasDeAccionActivas
     *
     * @param sublineaDeAcciónActiva String con la subLineaDeAccion activa
     */
    SubLineasDeAccionActivas(String sublineaDeAcciónActiva) {
        this.sublineaDeAcciónActiva = sublineaDeAcciónActiva;
    }

    /**Getter de subLineaDeAccionActiva
     *
     * @return String con la subLineaDeAccion activa
     */

    public String getSublineaDeAcciónActiva() {
        return sublineaDeAcciónActiva;
    }

    /**Setter de subLineaDeAccionActiva
     *
     * @param sublineaDeAcciónActiva String con la subLineaDeAccion activa
     */

    public void setSublineaDeAcciónActiva(String sublineaDeAcciónActiva) {
        this.sublineaDeAcciónActiva = sublineaDeAcciónActiva;
    }
}
