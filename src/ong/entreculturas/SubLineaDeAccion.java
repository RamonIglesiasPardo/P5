package ong.entreculturas;

/**Representa la sublínea de acción de una línea de acción.
 * @author Aware Developers
 * @version 1.2
 */

public class SubLineaDeAccion {

    private SubLineasDeAccionActivas areaDeAccion ;
    private LineaDeAccion lineaDeAccion ;
    private String descripcion;

    /**Constructor por defecto.
     *
     */

    public SubLineaDeAccion() {}

    /**Constructor.
     * @param areaDeAccion Tipo de sublínea de acción.
     * @param lineaDeAccion Línea de acción a la que se asigna esta sublínea de acción.
     * @param descripcion Descripción de la sublínea de acción.
     */

    public SubLineaDeAccion(SubLineasDeAccionActivas areaDeAccion,
                            LineaDeAccion lineaDeAccion, String descripcion) {
        this.areaDeAccion = areaDeAccion;
        this.lineaDeAccion = lineaDeAccion;
        this.descripcion = descripcion;
    }

    /**Obtiene el área de acción.
     * @return String con el área de acción.
     */

    public SubLineasDeAccionActivas getAreaDeAccion() { return areaDeAccion; }

    /**Establece el área de acción.
     * @param areaDeAccion
     */

    public void setAreaDeAccion(SubLineasDeAccionActivas areaDeAccion) {
        this.areaDeAccion = areaDeAccion;
    }

    /**Obtiene la línea de acción a la que se asigna esta sublínea de acción.
     * @return Objeto LineaDeAccion.
     */

    public LineaDeAccion getLineaDeAccion() { return lineaDeAccion; }

    /**Establece la línea de acción a la que se asigna esta sublínea de acción.
     * @param lineaDeAccion Objeto LineaDeAccion.
     */

    public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
        this.lineaDeAccion = lineaDeAccion;
    }

    /**Obtiene la descripción de la sublínea de acción.
     * @return String con descripción de la sublínea de acción.
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**Establece la descripción de la sublínea de acción.
     * @param descripcion
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**Devuelve la representación String de un objeto SubLineaDeAccion.
     * @return representación String de un objeto SubLineaDeAccion.
     */

    @Override
    public String toString() {
        return String.format( "%s: %s\n%s: %s\n%s:\n%s",
                "Linea de acción", getAreaDeAccion(),
                "Sublíneas de acción:",  getLineaDeAccion(),
                "Descripción:", getDescripcion() );
    }
}
