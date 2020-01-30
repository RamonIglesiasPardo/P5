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
    CALIDAD ("Calidad"),
    UNIVERSALIZACION ("Universalización"),
    AYUDAHUMANITARIA ("Ayuda Humanitaria"),
    FORTALECIMIENTO ("Fortalecimiento"),
    TECNICA ("Técnica"),
    EDUDESAROLLO ("Educación para el desarollo"),
    EMERGENCIA ("Emergencia");

    //Variables de clase

    private String sublineaDeAccionActiva;

    /**Constructor SubLineasDeAccionActivas
     *
     * @param sublineaDeAccionActiva String con la subLineaDeAccion activa
     */
    SubLineasDeAccionActivas(String sublineaDeAccionActiva) {
        this.sublineaDeAccionActiva = sublineaDeAccionActiva;
    }

    /**Getter de subLineaDeAccionActiva
     *
     * @return String con la subLineaDeAccion activa
     */

    public String getSublineaDeAccionActiva() {
        return sublineaDeAccionActiva;
    }

    /**Setter de subLineaDeAccionActiva
     *
     * @param sublineaDeAccionActiva String con la subLineaDeAccion activa
     */

    public void setSublineaDeAccionActiva(String sublineaDeAccionActiva) {
        this.sublineaDeAccionActiva = sublineaDeAccionActiva;
    }
}
