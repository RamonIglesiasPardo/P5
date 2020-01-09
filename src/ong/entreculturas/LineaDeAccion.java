package ong.entreculturas;

/**La Línea de acción asignada a un determinado proyecto.
 * @author Aware Developers
 * @version 1.2
 */

import java.util.*;

public class LineaDeAccion {

    private LineasDeAccionActivas tipoAccion;
    private List<SubLineaDeAccion> subLineasDeAccion;
    private String descripcion;

    /**Constructor.
     * @param tipoAccion Tipo de línea de acción.
     * @param subLineasDeAccion Sublínea de acción.
     * @param descripcion Descripción de la función de la línea de acción.
     */

    public LineaDeAccion(LineasDeAccionActivas tipoAccion, List<SubLineaDeAccion> subLineasDeAccion,
                         String descripcion) {
        this.tipoAccion = tipoAccion;
        this.subLineasDeAccion = subLineasDeAccion;
        this.descripcion = descripcion;
    }

    /**Constructor por defecto.
     *
     */
    public LineaDeAccion() {

    }

    public LineasDeAccionActivas getTipoAccion() { return tipoAccion; }

    public void setTipoAccion(LineasDeAccionActivas tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public List<SubLineaDeAccion> getSubLineasDeAccion() { return subLineasDeAccion; }

    public void setSubLineasDeAccion(List<SubLineaDeAccion> subLineasDeAccion) {
        this.subLineasDeAccion = subLineasDeAccion;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**Devuelve la representación String de un objeto LineaDeAccion.
     * @return representación String de un objeto LineaDeAccion.
     */

    @Override
    public String toString() {
        return String.format( "%s: %s\n%s: %s\n%s:\n%s",
        "Linea de acción", getTipoAccion(),
                "Sublíneas de acción:",  getSubLineasDeAccion(),
                "Descripción:", getDescripcion() );
    }
}


