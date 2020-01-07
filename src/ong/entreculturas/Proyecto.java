package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Date;

//Clase Proyecto
@XmlRootElement(name = "proyecto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {

    //variables de proyecto

    @XmlAttribute(name = "id")
    public int idProyecto;
    private String pais;
    private String localizacion;
    private LineaDeAccion lineaDeAccion;
    private Date fechaInicio;
    private Date fechaFin;
    //private List<Socio> socios;
    //private List<FinanciacionProyecto> financiacionProyectos;
    private String acciones;
    @XmlElement(name = "personalAsignado")
    private List<Personal> personal;

    // constructor de Proyecto

    public Proyecto( int idProyecto, String pais, String localizacion, LineaDeAccion lineaDeAccion,
                     Date fechaInicio, Date fechaFin, String acciones, List<Personal> personal)  {

        this.idProyecto = idProyecto;
        this.pais = pais;
        this.localizacion = localizacion;
        this.lineaDeAccion = lineaDeAccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        //this.socios = socios;
        //this.financiacionProyectos = FinanciacionProyecto;
        this.acciones =  acciones;
        this.personal = personal;

    } //Cerramos el constructor

    /**Constructor por defecto de Proyecto
     *
     * */
    public Proyecto() {

    }


    // Metodos

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto ;
    }


    public int getIdProyecto() {
        return idProyecto;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }


    public String getPais() {
        return pais;
    }


    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }


    public String getLocalizacion() {
        return localizacion;
    }

    public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
        this.lineaDeAccion = lineaDeAccion;
    }


    public LineaDeAccion getLineaDeAccion() {
        return lineaDeAccion;
    }


    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }


    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }


    public Date getFechaFin() {
        return fechaFin;
    }

    //public void setSocios(List<Socio> socios) {
    //    this.socios = socios;
    //}

    //public List<Socio> getSocios() {
    //    return socios;
    //}

    //public void setFinanciacionProyecto(List<FinanciacionProyecto> financiacionProyectos) {
    //    this.financiacionProyectos = financiacionProyectos;
    //}

    //public List<FinanciacionProyecto> getFinanciacionProyectos() {
    //    return financiacionProyectos;
    //}

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }

    public List<Personal> getPersonal() {
       return personal;
    }



}
