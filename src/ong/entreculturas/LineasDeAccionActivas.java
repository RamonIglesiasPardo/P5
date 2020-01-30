/**La clase enum LineasDeAccionActivas es una enumeración de las
 * distintas lineas de acción de la ONG.
 * @author Aware Developers
 * @version 1.2
 */
package ong.entreculturas;

public enum LineasDeAccionActivas {

    COOPDESARROLLO ( "Cooperación al desarrollo" ),
    ACCIONHUMANITARIA ( "Acción Humanitaria" ),
    FORTINST ( "Fortaleimiento Institucional" ),
    EDUDESARROLLO ( "Educación para el desarrollo" );

    private String lineaDeAccionActiva;
    //¿¿¿Por definir algo más???

    /**Constructor por defecto.
     *
     */

//    LineasDeAccionActivas() {
//        this();
//    }

    /**Constructor.
     * @param lineaDeAccionActiva String con la línea de acción activa
     */

    LineasDeAccionActivas(String lineaDeAccionActiva) {
        this.lineaDeAccionActiva = lineaDeAccionActiva;
    }

    /**Obtiene la línea de acción activa.
     * @return String con la línea de acción activa.
     */
    public String getLineaDeAccionActiva() { return lineaDeAccionActiva; }

    /**Establece la línea de acción activa.
     * @param lineaDeAccionActiva String con la línea de acción activa
     */
    public void setLineaDeAccionActiva(String lineaDeAccionActiva) {
        this.lineaDeAccionActiva = lineaDeAccionActiva;
    }
}