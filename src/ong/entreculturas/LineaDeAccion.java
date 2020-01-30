package ong.entreculturas;

import java.util.*;

/**La clase linea de acción representa un itinerario dentro de un proyecto.
 *
 * @author Aware Developers
 * @version 1.1
 */


public class LineaDeAccion {

private LineasDeAccionActivas tipoAccion;
private List<SubLineaDeAccion> subLineasDeAccion;
private String descripcion;

    /**Constructor
     *
     * @param tipoAccion Especifica el tipo de línea de acción.
     * @param subLineasDeAccion Especifica la(s) sublínea(s) de acción.
     * @param descripcion Descripción de la línea de acción y su función.
     */

    public LineaDeAccion(LineasDeAccionActivas tipoAccion, List<SubLineaDeAccion> subLineasDeAccion, String descripcion) {
        this.tipoAccion = tipoAccion;
        this.subLineasDeAccion = subLineasDeAccion;
        this.descripcion = descripcion;
    }

    /**Constructor por defecto
     *
     */

    public LineaDeAccion() {

    }

    //Métodos Setters y Getters de los atributos

    /**Getter de tipoAccion.
     *
     * @return Objeto LineasDeAccionActivas.
     */

    public LineasDeAccionActivas getTipoAccion() {
        return tipoAccion;
    }

    /**Setter de tipoAccion
     *
     * @param tipoAccion Especifica el tipo de línea de acción.
     */

    public void setTipoAccion(LineasDeAccionActivas tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    /**Getter de subLineasDeAccion.
     *
     * @return Objeto SubLineaDeAccion de la lista.
     */

    public List<SubLineaDeAccion> getSubLineasDeAccion() {
        return subLineasDeAccion;
    }

    /**Setter de subLineasDeAccion.
     *
     * @param subLineasDeAccion Especifica la(s) sublínea(s) de acción.
     */

    public void setSubLineasDeAccion(List<SubLineaDeAccion> subLineasDeAccion) {
        this.subLineasDeAccion = subLineasDeAccion;
    }

    /**Getter de descripcion.
     *
     * @return String con la descripción de la línea de acción y su función.
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**Setter de descripcion.
     *
     * @param descripcion Descripción de la línea de acción y su función.
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Métodos de clase

    /**toString de LineaDeAccion.
     *
     * @return Representación String de un objeto LineaDeAccion.
     */

    @Override
    public String toString() {
        return String.format("Línea de acción: %s\nSublínea(s) de acción: %s" +
                "\nDescripión: %s", tipoAccion, subLineasDeAccion, descripcion);
    }
}


