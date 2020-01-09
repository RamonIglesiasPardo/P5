package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.*;

/**Representa un proyecto puesto en marcha por la ONG.
 * @author Aware Developers
 * @version 1.3
 */

@XmlRootElement(name = "proyecto")
@XmlAccessorType(XmlAccessType.NONE)
public class Proyecto {

    public int idProyecto;
    private String nombre;
    private String pais;
    private String localizacion;
    private LineaDeAccion lineaDeAccion;
    private Date fechaInicio;
    private Date fechaFin;
    //Por implementar las clases Socio y FinanciacionProyecto
    //private List<Socio> socios;
    //private List<FinanciacionProyecto> financiacionProyectos;
    private String acciones;
    private List<Personal> personal;

    /**Constructor
     * @param idProyecto Id del proyecto.
     * @param nombre Nombre del proyecto.
     * @param pais País en el que se desarrolla el proyecto.
     * @param localizacion
     * @param lineaDeAccion Línea de acción del proyecto.
     * @param fechaInicio Fecha de inicio del proyecto.
     * @param fechaFin Fecha de finalización del proyecto.
     * @param acciones Acciones a desarrollar en el proyecto.
     * @param personal Personal asignado al proyecto.
     */
    public Proyecto( int idProyecto, String nombre, String pais, String localizacion,
                     LineaDeAccion lineaDeAccion, Date fechaInicio, Date fechaFin,
                     String acciones, List<Personal> personal)  {

        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.pais = pais;
        this.localizacion = localizacion;
        this.lineaDeAccion = lineaDeAccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        //this.socios = socios;
        //this.financiacionProyectos = FinanciacionProyecto;
        this.acciones =  acciones;
        this.personal = personal;
    }

    /**Constructor por defecto de Proyecto
     *
     * */
    public Proyecto() {}

    /**Establece el id del proyecto.
     * @param idProyecto
     */

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto ;
    }

    /**Obtiene el id del proyecto.
     * @return Int con el id del proyecto.
     */

    @XmlAttribute(name = "id")
    public int getIdProyecto() { return idProyecto; }

    @XmlElement(name = "nombreProyecto")
    public String getNombre() {
        return nombre;
    }

    /**Establece el nombre del proyecto.
     * @param nombre
     */

    public void setNombre(String nombre) { this.nombre = nombre; }

    /**Establece el país en el que se desarrolla el proyecto.
     * @param pais
     */

    public void setPais(String pais) { this.pais = pais; }

    /**Obtiene el país en el que se desarrolla el proyecto.
     * @return String con el país en el que se desarrolla el proyecto.
     */

    @XmlElement(name = "paisProyecto")
    public String getPais() { return pais; }

    /**Establece la localización del proyecto.
     * @param localizacion
     */

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    /**Obtiene la localización del proyecto.
     * @return String con la localización del proyecto.
     */
    @XmlElement(name = "localizacion")
    public String getLocalizacion() { return localizacion; }

    /**Establece la línea de acción asignada al proyecto.
     * @param lineaDeAccion
     */
    public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
        this.lineaDeAccion = lineaDeAccion;
    }

    /**Obtiene la línea de acción asignada al proyecto.
     * @return String con la línea de acción asignada al proyecto.
     */

    @XmlElement(name = "lineaDeAccion")
    public LineaDeAccion getLineaDeAccion() { return lineaDeAccion; }

    /**Establece la fecha de inicio del proyecto.
     * @param fechaInicio
     */

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**Obtiene la fecha de inicio del proyecto.
     * @return Objeto Date con la fecha de inicio del proyecto.
     */

    @XmlElement(name = "fechaInicio")
    public Date getFechaInicio() { return fechaInicio; }


    /**Establece la fecha de finalización del proyecto.
     * @param fechaFin
     */

    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }


    //@XmlElement(name = fechaFin)
    public Date getFechaFin() { return fechaFin; }

//    public void setSocios(List<Socio> socios) {
//        this.socios = socios;
//    }
//
//    public List<Socio> getSocios() {
//        return socios;
//    }
//
//    public void setFinanciacionProyecto(List<FinanciacionProyecto> financiacionProyectos) {
//        this.financiacionProyectos = financiacionProyectos;
//    }
//
//    public List<FinanciacionProyecto> getFinanciacionProyectos() {
//        return financiacionProyectos;
//    }

    /**Establece las acciones que se desarrollan en el proyecto.
     * @param acciones
     */

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    /**Obtiene las acciones que se desarrollan en el proyecto.
     * @return String con las acciones que se desarrollan en el proyecto.
     */

    @XmlElement(name = "acciones")
    public String getAcciones() {
        return acciones;
    }

    /**Establece el personal asignado al proyecto.
     * @param personal
     */

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    /**Obtiene el personal asignado al proyecto.
     * @return el personal asignado al proyecto.
     */

    @XmlElement(name = "personalAsignado")
    public List<Personal> getPersonal() {
       return personal;
    }

    /**Obtiene la representación String de un objeto Proyecto.
     * @return la representación String de un objeto Proyecto.
     */

    @Override
    public String toString() {
        return  "Id del proyecto: " + getIdProyecto() + "\n" +
                "Nombre del proyecto: " + getNombre() + "\n" +
                "Descripción: " + getAcciones() + "\n" +
                "Ambito de acción del proyecto: " + getLocalizacion() + ", "
                + " (" + getPais() + ")\n" +
                "Fecha de inicio del proyecto: " + getFechaInicio() + "\n" +
                "Fechas finalización del proyecto : " + getFechaFin();
    }
}
