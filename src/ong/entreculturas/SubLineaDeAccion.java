package ong.entreculturas;

/**La clase SubLineaDeAccion representa las sublíneas de acción asociadas
 * a una línea de acción de un proyecto.
 *
 * @author Aware Developers
 * @version 1.2
 */

public class SubLineaDeAccion {

   //Variables de clase

    private SubLineasDeAccionActivas areaDeAccion ;
    private LineaDeAccion lineaDeAccion ;
    private  String descripcion;

    /**Constructor SubLineaDeAccion
     *
     * @param areaDeAccion objeto SubLineasDeAccionActivas con las áreas de acción asociadas
     * @param lineaDeAccion objeto LineaDeAccion asociado a esta SubLineaDeAccion
     * @param descripcion Descripción de la sublínea de acción
     */

    public SubLineaDeAccion(SubLineasDeAccionActivas areaDeAccion, LineaDeAccion lineaDeAccion, String descripcion) {
        this.areaDeAccion = areaDeAccion;
        this.lineaDeAccion = lineaDeAccion;
        this.descripcion = descripcion;
    }

    //Métodos Setters y Getters

    /**Getter de areaDeAccion
     *
     * @return objeto SubLineasDeAccionActivas con las áreas de acción asociadas
     */

    public SubLineasDeAccionActivas getAreaDeAccion() {
        return areaDeAccion;
    }

    /**Setter de areaDeAccion
     *
     * @param areaDeAccion objeto SubLineasDeAccionActivas con las áreas de acción asociadas
     */

    public void setAreaDeAccion(SubLineasDeAccionActivas areaDeAccion) {
        this.areaDeAccion = areaDeAccion;
    }

    /**Getter de lineaDeAccion
     *
     * @return objeto LineaDeAccion asociado a esta SubLineaDeAccion
     */

    public LineaDeAccion getLineaDeAccion() {
        return lineaDeAccion;
    }

    /**Setter de lineaDeAccion
     *
     * @param lineaDeAccion objeto LineaDeAccion asociado a esta SubLineaDeAccion
     */

    public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
        this.lineaDeAccion = lineaDeAccion;
    }

    /**Getter de descripcion
     *
     * @return String con la descripción de la sublínea de acción
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**Setter de descripcion
     *
     * @param descripcion String con la descripción de la sublínea de acción
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Métods de clase

    /**ToString de SubLineaDeAccion
     *
     * @return representación String de la sublínea de acción
     */
    @Override
    public String toString() {
        return "SubLineaDeAccion{" +
                "areaDeAccion=" + areaDeAccion +
                ", lineaDeAccion=" + lineaDeAccion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    
}
