package ong.entreculturas;



//Clase linea de acción representa un itinerario dentro de un proyecto.

import java.util.List;

public class LineaDeAccion {

private  LineasDeAccionActivas tipoAccion;
private List<SubLineaDeAccion> subLineasDeAccion;
private  String descripcion;

    //Constructor


    public LineaDeAccion(LineasDeAccionActivas tipoAccion, List<SubLineaDeAccion> subLineasDeAccion, String descripcion) {
        this.tipoAccion = tipoAccion;
        this.subLineasDeAccion = subLineasDeAccion;
        this.descripcion = descripcion;
    }




    //Métodos Setters y Getters de los atributos

    public LineasDeAccionActivas getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(LineasDeAccionActivas tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public List<SubLineaDeAccion> getSubLineasDeAccion() {
        return subLineasDeAccion;
    }

    public void setSubLineasDeAccion(List<SubLineaDeAccion> subLineasDeAccion) {
        this.subLineasDeAccion = subLineasDeAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Método ToString


    @Override
    public String toString() {
        return "LineaDeAccion{" +
                "tipoAccion=" + tipoAccion +
                ", subLineasDeAccion=" + subLineasDeAccion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


