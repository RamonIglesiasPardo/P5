/**La clase enum LineasDeAccionActivas es una enumeración de las
 * distintas lineas de acción de la ONG.
 *
 * @author Aware Developers
 * @version 1.1
 */

package ong.entreculturas;

public enum LineasDeAccionActivas {

    //Constantes enum

    COOPDESARROLLO ( "Cooperación al desarrollo" ),
    ACCIONHUMANITARIA ( "Acción Humanitaria" ),
    FORTINST ( "Fortaleimiento Institucional" ),
    EDUDESARROLLO ( "Educación para el desarrollo" );

    //Variables de clase

    private String lineaDeAccionActiva;

    /**Constructor
     *
     * @param lineaDeAccionActiva String con la línea de acción activa.
     */

    LineasDeAccionActivas(String lineaDeAccionActiva) {
        this.lineaDeAccionActiva = lineaDeAccionActiva;
    }

    /**Getter de lineaDeAccionActiva.
     *
     * @return String con la línea de acción activa.
     */

    public String getLineaDeAccionActiva() {
        return lineaDeAccionActiva;
    }

    /**Setter de lineaDeAccionActiva.
     *
     * @param lineaDeAccionActiva String con la línea de acción activa.
     */

    public void setLineaDeAccionActiva(String lineaDeAccionActiva) {
        this.lineaDeAccionActiva = lineaDeAccionActiva;
    }
}
