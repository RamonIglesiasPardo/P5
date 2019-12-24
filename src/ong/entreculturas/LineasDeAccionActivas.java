/** La clase enum LineasDeAccionActivas es una enumeración de las
 * distintas lineas de acción de la ONG.
 */
package ong.entreculturas;

public enum LineasDeAccionActivas {

    //Variables

    COOPDESARROLLO ( "Cooperación al desarrollo" ),
    ACCIONHUMANITARIA ( "Acción Humanitaria" ),
    FORTINST ( "Fortaleimiento Institucional" ),
    EDUDESARROLLO ( "Educación para el desarrollo" );


    private String lineaDeAccionActiva;
    //¿¿¿Por definir algo más???

    //Constructor


    LineasDeAccionActivas(String lineaDeAccionActiva) {
        this.lineaDeAccionActiva = lineaDeAccionActiva;
    }

    //GETTER
    public String getLineaDeAccionActiva() {
        return lineaDeAccionActiva;
    }

    //SETTER
    public void setLineaDeAccionActiva(String lineaDeAccionActiva) {
        this.lineaDeAccionActiva = lineaDeAccionActiva;
    }
}
