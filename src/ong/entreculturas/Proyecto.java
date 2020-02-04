package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Date;

/**La clase Proyecto representa un proyecto de la ONG Entreculturas.
 *
 * @author Aware Developers
 * @version 1.2
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {

    //variables de clase

    @XmlAttribute(name = "id")
    private int idProyecto;
    private static int idProyectoCount = 1;
    private String nombre;
    private String pais;
    private String localizacion;
    private LineaDeAccion lineaDeAccion;
    private Date fechaInicio;
    private Date fechaFin;
    private String acciones;
    @XmlElement(name = "personalAsignado")
    private List<Personal> personal;

    /**Constructor de Proyecto
     *
     * @param nombre nombre del proyecto
     * @param pais país en el que se desarrolla el proyecto
     * @param localizacion localización (localidad?) donde se desarrolla el proyecto
     * @param lineaDeAccion línea de acción asociada al proyecto
     * @param fechaInicio fecha de inicio del proyecto
     * @param fechaFin fecha de fin de proyecto
     * @param acciones acciones asociadas al proyecto
     * @param personal lista de personal que participa en el proyecto
     */

    public Proyecto( String nombre, String pais, String localizacion, LineaDeAccion lineaDeAccion,
                     Date fechaInicio, Date fechaFin, String acciones, List<Personal> personal)  {

        this.nombre = nombre;
        this.pais = pais;
        this.localizacion = localizacion;
        this.lineaDeAccion = lineaDeAccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.acciones =  acciones;
        this.personal = personal;
        //Asignamos automáticamente un id de proyecto autoincrementable al crear un proyecto
        idProyecto = idProyectoCount;
        idProyectoCount++;

    } //Cerramos el constructor

    /**Constructor por defecto de Proyecto
     *
     * */
    public Proyecto() {
        //Asignamos automáticamente un id de proyecto autoincrementable al crear un proyecto
        idProyecto = idProyectoCount;
        idProyectoCount++;
    }

    //Getters y Setters

    /**Getter de idProyecto
     *
     * @return int con el id del proyecto
     */

    public int getIdProyecto() {
        return idProyecto;
    }

    /**Getter del nombre del proyecto
     *
     * @return String con el nombre del proyecto
     */

    public String getNombre() {
        return nombre;
    }

    /**Setter del nombre del proyecto
     *
     * @param nombre String con el nombre del proyecto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**Setter de pais
     *
     * @param pais String con el país en el que se desarrolla el proyecto
     */

    public void setPais(String pais) {
        this.pais = pais;
    }


    /**Getter de pais
     *
     * @return String con el país en el que se desarrolla el proyecto
     */

    public String getPais() {
        return pais;
    }


    /**Setter de localizacion
     *
     * @param localizacion String con la localización del proyecto
     */

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    /**Getter de localizacion
     *
     * @return String con la localización del proyecto
     */

    public String getLocalizacion() {
        return localizacion;
    }

    /**Setter de lineaDeAccion
     *
     * @param lineaDeAccion Objeto LineaDeAccion asociado al proyecto
     */

    public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
        this.lineaDeAccion = lineaDeAccion;
    }


    /**Getter de lineaDeAccion
     *
     * @return Objeto LineaDeAccion asociado al proyecto
     */

    public LineaDeAccion getLineaDeAccion() {
        return lineaDeAccion;
    }


    /**Setter fechaInicio
     *
     * @param fechaInicio objeto Date con la fecha de inicio del proyecto
     */

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**Getter fechaInicio
     *
     * @return objeto Date con la fecha de inicio del proyecto
     */

    public Date getFechaInicio() {
        return fechaInicio;
    }


    /**Setter fechaFin
     *
     * @param fechaFin objeto Date con la fecha de fin del proyecto
     */

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    /**Getter fechaFin
     *
     * @return objeto Date con la fecha de fin del proyecto
     */

    public Date getFechaFin() {
        return fechaFin;
    }

    /**Setter acciones
     *
     * @param acciones String con las acciones asociadas al proyecto
     */

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    /**Getter acciones
     *
     * @return String con las acciones asociadas al proyecto
     */

    public String getAcciones() {
        return acciones;
    }

    /**Setter personal
     *
     * @param personal objeto Personal para lista de personal que participa en el proyecto
     */

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    /**Getter personal
     *
     * @return objeto Personal para lista de personal que participa en el proyecto
     */

    public List<Personal> getPersonal() {
       return personal;
    }

    //Métodos de clase

    /**ToString de Proyecto
     *
     * @return representación String de un Proyecto
     */

    @Override
    public String toString() {
        return  "Id del proyecto: " + idProyecto + "\n" +
                "Nombre del proyecto: " + nombre + "\n" +
                "Descripción: " + acciones + "\n" +
                "Ambito de acción del proyecto: " + localizacion + ", " + pais+ "\n" +
                "Fecha inicio: " + fechaInicio + "\n" +
                "Fecha finalización: " + fechaFin + "\n";
    }


}
