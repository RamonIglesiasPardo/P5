package ong.entreculturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.lang.Exception;

//Clase Proyecto

public class Proyecto {

    //variables de proyecto

    public int idProyecto = 1;
    private String pais;
    private String localizacion;
    //private LineaDeAccion lineaDeAccion;
    private Date fechaInicio;
    private Date fechaFin;
    //private List<Socio> socios;
    //private List<FinanciacionProyecto> financiacionProyectos;
    private String acciones;
    //private List<Personal> personal;

    // constructor de Proyecto

    public Proyecto( int idProyecto, String pais, String localizacion)  {

        this.idProyecto = idProyecto;
        this.pais = pais;
        this.localizacion = localizacion;
        //this.lineaDeAccion = lineaDeAccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        //List<Socio> socios = new ArrayList<Socio>;
        //List<FinanciacionProyectos> financiacionProyectos = new ArrayList<FinanciacionProyecto>;
        this.acciones =  acciones;
        //List<Personal> personal = new ArrayList<Personal>;

    } //Cerramos el constructor


    // Metodos

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto ++;
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

    //public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
    //    this.lineaDeAccion = lineaDeAccion;
    //}


    //public String getLineaDeAccion() {
    //    return lineaDeAccion;
    //}

    //public void setFechaInicio(Fecha fechaInicio) {
    //    this.fechaInicio = fechaInicio;
    //}


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

    //public void setPersonal(List<Personal> personal) {
    //    this.personal = personal;
    //}

    //public List<personal> getPersonal() {
    //    return personal;
    //}



}
